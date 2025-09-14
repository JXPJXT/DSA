import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// A simple Pair class to use in the BFS, since java.util.Pair is not a standard part of the JDK.
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendSet.contains("0000")) {
            return -1;
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>("0000", 0));
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String currentCombination = current.getKey();
            int moves = current.getValue();

            if (currentCombination.equals(target)) {
                return moves;
            }

            for (int i = 0; i < 4; i++) {
                for (int delta : new int[]{-1, 1}) {
                    int newDigit = (currentCombination.charAt(i) - '0' + delta + 10) % 10;
                    String newCombination = currentCombination.substring(0, i) +
                            newDigit +
                            currentCombination.substring(i + 1);

                    if (!visited.contains(newCombination) && !deadendSet.contains(newCombination)) {
                        visited.add(newCombination);
                        queue.offer(new Pair<>(newCombination, moves + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        OpenLock solution = new OpenLock();

        String[] deadends1 = {"0211", "0022", "2110", "2221", "1212", "1111"};
        String target1 = "0202";
        System.out.println("Minimum moves to open lock: " + solution.openLock(deadends1, target1)); // Expected output: 6

        String[] deadends2 = {"8888"};
        String target2 = "0009";
        System.out.println("Minimum moves to open lock: " + solution.openLock(deadends2, target2)); // Expected output: 1

        String[] deadends3 = {"0000"};
        String target3 = "8888";
        System.out.println("Minimum moves to open lock: " + solution.openLock(deadends3, target3)); // Expected output: -1
    }
}
