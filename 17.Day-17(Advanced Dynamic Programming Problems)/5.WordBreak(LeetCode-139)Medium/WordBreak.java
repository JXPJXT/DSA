import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int start = i - w.length();
                if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println("String: \"" + s1 + "\", Word Dictionary: " + wordDict1);
        System.out.println("Can be segmented: " + solution.wordBreak(s1, wordDict1));
        System.out.println("---");

        // Test case 2
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println("String: \"" + s2 + "\", Word Dictionary: " + wordDict2);
        System.out.println("Can be segmented: " + solution.wordBreak(s2, wordDict2));
        System.out.println("---");

        // Test case 3
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("String: \"" + s3 + "\", Word Dictionary: " + wordDict3);
        System.out.println("Can be segmented: " + solution.wordBreak(s3, wordDict3));
        System.out.println("---");
    }
}
