
import java.util.List;

public class SortingApplication {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java SortingApplication <ALGORITHM> <numbers>");
            System.out.println("Algorithms: BUBBLE, QUICK, MERGE, INSERTION, SELECTION");
            return;
        }

        // Read sorting algorithm
        String algorithm = args[0].toUpperCase();

        // Process input values
        InputProcessor processor = new InputProcessor();

        List<Integer> numbers = processor.getValidNumbers(args);
        List<String> invalidValues = processor.getInvalidValues(args);

        if (numbers.isEmpty()) {
            System.out.println("No valid integer values provided!");
            return;
        }

        System.out.println("\nSelected Algorithm: " + algorithm);

        System.out.println("Original Values: " + numbers);

        if (!invalidValues.isEmpty()) {
            System.out.println("Invalid Values Ignored: " + invalidValues);
        }

        // Convert List to array
        int[] arr = numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        // Execute sorting algorithm and measure time
        SortingService sortingService = new SortingService();

        try {
            long startTime = System.nanoTime();

            sortingService.sort(arr, algorithm);

            long endTime = System.nanoTime();

            long executionTime = endTime - startTime;

            System.out.println("\nSorted Values: " +
                    java.util.Arrays.toString(arr));

            System.out.println("Execution Time: " +
                    executionTime + " nanoseconds");

            System.out.println("Execution Time: " +
                    (executionTime / 1_000_000.0) + " milliseconds");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
