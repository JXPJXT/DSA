import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Arrays;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        
        Queue<String> memory = new LinkedList<>();
        memory.offer(beginWord);
        set.remove(beginWord);
        
        int noSteps = 1;
        while (!memory.isEmpty()) {
            int size = memory.size();
            for (int k = 0; k < size; k++) {
                String original = memory.poll();
                if (original.equals(endWord)) {
                    return noSteps;
                }
                
                int n = original.length();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 26; j++) {
                        char ch = (char)('a' + j);
                        char tempArray[] = original.toCharArray();
                        if (ch != tempArray[i]) {
                            tempArray[i] = ch;
                            
                            String temp = new String(tempArray);
                            if (set.contains(temp)) {
                                set.remove(temp);
                                memory.offer(temp);
                            }
                        }
                    }
                }
            }
            noSteps++;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        WordLadder solution = new WordLadder();

        // Test Case 1
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Test Case 1: " + solution.ladderLength(beginWord1, endWord1, wordList1)); // Expected output: 5

        // Test Case 2
        String beginWord2 = "a";
        String endWord2 = "c";
        List<String> wordList2 = Arrays.asList("a", "b", "c");
        System.out.println("Test Case 2: " + solution.ladderLength(beginWord2, endWord2, wordList2)); // Expected output: 2
        
        // Test Case 3 (no path)
        String beginWord3 = "hit";
        String endWord3 = "cog";
        List<String> wordList3 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println("Test Case 3: " + solution.ladderLength(beginWord3, endWord3, wordList3)); // Expected output: 0
    }
}
