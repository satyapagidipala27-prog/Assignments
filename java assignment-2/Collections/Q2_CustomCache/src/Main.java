
public class Main {

    public static void main(String[] args) {

        // Create custom cache
        CustomCache<Integer, String> cache =
                new CustomCache<>();

        // Add 2000 entries
        System.out.println("\nAdding 2000 entries...");

        for (int i = 1; i <= 2000; i++) {
            cache.add(i, "Student" + i);
        }

        System.out.println("2000 entries added successfully!");

        // Display cache size
        System.out.println("\nCache Size: " + cache.size());

        // Read selected values
        System.out.println("\nReading cache values:");

        int[] keys = {101, 500, 1000, 1500, 2000};

        for (int key : keys) {

            String value = cache.get(key);

            if (value != null) {
                System.out.println(
                        "Key: " + key + " | Value: " + value
                );
            } else {
                System.out.println(
                        "Key: " + key + " | Value not found"
                );
            }
        }

        // Check whether keys exist
        System.out.println("\nChecking key existence:");

        System.out.println(
                "Key 500: " + cache.contains(500)
        );

        System.out.println(
                "Key 3000: " + cache.contains(3000)
        );

        // Remove an entry
        System.out.println("\nRemoving key 500...");

        cache.remove(500);

        System.out.println(
                "Cache Size: " + cache.size()
        );

        // Check removed key
        System.out.println(
                "Key 500 exists: " + cache.contains(500)
        );

        // Check whether cache is empty
        System.out.println(
                "\nIs cache empty? " + cache.isEmpty()
        );
    }
}
