class BinSearch {
    public int search(int[] arr, int target) {
        int low = 0 ; 
        int high = arr.length-1;
        while(low<=high){
            int mid = (high-low)/2 + low;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;
        int result = solution.search(arr, target);
        System.out.println("The index of the target element is: " + result);
    }
}