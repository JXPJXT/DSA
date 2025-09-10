import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class FindKPairSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resV = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int x : nums1) {
            pq.offer(new int[]{x + nums2[0], 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int sum = pair[0];
            int pos = pair[1];

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum - nums2[pos]);
            currentPair.add(nums2[pos]);
            resV.add(currentPair);

            if (pos + 1 < nums2.length) {
                pq.offer(new int[]{sum - nums2[pos] + nums2[pos + 1], pos + 1});
            }

            k--;
        }

        return resV;
    }

    public static void main(String[] args) {
        FindKPairSmallestSum solution = new FindKPairSmallestSum();

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        System.out.println("The " + k + " smallest pairs are:");
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}
