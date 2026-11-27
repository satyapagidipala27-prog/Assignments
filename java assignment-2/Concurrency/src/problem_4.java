import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {

    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}

public class problem_4 {

    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();

        int numberOfThreads = 5;
        int incrementsPerThread = 1000;
        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final Counter Value: " + counter.getCount());
    }
}
