import java.util.ArrayList;
import java.util.List;

class ValidPath {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (var edge : edges) {
            if ((edge[0] == source && edge[1] == destination) || (edge[1] == source && edge[0] == destination))
                return true;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }

    public boolean dfs(int u, int destination, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if (u == destination) {
            return true;
        }
        visited[u] = true;
        for (var v : adj.get(u)) {
            if (!visited[v] && dfs(v, destination, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPath solution = new ValidPath();

        // Test Case 1: Path exists
        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        int source1 = 0;
        int destination1 = 2;
        System.out.println("Path exists between " + source1 + " and " + destination1 + ": " + solution.validPath(n1, edges1, source1, destination1)); // Expected: true

        // Test Case 2: Path does not exist
        int n2 = 6;
        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source2 = 0;
        int destination2 = 5;
        System.out.println("Path exists between " + source2 + " and " + destination2 + ": " + solution.validPath(n2, edges2, source2, destination2)); // Expected: false
    }
}
