import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Character> hm1 = new HashMap<>();
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            String word = words[i];
            char c = pattern.charAt(i);
            if (hm.containsKey(c) && !hm.get(c).equals(word)) {
                return false;
            }
            if (hm1.containsKey(word) && hm1.get(word) != c) {
                return false;
            }
            hm.put(c, word);
            hm1.put(word, c);
        }
        return true;
    }
}

public class WordPatternChecker {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: True
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println("Pattern \"" + pattern1 + "\" and string \"" + s1 + "\" match: " + solution.wordPattern(pattern1, s1));

        // Example 2: False
        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println("Pattern \"" + pattern2 + "\" and string \"" + s2 + "\" match: " + solution.wordPattern(pattern2, s2));

        // Example 3: False
        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        System.out.println("Pattern \"" + pattern3 + "\" and string \"" + s3 + "\" match: " + solution.wordPattern(pattern3, s3));

        // Example 4: False
        String pattern4 = "abba";
        String s4 = "dog dog dog dog";
        System.out.println("Pattern \"" + pattern4 + "\" and string \"" + s4 + "\" match: " + solution.wordPattern(pattern4, s4));
    }
}
