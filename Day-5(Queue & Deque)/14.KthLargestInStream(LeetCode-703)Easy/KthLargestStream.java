import java.util.PriorityQueue;

class KthLargestSteam {
    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for(int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, nums);

        System.out.println("Initial KthLargest with k=" + k + " and nums=" + java.util.Arrays.toString(nums));

        // Add a new value and print the current kth largest element
        System.out.println("Adding 3, the " + k + "th largest is: " + kthLargest.add(3));   // returns 4
        System.out.println("Adding 5, the " + k + "th largest is: " + kthLargest.add(5));   // returns 5
        System.out.println("Adding 10, the " + k + "th largest is: " + kthLargest.add(10)); // returns 5
        System.out.println("Adding 9, the " + k + "th largest is: " + kthLargest.add(9));   // returns 8
        System.out.println("Adding 4, the " + k + "th largest is: " + kthLargest.add(4));   // returns 8
    }
}
