abstract class Middleware {

    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String request);

    protected boolean checkNext(String request) {

        if (next == null) {
            return true;
        }

        return next.check(request);
    }
}