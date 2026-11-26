
import java.util.*;
import java.util.concurrent.locks.*;

class SharedBuffer1 {

    private Queue<Integer> queue = new LinkedList<>();

    private final int capacity = 5;

    // Create ReentrantLock
    private final ReentrantLock lock = new ReentrantLock();

    // Create Conditions
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    // Producer method
    public void produce(int value) throws InterruptedException {

        lock.lock();

        try {

            while (queue.size() == capacity) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " waiting: Buffer is full"
                );

                notFull.await();
            }

            queue.add(value);

            System.out.println(
                    Thread.currentThread().getName()
                            + " produced: " + value
            );

            // Notify waiting consumers
            notEmpty.signalAll();

        } finally {

            lock.unlock();
        }
    }

    // Consumer method
    public int consume() throws InterruptedException {

        lock.lock();

        try {

            while (queue.isEmpty()) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " waiting: Buffer is empty"
                );

                notEmpty.await();
            }

            int value = queue.poll();

            System.out.println(
                    Thread.currentThread().getName()
                            + " consumed: " + value
            );

            // Notify waiting producers
            notFull.signalAll();

            return value;

        } finally {

            lock.unlock();
        }
    }
}

public class problem_6 {

    public static void main(String[] args)
            throws InterruptedException {

        SharedBuffer buffer = new SharedBuffer();

        // Producer 1
        Thread p1 = new Thread(() -> {

            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }, "Producer-1");

        // Producer 2
        Thread p2 = new Thread(() -> {

            try {
                for (int i = 6; i <= 10; i++) {
                    buffer.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }, "Producer-2");

        // Consumer 1
        Thread c1 = new Thread(() -> {

            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }, "Consumer-1");

        // Consumer 2
        Thread c2 = new Thread(() -> {

            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }, "Consumer-2");

        // Start all threads
        p1.start();
        p2.start();

        c1.start();
        c2.start();

        // Wait for all threads to finish
        p1.join();
        p2.join();

        c1.join();
        c2.join();

        System.out.println("All tasks completed");
    }
}
