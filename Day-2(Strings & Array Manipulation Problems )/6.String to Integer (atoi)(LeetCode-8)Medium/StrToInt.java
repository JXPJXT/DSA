class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        final int INT_MAX = Integer.MAX_VALUE;
        final int INT_MIN = Integer.MIN_VALUE;
        
        int i = 0;
        int n = s.length();
        
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        
        long res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;
            
            if (sign * res <= INT_MIN) {
                return INT_MIN;
            }
            if (sign * res >= INT_MAX) {
                return INT_MAX;
            }
            
            i++;
        }
        
        return (int)(res * sign);
    }
}

public class StrToInt {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "42";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + solution.myAtoi(s1));
        System.out.println("---");

        String s2 = "   -42";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + solution.myAtoi(s2));
        System.out.println("---");

        String s3 = "4193 with words";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + solution.myAtoi(s3));
        System.out.println("---");

        String s4 = "words and 987";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + solution.myAtoi(s4));
        System.out.println("---");

        String s5 = "-91283472332";
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: " + solution.myAtoi(s5));
        System.out.println("---");

        String s6 = "2147483647";
        System.out.println("Input: \"" + s6 + "\"");
        System.out.println("Output: " + solution.myAtoi(s6));
        System.out.println("---");

        String s7 = "-2147483648";
        System.out.println("Input: \"" + s7 + "\"");
        System.out.println("Output: " + solution.myAtoi(s7));
        System.out.println("---");
    }
}
