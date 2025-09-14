import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char i : s.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (char i : t.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) - 1);
        }

        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

public class AnagramChecker {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: True
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Is \"" + s1 + "\" an anagram of \"" + t1 + "\"? " + solution.isAnagram(s1, t1));

        // Example 2: False
        String s2 = "rat";
        String t2 = "car";
        System.out.println("Is \"" + s2 + "\" an anagram of \"" + t2 + "\"? " + solution.isAnagram(s2, t2));
    }
}
