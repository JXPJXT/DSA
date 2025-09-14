import java.util.*;

class OpenTheLock {

    static class Pair<K, V> {
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
        OpenTheLock solution = new OpenTheLock();

        String[] deadends1 = {"0201","0101","0102","1212","2002"};
        String target1 = "0202";
        System.out.println("Minimum moves for target '" + target1 + "': " + solution.openLock(deadends1, target1));

        String[] deadends2 = {"8888"};
        String target2 = "0009";
        System.out.println("Minimum moves for target '" + target2 + "': " + solution.openLock(deadends2, target2));

        String[] deadends3 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target3 = "8888";
        System.out.println("Minimum moves for target '" + target3 + "': " + solution.openLock(deadends3, target3));
    }
}
