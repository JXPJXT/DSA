class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}

public class ValidAnagramOptimized {
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
