class SqrtNum {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int low = 1;
        int high = x;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SqrtNum solution = new SqrtNum();
        int x = 8;
        int result = solution.mySqrt(x);
        System.out.println("The integer part of the square root of " + x + " is: " + result);

        int x2 = 4;
        int result2 = solution.mySqrt(x2);
        System.out.println("The integer part of the square root of " + x2 + " is: " + result2);
    }
}