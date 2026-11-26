import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class problem_3 {

    public static void main(String[] args) throws IOException {

        Path wordsFile = Paths.get("Lambda_and_streams", "src", "words.txt");
        if (!Files.exists(wordsFile)) {
            wordsFile = Paths.get("src", "words.txt");
        }
        if (!Files.exists(wordsFile)) {
            throw new FileNotFoundException("Could not find words.txt. Looked in "
                    + Paths.get("Lambda_and_streams", "src", "words.txt").toAbsolutePath()
                    + " and " + Paths.get("src", "words.txt").toAbsolutePath());
        }
        List<String> words = Files.readAllLines(wordsFile);

        // Step 2: Group words by first letter and count
        Map<Character, Long> result = words.stream()
                .filter(word -> !word.isBlank())
                .collect(Collectors.groupingBy(
                        word -> Character.toLowerCase(
                                word.charAt(0)
                        ),
                        TreeMap::new,
                        Collectors.counting()
                ));

        // Step 3: Print result
        result.forEach((letter, count) ->
                System.out.println(letter + " = " + count)
        );
    }
}