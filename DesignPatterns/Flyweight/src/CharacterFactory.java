import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {

    private final Map<java.lang.Character, ConcreteCharacter> characterMap;

    public CharacterFactory() {
        this.characterMap = new HashMap<>();
    }

    public ConcreteCharacter getCharacter(char symbol) {

        if (characterMap.containsKey(symbol)) {
            return characterMap.get(symbol);
        }

        ConcreteCharacter character = new ConcreteCharacter(symbol);
        characterMap.put(symbol, character);

        return character;
    }

    public int getObjectCount() {
        return characterMap.size();
    }
}