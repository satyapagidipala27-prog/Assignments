class CounterLocks {

    // Locks this CounterLocks instance.
    public synchronized void objectLock() {
        System.out.println(Thread.currentThread().getName() + " acquired OBJECT lock");
        sleepBriefly();
        System.out.println(Thread.currentThread().getName() + " released OBJECT lock");
    }

    // Locks the CounterLocks class object, shared by all instances.
    public static synchronized void classLock() {
        System.out.println(Thread.currentThread().getName() + " acquired CLASS lock");
        sleepBriefly();
        System.out.println(Thread.currentThread().getName() + " released CLASS lock");
    }

    private static void sleepBriefly() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class problem_2 {

    public static void main(String[] args) throws InterruptedException {
        CounterLocks obj1 = new CounterLocks();
        CounterLocks obj2 = new CounterLocks();

        Thread t1 = new Thread(obj1::objectLock, "Thread-1");
        Thread t2 = new Thread(obj2::objectLock, "Thread-2");
        Thread t3 = new Thread(CounterLocks::classLock, "Thread-3");
        Thread t4 = new Thread(CounterLocks::classLock, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
