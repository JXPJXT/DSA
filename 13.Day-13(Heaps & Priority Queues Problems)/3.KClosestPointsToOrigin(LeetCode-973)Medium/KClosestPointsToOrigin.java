import java.util.PriorityQueue;
import java.util.Arrays;

class KClosestPointsToOrigin {
    static class point {
        int x;
        int y;
        int dist;
        point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<point> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        for (int i = 0; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new point(points[i][0], points[i][1], dist));
        }

        int[][] res = new int[k][2];
        int idx = 0;
        while (k > 0) {
            point temp = pq.poll();
            res[idx][0] = temp.x;
            res[idx][1] = temp.y;
            idx++;
            k--; 
        }
        return res;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = solution.kClosest(points, k);
        System.out.println("The " + k + " closest points to the origin are:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        int[][] result2 = solution.kClosest(points2, k2);
        System.out.println("\nThe " + k2 + " closest points to the origin are:");
        for (int[] point : result2) {
            System.out.println(Arrays.toString(point));
        }
    }
}
