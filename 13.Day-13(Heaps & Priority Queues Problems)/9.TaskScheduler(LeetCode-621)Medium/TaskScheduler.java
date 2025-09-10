import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.values());
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if (!cooldown.isEmpty() && cooldown.peek()[0] == time) {
                maxHeap.offer(cooldown.poll()[1]);
            }
            if (!maxHeap.isEmpty()) {
                int freq = maxHeap.poll();
                int remainingFreq = freq - 1;
                if (remainingFreq > 0) {
                    int nextAvailableTime = time + n + 1;
                    cooldown.add(new int[] { nextAvailableTime, remainingFreq });
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        TaskScheduler solution = new TaskScheduler();
        
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n1 = 2;
        System.out.println("Tasks: " + new String(tasks1) + ", Cooldown: " + n1);
        System.out.println("Least Interval: " + solution.leastInterval(tasks1, n1));

        char[] tasks2 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n2 = 0;
        System.out.println("\nTasks: " + new String(tasks2) + ", Cooldown: " + n2);
        System.out.println("Least Interval: " + solution.leastInterval(tasks2, n2));
    }
}
