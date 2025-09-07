class KokoBanana {
    public boolean isPossible(int mid, int[] arr, int h) {
        long hours = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            hours += (arr[i] + mid - 1) / mid;
        }
        if (hours > h)
            return false;
        return true;
    }

    public int minEatingSpeed(int[] arr, int h) {
        int n = arr.length;
        int lo = 1;
        int hi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            hi = Math.max(hi, arr[i]);
        }
        int ans = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(mid, arr, h)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KokoBanana solution = new KokoBanana();
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("The minimum eating speed for piles " + java.util.Arrays.toString(piles1) + " and h = " + h1 + " is: " + solution.minEatingSpeed(piles1, h1));

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println("The minimum eating speed for piles " + java.util.Arrays.toString(piles2) + " and h = " + h2 + " is: " + solution.minEatingSpeed(piles2, h2));
    }
}