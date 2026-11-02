class ValidationMiddleware extends Middleware {

    @Override
    public boolean check(String request) {

        System.out.println("Validating request...");

        if (!request.isEmpty()) {
            System.out.println("Validation successful");
            return checkNext(request);
        }

        System.out.println("Invalid request!");
        return false;
    }
}