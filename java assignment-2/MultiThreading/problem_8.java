import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class LockConditionBuffer {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    LockConditionBuffer(int capacity) {
        this.capacity = capacity;
    }

    public void produce(int value) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (queue.size() == capacity) {
                notFull.await();
            }
            queue.add(value);
            System.out.println(Thread.currentThread().getName() + " produced: " + value);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            int value = queue.remove();
            System.out.println(Thread.currentThread().getName() + " consumed: " + value);
            notFull.signalAll();
            return value;
        } finally {
            lock.unlock();
        }
    }
}

public class problem_8 {

    private static final int PRODUCERS = 2;
    private static final int CONSUMERS = 2;
    private static final int ITEMS_PER_PRODUCER = 5;
    private static final int STOP = -1;

    public static void main(String[] args) throws InterruptedException {
        LockConditionBuffer buffer = new LockConditionBuffer(3);
        Thread[] producers = new Thread[PRODUCERS];
        Thread[] consumers = new Thread[CONSUMERS];

        for (int i = 0; i < CONSUMERS; i++) {
            consumers[i] = new Thread(() -> {
                try {
                    int value;
                    while ((value = buffer.consume()) != STOP) {
                        // Each item is reported by consume().
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Consumer-" + (i + 1));
        }

        for (int i = 0; i < PRODUCERS; i++) {
            final int producerId = i;
            producers[i] = new Thread(() -> {
                try {
                    for (int j = 1; j <= ITEMS_PER_PRODUCER; j++) {
                        buffer.produce(producerId * ITEMS_PER_PRODUCER + j);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Producer-" + (i + 1));
        }

        for (Thread consumer : consumers) {
            consumer.start();
        }
        for (Thread producer : producers) {
            producer.start();
        }
        for (Thread producer : producers) {
            producer.join();
        }

        for (int i = 0; i < CONSUMERS; i++) {
            buffer.produce(STOP);
        }
        for (Thread consumer : consumers) {
            consumer.join();
        }

        System.out.println("All producers and consumers completed.");
    }
}
