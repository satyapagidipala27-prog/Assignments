
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Worker class
class Worker extends Thread {

    private BlockingQueue<Runnable> taskQueue;

    public Worker(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {

        while (true) {

            try {

                Runnable task = taskQueue.take();

                System.out.println(
                        Thread.currentThread().getName() +
                                " executing task"
                );

                task.run();

            } catch (InterruptedException e) {

                break;
            }
        }
    }
}

// Custom Thread Pool class
class CustomThreadPool {

    private BlockingQueue<Runnable> taskQueue;
    private Worker[] workers;

    public CustomThreadPool(int numberOfThreads) {

        taskQueue = new LinkedBlockingQueue<>();

        workers = new Worker[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {

            workers[i] = new Worker(taskQueue);

            workers[i].start();
        }
    }

    // Submit task to thread pool
    public void submit(Runnable task) {

        try {

            taskQueue.put(task);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }

    // Shutdown thread pool
    public void shutdown() {

        for (Worker worker : workers) {

            worker.interrupt();
        }
    }
}

// Main class
public class problem_2 {

    public static void main(String[] args) throws InterruptedException {

        // Create thread pool with 3 workers
        CustomThreadPool pool = new CustomThreadPool(3);

        // Submit 10 tasks
        for (int i = 1; i <= 10; i++) {

            final int taskNumber = i;

            pool.submit(() -> {

                System.out.println(
                        "Task " + taskNumber +
                                " executed by " +
                                Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Allow submitted tasks to finish before shutdown
        Thread.sleep(5000);

        pool.shutdown();
    }
}
