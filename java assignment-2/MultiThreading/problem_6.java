import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class WaitNotifyBuffer {

    private int value;
    private boolean available;

    public synchronized void put(int next) throws InterruptedException {
        while (available) {
            wait();
        }
        value = next;
        available = true;
        System.out.println("wait/notify produced: " + next);
        notifyAll();
    }

    public synchronized int take() throws InterruptedException {
        while (!available) {
            wait();
        }
        int result = value;
        available = false;
        notifyAll();
        return result;
    }
}

class LinkedQueueBuffer {

    private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public void put(int value) throws InterruptedException {
        queue.put(value);
        System.out.println("LinkedBlockingQueue produced: " + value);
    }

    public int take() throws InterruptedException {
        return queue.take();
    }
}

public class problem_6 {

    private static final int STOP = -1;

    public static void main(String[] args) throws InterruptedException {
        runWaitNotifyExample();
        runLinkedBlockingQueueExample();
    }

    private static void runWaitNotifyExample() throws InterruptedException {
        System.out.println("Producer-consumer with wait() and notifyAll():");
        WaitNotifyBuffer buffer = new WaitNotifyBuffer();
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.put(i);
                }
                buffer.put(STOP);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "WaitNotify-Producer");

        Thread consumer = new Thread(() -> {
            try {
                int value;
                while ((value = buffer.take()) != STOP) {
                    System.out.println("wait/notify consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "WaitNotify-Consumer");

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }

    private static void runLinkedBlockingQueueExample() throws InterruptedException {
        System.out.println("\nProducer-consumer with LinkedBlockingQueue:");
        LinkedQueueBuffer buffer = new LinkedQueueBuffer();
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.put(i);
                }
                buffer.put(STOP);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Queue-Producer");

        Thread consumer = new Thread(() -> {
            try {
                int value;
                while ((value = buffer.take()) != STOP) {
                    System.out.println("LinkedBlockingQueue consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Queue-Consumer");

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
