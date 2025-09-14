import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        MinimumHeightTrees solution = new MinimumHeightTrees();

        // Test case 1
        int n1 = 4;
        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println("Minimum height trees for n=" + n1 + ": " + solution.findMinHeightTrees(n1, edges1));
        // Expected Output: [1]

        // Test case 2
        int n2 = 6;
        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5}};
        System.out.println("Minimum height trees for n=" + n2 + ": " + solution.findMinHeightTrees(n2, edges2));
        // Expected Output: [3]

        // Test case 3
        int n3 = 6;
        int[][] edges3 = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};
        System.out.println("Minimum height trees for n=" + n3 + ": " + solution.findMinHeightTrees(n3, edges3));
        // Expected Output: [3, 0]

        // Test case 4
        int n4 = 2;
        int[][] edges4 = {{0, 1}};
        System.out.println("Minimum height trees for n=" + n4 + ": " + solution.findMinHeightTrees(n4, edges4));
        // Expected Output: [0, 1]
    }
}
