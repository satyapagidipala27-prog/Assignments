import java.util.*;
import java.util.stream.*;

public class problem_2 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Java",
                "Python",
                "C",
                "JavaScript",
                "Go",
                "SpringBoot",
                "HTML"
        );

        names.stream()
                .sorted((s1, s2) ->
                        s2.length() - s1.length())
                .limit(3)
                .forEach(System.out::println);
    }
}