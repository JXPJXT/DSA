class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            if (i != 0) {
                res.append(" ");
            }
        }
        return res.toString().trim();
    }
}
public class ReverseWordsInStr {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "the sky is blue";
        System.out.println("Original: \"" + s1 + "\"");
        System.out.println("Reversed: \"" + solution.reverseWords(s1) + "\"");
        System.out.println();
        String s2 = "  hello   world  ";
        System.out.println("Original: \"" + s2 + "\"");
        System.out.println("Reversed: \"" + solution.reverseWords(s2) + "\"");
        System.out.println();
        String s3 = "a good   example";
        System.out.println("Original: \"" + s3 + "\"");
        System.out.println("Reversed: \"" + solution.reverseWords(s3) + "\"");
        System.out.println();
        String s4 = "  a";
        System.out.println("Original: \"" + s4 + "\"");
        System.out.println("Reversed: \"" + solution.reverseWords(s4) + "\"");
        System.out.println();
    }
}
