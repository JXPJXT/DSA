import java.util.*;

enum Color {
    kInit,
    kRed,
    kBlue
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class ShortestAlternatingPaths {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        List<List<Pair<Integer, Color>>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : redEdges) {
            final int u = edge[0];
            final int v = edge[1];
            graph.get(u).add(new Pair<>(v, Color.kRed));
        }

        for (int[] edge : blueEdges) {
            final int u = edge[0];
            final int v = edge[1];
            graph.get(u).add(new Pair<>(v, Color.kBlue));
        }

        Queue<Pair<Integer, Color>> q = new LinkedList<>();
        q.offer(new Pair<>(0, Color.kInit));

        int step = 0;
        int[][] visited = new int[n][2]; // 0 for red, 1 for blue
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }
        visited[0][0] = visited[0][1] = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int sz = 0; sz < size; ++sz) {
                Pair<Integer, Color> current = q.poll();
                final int u = current.getKey();
                Color prevColor = current.getValue();
                ans[u] = ans[u] == -1 ? step : ans[u];

                for (Pair<Integer, Color> neighbor : graph.get(u)) {
                    final int v = neighbor.getKey();
                    Color edgeColor = neighbor.getValue();

                    if (edgeColor != prevColor) {
                        if ((edgeColor == Color.kRed && visited[v][0] == -1) || (edgeColor == Color.kBlue && visited[v][1] == -1)) {
                            q.offer(new Pair<>(v, edgeColor));
                            if (edgeColor == Color.kRed) {
                                visited[v][0] = step + 1;
                            } else {
                                visited[v][1] = step + 1;
                            }
                        }
                    }
                }
            }
            step++;
        }
        
        for (int i = 0; i < n; ++i) {
            int minSteps = Integer.MAX_VALUE;
            if (visited[i][0] != -1) minSteps = Math.min(minSteps, visited[i][0]);
            if (visited[i][1] != -1) minSteps = Math.min(minSteps, visited[i][1]);
            ans[i] = (minSteps == Integer.MAX_VALUE) ? -1 : minSteps;
        }

        return ans;
    }

    public static void main(String[] args) {
        ShortestAlternatingPaths solution = new ShortestAlternatingPaths();

        // Test Case 1
        int n1 = 3;
        int[][] redEdges1 = {{0, 1}, {1, 2}};
        int[][] blueEdges1 = {};
        System.out.println("Test Case 1: " + Arrays.toString(solution.shortestAlternatingPaths(n1, redEdges1, blueEdges1))); // Expected: [0, 1, 2]

        // Test Case 2
        int n2 = 3;
        int[][] redEdges2 = {{0, 1}};
        int[][] blueEdges2 = {{2, 1}};
        System.out.println("Test Case 2: " + Arrays.toString(solution.shortestAlternatingPaths(n2, redEdges2, blueEdges2))); // Expected: [0, 1, -1]

        // Test Case 3
        int n3 = 5;
        int[][] redEdges3 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] blueEdges3 = {{1, 3}, {2, 4}};
        System.out.println("Test Case 3: " + Arrays.toString(solution.shortestAlternatingPaths(n3, redEdges3, blueEdges3))); // Expected: [0, 1, 2, 3, 4]

        // Test Case 4
        int n4 = 5;
        int[][] redEdges4 = {{0, 1}, {0, 2}, {1, 3}, {2, 4}};
        int[][] blueEdges4 = {{0, 4}, {4, 3}};
        System.out.println("Test Case 4: " + Arrays.toString(solution.shortestAlternatingPaths(n4, redEdges4, blueEdges4))); // Expected: [0, 1, 1, 2, 1]
    }
}
