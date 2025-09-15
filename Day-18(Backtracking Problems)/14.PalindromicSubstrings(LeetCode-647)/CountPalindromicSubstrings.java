import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Odd length palindromes (center at i)
            count += expandAroundCenter(s, i, i);

            // Even length palindromes (center at i and i+1)
            count += expandAroundCenter(s, i, i + 1);
        }

        return count;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int palindromesCount = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindromesCount++;
            left--;
            right++;
        }
        return palindromesCount;
    }
}

public class CountPalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "abc";
        String s2 = "aaa";

        System.out.println("The number of palindromic substrings in '" + s1 + "' is: " + solution.countSubstrings(s1));
        System.out.println("The number of palindromic substrings in '" + s2 + "' is: " + solution.countSubstrings(s2));
    }
}
