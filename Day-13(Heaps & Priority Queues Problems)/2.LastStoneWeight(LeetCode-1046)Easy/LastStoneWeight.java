import java.util.PriorityQueue;
import java.lang.Math;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int each : stones) {
            heap.add(each);
        }

        while (heap.size() > 1) {
            int top1 = heap.poll();
            int top2 = heap.poll();
            
            int diff = Math.abs(top1 - top2);

            if (diff != 0) {
                heap.add(diff);
            }
        }

        if (heap.size() != 0) {
            return heap.poll();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        LastStoneWeight solution = new LastStoneWeight();
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        int result = solution.lastStoneWeight(stones);
        System.out.println("The weight of the last remaining stone is: " + result);
    }
}
