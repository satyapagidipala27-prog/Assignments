
class SharedBuffer {

    private int data;
    private boolean available = false;

    // Producer method
    public synchronized void produce(int value)
            throws InterruptedException {

        while (available) {
            wait(); // Wait if buffer is full
        }

        data = value;
        available = true;

        System.out.println("Produced: " + data);

        notify(); // Notify consumer
    }

    // Consumer method
    public synchronized void consume()
            throws InterruptedException {

        while (!available) {
            wait(); // Wait if buffer is empty
        }

        System.out.println("Consumed: " + data);

        available = false;

        notify(); // Notify producer
    }
}

public class problem_4 {

    public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer();

        // Producer thread
        Thread producer = new Thread(() -> {

            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });

        // Consumer thread
        Thread consumer = new Thread(() -> {

            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });

        producer.start();
        consumer.start();
    }
}
