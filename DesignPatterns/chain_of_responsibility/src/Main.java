public class Main {

    public static void main(String[] args) {

        Middleware auth = new AuthenticationMiddleware();
        Middleware authorization = new AuthorizationMiddleware();
        Middleware logging = new LoggingMiddleware();
        Middleware validation = new ValidationMiddleware();

        auth.linkWith(authorization)
                .linkWith(logging)
                .linkWith(validation);

        String request = "authenticated admin";

        boolean result = auth.check(request);

        if (result) {
            System.out.println("\nRequest processed successfully!");
        } else {
            System.out.println("\nRequest rejected!");
        }
    }
}