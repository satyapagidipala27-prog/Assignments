class AuthorizationMiddleware extends Middleware {

    @Override
    public boolean check(String request) {

        System.out.println("Checking authorization...");

        if (request.contains("admin")) {
            System.out.println("Authorization successful");
            return checkNext(request);
        }

        System.out.println("Access denied!");
        return false;
    }
}