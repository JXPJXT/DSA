/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl {
    // This is a dummy implementation for demonstration purposes
    boolean isBadVersion(int version) {
        return version >= 4; // Assuming 4 is the first bad version
    }
}

class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FirstBadVersion solution = new FirstBadVersion();
        int n = 5;
        int firstBad = solution.firstBadVersion(n);
        System.out.println("The first bad version is: " + firstBad);
    }
}