class LoggingMiddleware extends Middleware {

    @Override
    public boolean check(String request) {

        System.out.println("Logging request...");
        System.out.println("Request: " + request);

        return checkNext(request);
    }
}