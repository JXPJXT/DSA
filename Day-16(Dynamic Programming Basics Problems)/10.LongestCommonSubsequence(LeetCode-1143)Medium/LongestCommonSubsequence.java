class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int length1 = text1.length();
        int length2 = text2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[length1][length2];
    }
}

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String text1_1 = "abcde";
        String text2_1 = "ace";
        System.out.println("Text 1: " + text1_1);
        System.out.println("Text 2: " + text2_1);
        System.out.println("Longest Common Subsequence length: " + solution.longestCommonSubsequence(text1_1, text2_1));
        System.out.println("---");

        // Test case 2
        String text1_2 = "abc";
        String text2_2 = "abc";
        System.out.println("Text 1: " + text1_2);
        System.out.println("Text 2: " + text2_2);
        System.out.println("Longest Common Subsequence length: " + solution.longestCommonSubsequence(text1_2, text2_2));
        System.out.println("---");
        
        // Test case 3
        String text1_3 = "abc";
        String text2_3 = "def";
        System.out.println("Text 1: " + text1_3);
        System.out.println("Text 2: " + text2_3);
        System.out.println("Longest Common Subsequence length: " + solution.longestCommonSubsequence(text1_3, text2_3));
        System.out.println("---");
    }
}
