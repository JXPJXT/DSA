import java.util.Arrays;

class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            int root1 = find(parent, node1);
            int root2 = find(parent, node2);

            if (root1 == root2) {
                return edge;
            }

            parent[root2] = root1;
        }
        return new int[0];
    }

    private static int find(int[] parent, int node) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

    public static void main(String[] args) {
        FindRedundantConnection solution = new FindRedundantConnection();

        // Test Case 1: Simple cycle
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println("Redundant connection for Test Case 1: " + Arrays.toString(solution.findRedundantConnection(edges1))); // Expected: [2, 3]

        // Test Case 2: More complex cycle
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println("Redundant connection for Test Case 2: " + Arrays.toString(solution.findRedundantConnection(edges2))); // Expected: [1, 4]

        // Test Case 3: No cycle (should return empty array)
        int[][] edges3 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Redundant connection for Test Case 3: " + Arrays.toString(solution.findRedundantConnection(edges3))); // Expected: []
    }
}
