import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        dfs(result, graph, "JFK");
        return result;
    }
    
    void dfs(LinkedList<String> result, Map<String, PriorityQueue<String>> graph, String from) {
        PriorityQueue<String> destinations = graph.getOrDefault(from, new PriorityQueue<>());
        
        while (!destinations.isEmpty()) {
            String to = destinations.poll();
            dfs(result, graph, to);
        }
        
        result.addFirst(from);
    }
    
    Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> result = new HashMap<>();
        
        for (List<String> path : tickets) {
            String from = path.get(0);
            String to   = path.get(1); 
            
            result.putIfAbsent(from, new PriorityQueue<>());
            
            result.get(from).offer(to);
        }
        
        return result;
    }
}

public class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        List<List<String>> tickets1 = new ArrayList<>();
        tickets1.add(Arrays.asList("MUC", "LHR"));
        tickets1.add(Arrays.asList("JFK", "MUC"));
        tickets1.add(Arrays.asList("SFO", "SJC"));
        tickets1.add(Arrays.asList("LHR", "SFO"));
        System.out.println("Tickets: " + tickets1);
        System.out.println("Itinerary: " + solution.findItinerary(tickets1));
        System.out.println("---");

        // Test case 2
        List<List<String>> tickets2 = new ArrayList<>();
        tickets2.add(Arrays.asList("JFK", "SFO"));
        tickets2.add(Arrays.asList("JFK", "ATL"));
        tickets2.add(Arrays.asList("SFO", "ATL"));
        tickets2.add(Arrays.asList("ATL", "JFK"));
        tickets2.add(Arrays.asList("ATL", "SFO"));
        System.out.println("Tickets: " + tickets2);
        System.out.println("Itinerary: " + solution.findItinerary(tickets2));
        System.out.println("---");
    }
}
