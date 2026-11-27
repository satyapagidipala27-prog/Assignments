public class problem_5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.print(i + " ");
            }
            System.out.println();

        });
        Thread t2 = new Thread(() -> {
            for (int i = 6; i <= 10; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        });
        Thread t3 = new Thread(() -> {
            for (int i = 11; i <= 15; i++) {
                System.out.print(i + " ");
            }
            System.out.println();

        });


        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Main completed");
    }
}
