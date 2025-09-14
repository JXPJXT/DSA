class FindPeak {
    public int findPeakElement(int[] arr) {
        int low = 1, high = arr.length - 2, mid = 0;
        if (arr.length == 1) {
            return 0;
        } else if (arr[0] > arr[1]) {
            return 0;
        } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        } else {
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return mid;
        }
    }

    public static void main(String[] args) {
        FindPeak solution = new FindPeak();
        int[] arr1 = {1, 2, 3, 1};
        System.out.println("The peak element index is: " + solution.findPeakElement(arr1));

        int[] arr2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("The peak element index is: " + solution.findPeakElement(arr2));
    }
}