import java.util.*;
import java.util.stream.*;

public class problem_6 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "java",
                "python",
                "springboot",
                "docker",
                "kafka"
        );

        names.stream()

                // Debug original strings
                .peek(s -> System.out.println(
                        "Original: " + s
                ))

                // Print string length
                .peek(s -> System.out.println(
                        "Length: " + s.length()
                ))

                // Convert to uppercase
                .map(s -> s.toUpperCase())

                // Debug modified strings
                .peek(s -> System.out.println(
                        "After uppercase: " + s
                ))

                // Print final result
                .forEach(s -> System.out.println(s + "\n"));
    }
}