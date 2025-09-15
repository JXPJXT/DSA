import java.util.ArrayList;
import java.util.List;
import java.util.StringBuilder;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        backtrack(0, sb, res);
        return res;
    }

    private void backtrack(int index, StringBuilder sb, List<String> res) {
        if (index == sb.length()) {
            res.add(sb.toString());
            return;
        }

        char c = sb.charAt(index);

        if (Character.isLetter(c)) {
            sb.setCharAt(index, Character.toLowerCase(c));
            backtrack(index + 1, sb, res);

            sb.setCharAt(index, Character.toUpperCase(c));
            backtrack(index + 1, sb, res);

            sb.setCharAt(index, c);
        } else {
            backtrack(index + 1, sb, res);
        }
    }
}

public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "a1b2";
        List<String> result1 = solution.letterCasePermutation(s1);
        System.out.println("Input: " + s1);
        System.out.println("Permutations: " + result1);
        System.out.println("---");

        String s2 = "3z4";
        List<String> result2 = solution.letterCasePermutation(s2);
        System.out.println("Input: " + s2);
        System.out.println("Permutations: " + result2);
    }
}
