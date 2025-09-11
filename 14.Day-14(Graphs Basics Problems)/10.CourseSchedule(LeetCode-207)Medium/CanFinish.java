import java.util.ArrayList;
import java.util.List;

class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int node1 = prerequisite[0];
            int node2 = prerequisite[1];
            adj.get(node2).add(node1);
        }
        return !detectCycle(V, adj);
    }

    private boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;
        for (int neigh : adj.get(node)) {
            if (!vis[neigh]) {
                if (dfs(neigh, adj, vis, pathVis)) return true;
            } else if (pathVis[neigh]) {
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }

    public static void main(String[] args) {
        CanFinish solution = new CanFinish();

        // Test Case 1: Possible to finish all courses (no cycle)
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Can finish all courses (Test Case 1): " + solution.canFinish(numCourses1, prerequisites1)); // Expected: true

        // Test Case 2: Not possible to finish all courses (cycle exists)
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Can finish all courses (Test Case 2): " + solution.canFinish(numCourses2, prerequisites2)); // Expected: false

        // Test Case 3: More complex case with no cycle
        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Can finish all courses (Test Case 3): " + solution.canFinish(numCourses3, prerequisites3)); // Expected: true
    }
}
