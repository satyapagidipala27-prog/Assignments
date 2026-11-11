public class Context {
    private final AbstractExpression expression;

    public Context(AbstractExpression expression) {
        this.expression = expression;
    }

    public int evaluate() {
        return expression.interpret();
    }
}
