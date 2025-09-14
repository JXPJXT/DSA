class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Is Palindrome? " + solution.isPalindrome(s1));
        System.out.println("---");

        String s2 = "race a car";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Is Palindrome? " + solution.isPalindrome(s2));
        System.out.println("---");

        String s3 = " ";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Is Palindrome? " + solution.isPalindrome(s3));
        System.out.println("---");
    }
}
