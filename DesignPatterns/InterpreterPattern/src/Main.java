public class Main {
    public static void main(String[] args) {
        // 10 + 5 * 2: the tree groups multiplication before addition.
        AbstractExpression multiplication = new NonTerminalExpression(
                new TerminalExpression(5),
                new TerminalExpression(2),
                '*'
        );
        AbstractExpression addition = new NonTerminalExpression(
                new TerminalExpression(10),
                multiplication,
                '+'
        );
        Context firstContext = new Context(addition);

        System.out.println("Expression: 10 + 5 * 2");
        System.out.println("Result: " + firstContext.evaluate());
        System.out.println();

        // (10 + 5) * 2: the tree groups addition before multiplication.
        AbstractExpression groupedAddition = new NonTerminalExpression(
                new TerminalExpression(10),
                new TerminalExpression(5),
                '+'
        );
        AbstractExpression groupedMultiplication = new NonTerminalExpression(
                groupedAddition,
                new TerminalExpression(2),
                '*'
        );
        Context secondContext = new Context(groupedMultiplication);

        System.out.println("Expression: (10 + 5) * 2");
        System.out.println("Result: " + secondContext.evaluate());
    }
}
