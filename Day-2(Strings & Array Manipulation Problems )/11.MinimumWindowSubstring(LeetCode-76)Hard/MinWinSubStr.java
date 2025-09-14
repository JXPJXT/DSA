class Solution {
  public String minWindow(String s, String t) {
    int[] count = new int[128];
    int required = t.length();
    int bestLeft = -1;
    int minLength = s.length() + 1;
    for (final char c : t.toCharArray()) {
      ++count[c];
    }
    for (int l = 0, r = 0; r < s.length(); ++r) {
      if (--count[s.charAt(r)] >= 0) {
        --required;
      }
      while (required == 0) {
        if (r - l + 1 < minLength) {
          bestLeft = l;
          minLength = r - l + 1;
        }
        if (++count[s.charAt(l++)] > 0) {
          ++required;
        }
      }
    }
    return bestLeft == -1 ? "" : s.substring(bestLeft, bestLeft + minLength);
  }
}
public class MinWinSubStr{
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s1 = "ADOBECODEBANC";
    String t1 = "ABC";
    System.out.println("Input String: \"" + s1 + "\"");
    System.out.println("Target String: \"" + t1 + "\"");
    System.out.println("Minimum Window: \"" + solution.minWindow(s1, t1) + "\"");
    System.out.println();
    String s2 = "a";
    String t2 = "a";
    System.out.println("Input String: \"" + s2 + "\"");
    System.out.println("Target String: \"" + t2 + "\"");
    System.out.println("Minimum Window: \"" + solution.minWindow(s2, t2) + "\"");
    System.out.println();
    String s3 = "a";
    String t3 = "aa";
    System.out.println("Input String: \"" + s3 + "\"");
    System.out.println("Target String: \"" + t3 + "\"");
    System.out.println("Minimum Window: \"" + solution.minWindow(s3, t3) + "\"");
    System.out.println();
  }
}
