import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph {
    HashMap<Integer, Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (nodes.containsKey(node.val)) {
            return nodes.get(node.val);
        }
        Node copiedNode = new Node(node.val);
        nodes.put(node.val, copiedNode);
        for (Node neighbor : node.neighbors) {
            copiedNode.neighbors.add(cloneGraph(neighbor));
        }
        return copiedNode;
    }

    // Helper method to print the graph for verification
    public static void printGraph(Node node) {
        if (node == null) {
            System.out.println("null");
            return;
        }

        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, true);

        System.out.println("Printing graph starting from node " + node.val + ":");
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print("Node " + current.val + " -> Neighbors: [");
            for (int i = 0; i < current.neighbors.size(); i++) {
                Node neighbor = current.neighbors.get(i);
                System.out.print(neighbor.val + (i < current.neighbors.size() - 1 ? ", " : ""));
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();

        // Create a sample graph: 1 -- 2 -- 3 -- 4 -- 1
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println("Original Graph:");
        printGraph(node1);

        // Clone the graph
        Node clonedNode = solution.cloneGraph(node1);

        System.out.println("\nCloned Graph:");
        printGraph(clonedNode);
    }
}
