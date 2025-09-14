import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;

class TopKFreq {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int i : map.keySet()) {
            pq.offer(i);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println("The " + k + " most frequent elements are: " + Arrays.toString(result));

        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println("The " + k2 + " most frequent element is: " + Arrays.toString(result2));
    }
}
