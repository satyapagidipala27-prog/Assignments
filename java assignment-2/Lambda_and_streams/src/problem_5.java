import java.util.*;
import java.util.stream.*;

public class problem_5 {

    public static void main(String[] args) {

        List<Integer> numbers = new Random()
                .ints(10_000_000, 1, 1000)
                .boxed()
                .collect(Collectors.toList());

        // Step 2: Sequential stream
        long start1 = System.nanoTime();

        long sequentialSum = numbers.stream()
                .mapToLong(n -> n)
                .sum();

        long end1 = System.nanoTime();

        // Step 3: Parallel stream
        long start2 = System.nanoTime();

        long parallelSum = numbers.parallelStream()
                .mapToLong(n -> n)
                .sum();

        long end2 = System.nanoTime();

        // Step 4: Calculate execution times
        long sequentialTime = (end1 - start1) / 1_000_000;
        long parallelTime = (end2 - start2) / 1_000_000;

        // Step 5: Print results
        System.out.println("Sequential Sum: " + sequentialSum);
        System.out.println("Parallel Sum: " + parallelSum);

        System.out.println("Sequential Time: "
                + sequentialTime + " ms");

        System.out.println("Parallel Time: "
                + parallelTime + " ms");

        System.out.println("Sums are equal: "
                + (sequentialSum == parallelSum));
    }
}