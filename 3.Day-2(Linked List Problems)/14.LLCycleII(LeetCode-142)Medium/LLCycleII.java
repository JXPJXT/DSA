import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}

public class LLCycleII {
    public static void main(String[] args) {
        System.out.println("--- Test Case 1: Linked list with a cycle ---");
        
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3; 

        Solution solution = new Solution();
        ListNode cycleStart = solution.detectCycle(head1);

        if (cycleStart != null) {
            System.out.println("Cycle detected! It starts at the node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }

        System.out.println("\n--- Test Case 2: Linked list without a cycle ---");
        
        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(20);
        head2.next.next = new ListNode(30);
        head2.next.next.next = new ListNode(40);

        ListNode noCycleResult = solution.detectCycle(head2);

        if (noCycleResult != null) {
            System.out.println("Cycle detected! It starts at the node with value: " + noCycleResult.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
