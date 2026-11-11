
import java.util.ArrayList;
import java.util.List;

public class InputProcessor {

    public List<Integer> getValidNumbers(String[] args) {

        List<Integer> validNumbers = new ArrayList<>();

        // Start from index 1 because index 0 contains algorithm name
        for (int i = 1; i < args.length; i++) {

            try {
                int number = Integer.parseInt(args[i]);
                validNumbers.add(number);

            } catch (NumberFormatException e) {
                // Ignore invalid strings
            }
        }

        return validNumbers;
    }

    public List<String> getInvalidValues(String[] args) {

        List<String> invalidValues = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {

            try {
                Integer.parseInt(args[i]);

            } catch (NumberFormatException e) {
                invalidValues.add(args[i]);
            }
        }

        return invalidValues;
    }
}
