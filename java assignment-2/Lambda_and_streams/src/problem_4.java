import java.util.*;
import java.util.stream.*;

public class problem_4 {

    public static void main(String[] args) {

        // Nested list
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 6, 7),
                Arrays.asList(7, 8, 9)
        );

        // Flatten and remove duplicates
        List<Integer> result = numbers.stream()
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());

        // Print result
        System.out.println(result);
    }
}