class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "babad";
        System.out.println("Longest palindromic substring for \"" + s1 + "\" is: " + solution.longestPalindrome(s1));
        
        String s2 = "cbbd";
        System.out.println("Longest palindromic substring for \"" + s2 + "\" is: " + solution.longestPalindrome(s2));

        String s3 = "a";
        System.out.println("Longest palindromic substring for \"" + s3 + "\" is: " + solution.longestPalindrome(s3));
        
        String s4 = "abacdfgdcaba";
        System.out.println("Longest palindromic substring for \"" + s4 + "\" is: " + solution.longestPalindrome(s4));
    }
}
