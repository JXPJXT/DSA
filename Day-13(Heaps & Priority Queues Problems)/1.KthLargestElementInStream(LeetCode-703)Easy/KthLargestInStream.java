import java.util.PriorityQueue;
import java.util.Arrays;

class KthLargestInStream {
    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for(int num: nums) {
            heap.add(num);
            if(heap.size() > k) {
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
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargestInStream kthLargest = new KthLargestInStream(k, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
