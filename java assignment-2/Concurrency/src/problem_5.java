
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class problem_5 {

    static ReentrantLock lockA = new ReentrantLock();
    static ReentrantLock lockB = new ReentrantLock();

    // Ensures both threads acquire their first lock
    static CountDownLatch ready = new CountDownLatch(2);

    // Thread 1: A -> B
    static class ThreadOne extends Thread {

        public void run() {

            lockA.lock();

            try {
                System.out.println("Thread 1 acquired Lock A");

                ready.countDown();
                ready.await();

                System.out.println("Thread 1 waiting for Lock B");

                lockB.lockInterruptibly();

                try {
                    System.out.println("Thread 1 acquired Lock B");
                } finally {
                    lockB.unlock();
                }

            } catch (InterruptedException e) {
                System.out.println("Thread 1 interrupted");

            } finally {
                lockA.unlock();
                System.out.println("Thread 1 released Lock A");
            }
        }
    }

    // Thread 2: B -> A
    static class ThreadTwo extends Thread {

        public void run() {

            lockB.lock();

            try {
                System.out.println("Thread 2 acquired Lock B");

                ready.countDown();
                ready.await();

                System.out.println("Thread 2 waiting for Lock A");

                lockA.lockInterruptibly();

                try {
                    System.out.println("Thread 2 acquired Lock A");
                } finally {
                    lockA.unlock();
                }

            } catch (InterruptedException e) {
                System.out.println(
                        "Thread 2 interrupted! Deadlock resolution started.");

            } finally {
                lockB.unlock();
                System.out.println("Thread 2 released Lock B");
            }
        }
    }

    // Detect deadlock using ThreadMXBean
    static boolean detectDeadlock() {

        ThreadMXBean bean =
                ManagementFactory.getThreadMXBean();

        long[] ids = bean.findDeadlockedThreads();

        if (ids != null) {

            System.out.println("\nDEADLOCK DETECTED!");

            for (long id : ids) {

                System.out.println(
                        bean.getThreadInfo(id));
            }

            return true;
        }

        return false;
    }

    public static void main(String[] args)
            throws InterruptedException {

        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();

        // Wait until both threads have acquired their first lock
        ready.await();

        System.out.println("\nChecking for deadlock...");

        boolean detected = false;

        // Wait until JVM reports the actual deadlock
        for (int i = 0; i < 50; i++) {

            if (detectDeadlock()) {
                detected = true;
                break;
            }

            Thread.sleep(100);
        }

        if (detected) {

            System.out.println(
                    "\nResolving deadlock by interrupting Thread-2");

            // Interrupt Thread-2 while it waits for Lock A
            t2.interrupt();

        } else {
            System.out.println("Deadlock was not detected.");
            t2.interrupt();
        }

        // Wait for both threads to finish
        t1.join();
        t2.join();

        System.out.println("\nDeadlock resolved!");
        System.out.println("Program completed.");
    }
}
