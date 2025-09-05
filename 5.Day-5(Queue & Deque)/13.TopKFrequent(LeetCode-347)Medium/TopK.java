import java.util.*;

class TopK {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solution.topKFrequent(nums1, k1);
        System.out.print("Test case 1: nums = [1, 1, 1, 2, 2, 3], k = 2 -> [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + (i == result1.length - 1 ? "" : ", "));
        }
        System.out.println("]");

        // Test case 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.print("Test case 2: nums = [1], k = 1 -> [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + (i == result2.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}
