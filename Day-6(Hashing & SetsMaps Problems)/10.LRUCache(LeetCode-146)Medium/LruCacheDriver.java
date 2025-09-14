import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private int cap;
    private Map<Integer, Node> cache;
    private Node oldest;
    private Node latest;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.oldest = new Node(0, 0);
        this.latest = new Node(0, 0);
        this.oldest.next = this.latest;
        this.latest.prev = this.oldest;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = latest.prev;
        Node next = latest;
        prev.next = next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > cap) {
            Node lru = oldest.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}

public class LruCacheDriver {
    public static void main(String[] args) {
        // Example usage:
        System.out.println("Initializing LRUCache with capacity 2...");
        LRUCache lruCache = new LRUCache(2);

        System.out.println("Putting (1, 1)...");
        lruCache.put(1, 1);
        System.out.println("Putting (2, 2)...");
        lruCache.put(2, 2);

        System.out.println("Getting key 1...");
        System.out.println("Result: " + lruCache.get(1)); // returns 1

        System.out.println("Putting (3, 3) (this will evict key 2)...");
        lruCache.put(3, 3);

        System.out.println("Getting key 2...");
        System.out.println("Result: " + lruCache.get(2)); // returns -1 (not found)

        System.out.println("Putting (4, 4)...");
        lruCache.put(4, 4);

        System.out.println("Getting key 1...");
        System.out.println("Result: " + lruCache.get(1)); // returns -1 (not found)

        System.out.println("Getting key 3...");
        System.out.println("Result: " + lruCache.get(3)); // returns 3
        
        System.out.println("Getting key 4...");
        System.out.println("Result: " + lruCache.get(4)); // returns 4
    }
}
