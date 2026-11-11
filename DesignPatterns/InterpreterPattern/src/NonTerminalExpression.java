public class NonTerminalExpression implements AbstractExpression {
    private final AbstractExpression left;
    private final AbstractExpression right;
    private final char operator;

    public NonTerminalExpression(AbstractExpression left, AbstractExpression right, char operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public int interpret() {
        int leftValue = left.interpret();
        int rightValue = right.interpret();

        switch (operator) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                if (rightValue == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return leftValue / rightValue;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
