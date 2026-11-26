public class problem_3 {
    static int a=0;
    static int b=0;
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            for (int i = 1; i <= 20; i++) {
                if(i%2==0) {
                    a+=i;
                    System.out.print(i + " ");
                }
            }
            System.out.println();

        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                if(i%2!=0) {
                    b+=i;
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        });
        Thread t3 = new Thread(() -> {
            System.out.println(a+b);

        });


        t1.start();
        t1.join();
        t2.start();


        t2.join();

        t3.start();
        t3.join();

        System.out.println("Main completed");
    }
}
