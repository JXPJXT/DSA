import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }
            charMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

public class LongestSubStrWithoutRepeatingChar {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "abcabcbb";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Length of longest substring: " + solution.lengthOfLongestSubstring(s1));
        System.out.println("---");

        String s2 = "bbbbb";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Length of longest substring: " + solution.lengthOfLongestSubstring(s2));
        System.out.println("---");

        String s3 = "pwwkew";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Length of longest substring: " + solution.lengthOfLongestSubstring(s3));
        System.out.println("---");
    }
}
