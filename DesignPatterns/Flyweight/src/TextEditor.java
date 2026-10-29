public class TextEditor {

    public static void main(String[] args) {

        CharacterFactory factory = new CharacterFactory();

        String text = "BANANA";

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            ConcreteCharacter character =
                    factory.getCharacter(symbol);

            character.render(0, i);
        }

        System.out.println(
                "\nTotal characters: " + text.length()
        );

        System.out.println(
                "Distinct character objects created: "
                        + factory.getObjectCount()
        );
    }
}