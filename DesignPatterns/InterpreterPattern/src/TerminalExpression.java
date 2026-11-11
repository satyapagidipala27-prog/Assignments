public class TerminalExpression implements AbstractExpression {
    private final int number;

    public TerminalExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
