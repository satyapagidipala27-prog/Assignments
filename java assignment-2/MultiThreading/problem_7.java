
public class problem_7 {

    // Create a ThreadLocal variable
    static ThreadLocal<Integer> threadLocal =
            new ThreadLocal<>();

    public static void main(String[] args) {

        // Thread 1
        Thread t1 = new Thread(() -> {

            threadLocal.set(101);

            System.out.println(
                    Thread.currentThread().getName()
                            + " : " + threadLocal.get()
            );

        }, "Thread-1");

        // Thread 2
        Thread t2 = new Thread(() -> {

            threadLocal.set(102);

            System.out.println(
                    Thread.currentThread().getName()
                            + " : " + threadLocal.get()
            );

        }, "Thread-2");

        // Thread 3
        Thread t3 = new Thread(() -> {

            threadLocal.set(103);

            System.out.println(
                    Thread.currentThread().getName()
                            + " : " + threadLocal.get()
            );

        }, "Thread-3");

        // Start threads
        t1.start();

        t2.start();

        t3.start();
    }
}
