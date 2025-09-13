import java.util.*;

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

class MinimumScore {
    public int minScore(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE;
        List<List<Pair<Integer, Integer>>> gr = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            gr.add(new ArrayList<Pair<Integer, Integer>>());
        }

        for (int[] edge : roads) {
            gr.get(edge[0]).add(new Pair<>(edge[1], edge[2]));
            gr.get(edge[1]).add(new Pair<>(edge[0], edge[2]));
        }

        int[] vis = new int[n + 1];
        Arrays.fill(vis, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Pair<Integer, Integer> pair : gr.get(node)) {
                int v = pair.getKey();
                int dis = pair.getValue();
                ans = Math.min(ans, dis);
                if (vis[v] == 0) {
                    vis[v] = 1;
                    q.add(v);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumScore solution = new MinimumScore();

        // Test Case 1
        int n1 = 4;
        int[][] roads1 = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        System.out.println("Minimum score for Test Case 1: " + solution.minScore(n1, roads1)); // Expected: 5

        // Test Case 2
        int n2 = 2;
        int[][] roads2 = {{1, 2, 10}};
        System.out.println("Minimum score for Test Case 2: " + solution.minScore(n2, roads2)); // Expected: 10

        // Test Case 3
        int n3 = 5;
        int[][] roads3 = {{1, 2, 2}, {2, 3, 5}, {3, 4, 7}, {4, 5, 8}};
        System.out.println("Minimum score for Test Case 3: " + solution.minScore(n3, roads3)); // Expected: 2
        //Done!!
    }
}
