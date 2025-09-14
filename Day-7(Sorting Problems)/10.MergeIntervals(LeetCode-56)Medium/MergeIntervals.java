import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = solution.merge(intervals1);
        System.out.println("Original intervals: " + Arrays.deepToString(intervals1));
        System.out.println("Merged intervals: " + Arrays.deepToString(result1));
        
        System.out.println();
        
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = solution.merge(intervals2);
        System.out.println("Original intervals: " + Arrays.deepToString(intervals2));
        System.out.println("Merged intervals: " + Arrays.deepToString(result2));
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                merged.add(prev);
                prev = intervals[i];
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}
