import java.util.Arrays;

class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}

public class ReverseStringInPlace {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Original array: " + Arrays.toString(s1));
        solution.reverseString(s1);
        System.out.println("Reversed array: " + Arrays.toString(s1));
        System.out.println("---");

        char[] s2 = {'J', 'a', 'v', 'a'};
        System.out.println("Original array: " + Arrays.toString(s2));
        solution.reverseString(s2);
        System.out.println("Reversed array: " + Arrays.toString(s2));
        System.out.println("---");
    }
}
