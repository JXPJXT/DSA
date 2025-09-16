import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 0, hi = m * n;
        while (lo < hi) {
            int mid = (lo + hi) / 2, count = 0;
            for (int i = 1; i <= m; i++)
                count += n < mid / i ? n : mid / i;
            if (count >= k)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
}

public class KthSmallestInMultiplicationTable {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int m1 = 3, n1 = 3, k1 = 5;
        System.out.println("The " + k1 + "th smallest number in the " + m1 + "x" + n1 + " multiplication table is: " + solution.findKthNumber(m1, n1, k1));

        int m2 = 2, n2 = 3, k2 = 6;
        System.out.println("The " + k2 + "th smallest number in the " + m2 + "x" + n2 + " multiplication table is: " + solution.findKthNumber(m2, n2, k2));
    }
}
