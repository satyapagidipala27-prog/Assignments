
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        this.capacity = capacity;

        // true means access-order mode
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    // Get value using key
    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        return cache.get(key);
    }

    // Insert or update key-value pair
    public void put(int key, int value) {

        cache.put(key, value);

        // Remove least recently used element
        if (cache.size() > capacity) {

            int lruKey = cache.keySet().iterator().next();

            cache.remove(lruKey);
        }
    }

    // Display cache
    public void display() {
        System.out.println(cache);
    }
}

public class problem_1 {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);

        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);

        System.out.println("Initial Cache:");
        cache.display();

        System.out.println("Get key 1: " + cache.get(1));

        System.out.println("After accessing key 1:");
        cache.display();

        cache.put(4, 400);

        System.out.println("After inserting key 4:");
        cache.display();

        System.out.println("Get key 2: " + cache.get(2));
    }
}
