import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CheapestFlights {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int currNode = curr[0];
                int currCost = curr[1];

                for (int[] neighbour : adj.get(currNode)) {
                    int neighbourNode = neighbour[0];
                    int price = neighbour[1];

                    if (currCost + price >= minCost[neighbourNode]) {
                        continue;
                    }

                    minCost[neighbourNode] = currCost + price;
                    q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
                }
            }
            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    public static void main(String[] args) {
        CheapestFlights solution = new CheapestFlights();

        int n1 = 3;
        int[][] flights1 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src1 = 0, dst1 = 2, k1 = 1;
        System.out.println("Test Case 1: " + solution.findCheapestPrice(n1, flights1, src1, dst1, k1));

        int n2 = 3;
        int[][] flights2 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src2 = 0, dst2 = 2, k2 = 0;
        System.out.println("Test Case 2: " + solution.findCheapestPrice(n2, flights2, src2, dst2, k2));

        int n3 = 5;
        int[][] flights3 = {{0, 1, 10}, {1, 2, 20}, {2, 3, 30}};
        int src3 = 0, dst3 = 4, k3 = 2;
        System.out.println("Test Case 3: " + solution.findCheapestPrice(n3, flights3, src3, dst3, k3));

        int n4 = 4;
        int[][] flights4 = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src4 = 0, dst4 = 3, k4 = 1;
        System.out.println("Test Case 4: " + solution.findCheapestPrice(n4, flights4, src4, dst4, k4));
    }
}
