class AuthenticationMiddleware extends Middleware {

    @Override
    public boolean check(String request) {

        System.out.println("Checking authentication...");

        if (request.contains("authenticated")) {
            System.out.println("Authentication successful");
            return checkNext(request);
        }

        System.out.println("Authentication failed!");
        return false;
    }
}