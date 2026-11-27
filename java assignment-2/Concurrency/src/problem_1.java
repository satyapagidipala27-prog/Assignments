class Counter {

    int count = 0;

    // Method-level synchronization
    public synchronized void methodSync() {

        count++;

        System.out.println(
                Thread.currentThread().getName()
                        + " - Method Sync Count: " + count
        );
    }

    // Object-level synchronization
    public void objectSync() {

        synchronized (this) {

            count++;

            System.out.println(
                    Thread.currentThread().getName()
                            + " - Object Sync Count: " + count
            );
        }
    }
}

public class problem_1 {

    public static void main(String[] args)
            throws InterruptedException {

        Counter counter = new Counter();

        // Thread 1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.methodSync();
            }
        }, "Thread-1");

        // Thread 2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.objectSync();
            }
        }, "Thread-2");

        // Start threads
        t1.start();
        t2.start();

        // Wait for both threads
        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.count);
    }
}