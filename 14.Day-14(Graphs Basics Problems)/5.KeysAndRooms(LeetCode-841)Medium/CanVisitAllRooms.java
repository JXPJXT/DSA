import java.util.ArrayList;
import java.util.List;

class CanVisitAllRooms {
    boolean[] visited;
    int count = 0;
    List<List<Integer>> list;
    int n;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        visited = new boolean[n];
        list = rooms;
        dfs(0);
        return count == n;
    }

    void dfs(int v) {
        if (visited[v] == true) return;
        visited[v] = true;
        count++;
        if (count == n) return;
        for (int node : list.get(v)) {
            dfs(node);
        }
    }

    public static void main(String[] args) {
        CanVisitAllRooms solution = new CanVisitAllRooms();
        //Testingg
        // Test Case 1: All rooms can be visited
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(new ArrayList<>(List.of(1)));
        rooms1.add(new ArrayList<>(List.of(2)));
        rooms1.add(new ArrayList<>(List.of(3)));
        rooms1.add(new ArrayList<>());
        System.out.println("Can visit all rooms for rooms1: " + solution.canVisitAllRooms(rooms1)); // Expected: true

        // Test Case 2: Not all rooms can be visited
        CanVisitAllRooms solution2 = new CanVisitAllRooms();
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(new ArrayList<>(List.of(1, 3)));
        rooms2.add(new ArrayList<>(List.of(3, 0, 1)));
        rooms2.add(new ArrayList<>(List.of(2)));
        rooms2.add(new ArrayList<>(List.of(0)));
        System.out.println("Can visit all rooms for rooms2: " + solution2.canVisitAllRooms(rooms2)); // Expected: false
    }
}
