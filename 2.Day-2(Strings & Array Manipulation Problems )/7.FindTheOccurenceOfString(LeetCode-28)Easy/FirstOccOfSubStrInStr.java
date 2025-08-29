class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }
}

public class FirstOccOfSubStrInStr{
    public static void main(String[] args) {
        Solution solution = new Solution();

        String haystack1 = "a";
        String needle1 = "a";
        System.out.println("Input: haystack = \"" + haystack1 + "\", needle = \"" + needle1 + "\"");
        System.out.println("Output: " + solution.strStr(haystack1, needle1));
        System.out.println("---");

        String haystack2 = "hello";
        String needle2 = "ll";
        System.out.println("Input: haystack = \"" + haystack2 + "\", needle = \"" + needle2 + "\"");
        System.out.println("Output: " + solution.strStr(haystack2, needle2));
        System.out.println("---");

        String haystack3 = "aaaaa";
        String needle3 = "bba";
        System.out.println("Input: haystack = \"" + haystack3 + "\", needle = \"" + needle3 + "\"");
        System.out.println("Output: " + solution.strStr(haystack3, needle3));
        System.out.println("---");
        
        String haystack4 = "abc";
        String needle4 = "";
        System.out.println("Input: haystack = \"" + haystack4 + "\", needle = \"" + needle4 + "\"");
        System.out.println("Output: " + solution.strStr(haystack4, needle4));
        System.out.println("---");
    }
}
