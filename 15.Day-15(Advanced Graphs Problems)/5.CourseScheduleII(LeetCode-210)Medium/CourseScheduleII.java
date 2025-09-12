import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;

            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return index == numCourses ? order : new int[0];
    }

    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();

        // Test Case 1: Valid topological sort
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result1 = solution.findOrder(numCourses1, prerequisites1);
        System.out.print("Test Case 1 - Course Order: ");
        for (int course : result1) {
            System.out.print(course + " ");
        }
        System.out.println();

        // Test Case 2: Cycle exists, no valid topological sort
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        int[] result2 = solution.findOrder(numCourses2, prerequisites2);
        System.out.print("Test Case 2 - Course Order: ");
        if (result2.length == 0) {
            System.out.println("[] (No valid order)");
        } else {
            for (int course : result2) {
                System.out.print(course + " ");
            }
            System.out.println();
        }
    }
}
