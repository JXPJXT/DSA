import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            if (!set.contains(n)) {
                set.add(n);
                int sum = 0;
                int temp = n;
                while (temp != 0) {
                    int rem = temp % 10;
                    sum += rem * rem;
                    temp = temp / 10;
                }
                n = sum;
            } else {
                return false;
            }
        }
        return true;
    }
}

public class HappyNum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test with a happy number (19 -> 1^2 + 9^2 = 82 -> 8^2 + 2^2 = 68 -> ...)
        int happyNum = 19;
        boolean isHappy1 = solution.isHappy(happyNum);
        System.out.println(happyNum + " is a happy number? " + isHappy1);

        // Test with a non-happy number (2 -> 2^2 = 4 -> 4^2 = 16 -> ...)
        int sadNum = 2;
        boolean isHappy2 = solution.isHappy(sadNum);
        System.out.println(sadNum + " is a happy number? " + isHappy2);
    }
}
