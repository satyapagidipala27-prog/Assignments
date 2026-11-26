
class Counter {

    private int count = 0;

    // Synchronized method
    public synchronized void accessMethod() {
        count++;
    }

    // Return final count
    public int getCount() {
        return count;
    }
}

public class practice {

    public static void main(String[] args)
            throws InterruptedException {

        Counter counter = new Counter();

        int numberOfThreads = 5;
        int callsPerThread = 1000;

        Thread[] threads = new Thread[numberOfThreads];

        // Create threads
        for (int i = 0; i < numberOfThreads; i++) {

            threads[i] = new Thread(() -> {

                for (int j = 0; j < callsPerThread; j++) {

                    counter.accessMethod();

                }

            });

        }

        // Start all threads
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].start();
        }

        // Wait for all threads
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }

        // Print final count
        System.out.println("Number of threads: " + numberOfThreads);

        System.out.println("Calls per thread: " + callsPerThread);

        System.out.println("Total method accesses: " + counter.getCount());
    }
}
