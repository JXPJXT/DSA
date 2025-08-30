class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
class LLCycle {
    public static void main(String[] args) {
        // Test case 1: List with a cycle
        System.out.println("Test Case 1: List with a cycle");
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next;
        System.out.println("Does the list have a cycle? " + new Solution().hasCycle(head1));
        System.out.println();
        // Test case 2: List without a cycle
        System.out.println("Test Case 2: List without a cycle");
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Does the list have a cycle? " + new Solution().hasCycle(head2));
        System.out.println();
        // Test case 3: Empty list
        System.out.println("Test Case 3: Empty list");
        ListNode head3 = null;
        System.out.println("Does the list have a cycle? " + new Solution().hasCycle(head3));
        System.out.println();
        // Test case 4: Single-node list
        System.out.println("Test Case 4: Single-node list");
        ListNode head4 = new ListNode(1);
        System.out.println("Does the list have a cycle? " + new Solution().hasCycle(head4));
    }
}
