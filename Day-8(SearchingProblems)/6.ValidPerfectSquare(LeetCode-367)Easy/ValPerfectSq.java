class ValPerfectSq {
    public boolean isPerfectSquare(int num) {
        int low = 1, right = num;
        while (low <= right) {
            int mid = low + (right - low) / 2;
            long midSq = (long) mid * mid;
            if (midSq == num) {
                return true;
            } else if (midSq > num) {
                right = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValPerfectSq solution = new ValPerfectSq();
        int num1 = 16;
        System.out.println(num1 + " is a perfect square: " + solution.isPerfectSquare(num1));

        int num2 = 14;
        System.out.println(num2 + " is a perfect square: " + solution.isPerfectSquare(num2));
    }
}