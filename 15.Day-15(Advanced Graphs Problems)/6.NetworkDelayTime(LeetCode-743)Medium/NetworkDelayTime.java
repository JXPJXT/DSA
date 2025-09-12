import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class NetworkDelayTime {
    static class Tuple {
        int first, second;

        public Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Tuple>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0] - 1).add(new Tuple(time[1] - 1, time[2]));
        }

        PriorityQueue<Tuple> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));

        int[] visitedtime = new int[n];
        Arrays.fill(visitedtime, Integer.MAX_VALUE);
        visitedtime[k - 1] = 0;

        q.add(new Tuple(k - 1, 0));

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int node = it.first;
            int t = it.second;

            for (Tuple iter : adj.get(node)) {
                int adjnode = iter.first;
                int edgetime = iter.second;

                if (t + edgetime < visitedtime[adjnode]) {
                    visitedtime[adjnode] = t + edgetime;
                    q.add(new Tuple(adjnode, visitedtime[adjnode]));
                }
            }
        }

        int maxTime = 0;
        for (int time : visitedtime) {
            if (time == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, time);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();

        // Test Case 1
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n1 = 4, k1 = 2;
        System.out.println("Test Case 1: " + solution.networkDelayTime(times1, n1, k1));

        // Test Case 2
        int[][] times2 = {{1, 2, 1}};
        int n2 = 2, k2 = 1;
        System.out.println("Test Case 2: " + solution.networkDelayTime(times2, n2, k2));

        // Test Case 3 (unreachable node)
        int[][] times3 = {{1, 2, 1}};
        int n3 = 2, k3 = 2;
        System.out.println("Test Case 3: " + solution.networkDelayTime(times3, n3, k3));

        // Test Case 4
        int[][] times4 = {{1, 2, 100}, {1, 3, 50}, {3, 4, 30}};
        int n4 = 4, k4 = 1;
        System.out.println("Test Case 4: " + solution.networkDelayTime(times4, n4, k4));
    }
}
