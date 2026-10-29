public class ConcreteCharacter implements Character {

    private final char symbol;

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void render(int row, int column) {
        System.out.println(
                "Character: " + symbol
                        + ", Position: (" + row + ", " + column + ")"
        );
    }
}