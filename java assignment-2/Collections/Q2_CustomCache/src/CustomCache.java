
import java.util.HashMap;
import java.util.Map;

public class CustomCache<K, V> {

    // Internal HashMap to store cache entries
    private Map<K, V> cache;

    // Constructor
    public CustomCache() {
        cache = new HashMap<>();
        System.out.println("Cache created successfully!");
    }

    // Add a key-value pair to the cache
    public void add(K key, V value) {
        cache.put(key, value);
    }

    // Read a value using its key
    public V get(K key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        return null;
    }

    // Check whether a key exists
    public boolean contains(K key) {
        return cache.containsKey(key);
    }

    // Remove an entry from the cache
    public void remove(K key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            System.out.println("Key " + key + " removed successfully.");
        } else {
            System.out.println("Key " + key + " not found.");
        }
    }

    // Return the number of entries
    public int size() {
        return cache.size();
    }

    // Display all cache entries
    public void display() {
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            System.out.println(
                    "Key: " + entry.getKey() +
                            " | Value: " + entry.getValue()
            );
        }
    }

    // Clear the entire cache
    public void clear() {
        cache.clear();
        System.out.println("Cache cleared successfully!");
    }

    // Check whether cache is empty
    public boolean isEmpty() {
        return cache.isEmpty();
    }
}
