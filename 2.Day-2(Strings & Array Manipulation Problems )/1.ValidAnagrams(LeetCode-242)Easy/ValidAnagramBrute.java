import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}

public class ValidAnagramBrute {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Are \"" + s1 + "\" and \"" + t1 + "\" anagrams? " + solution.isAnagram(s1, t1));

        String s2 = "rat";
        String t2 = "car";
        System.out.println("Are \"" + s2 + "\" and \"" + t2 + "\" anagrams? " + solution.isAnagram(s2, t2));

        String s3 = "hello";
        String t3 = "world";
        System.out.println("Are \"" + s3 + "\" and \"" + t3 + "\" anagrams? " + solution.isAnagram(s3, t3));
    }
}
