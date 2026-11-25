import java.util.ArrayList;

public class problem_1 {

    public static void main(String[] args) {

        System.out.println("Demonstrating OutOfMemoryError:");

        ArrayList<int[]> list = new ArrayList<>();

        try {
            while (true) {
                list.add(new int[1000000]);
            }
        }
        catch (OutOfMemoryError e) {
            list.clear();
            System.out.println("OutOfMemoryError occurred!");
        }

        // Prevention
        System.out.println("\nDemonstrating Prevention:");

        ArrayList<Integer> data = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            data.add(i);
        }

        System.out.println("Limited data stored successfully.");

        data.clear();

        System.out.println("Unnecessary references cleared.");
    }
}