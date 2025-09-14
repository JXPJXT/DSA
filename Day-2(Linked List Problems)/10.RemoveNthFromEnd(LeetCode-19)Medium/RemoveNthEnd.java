class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        ListNode dummy = result;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return result.next;
    }
}
class RemoveNthEnd {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test Case 1: Remove the 2nd node from the end
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Original list:");
        printList(head1);
        ListNode result1 = solution.removeNthFromEnd(head1, 2);
        System.out.println("List after removing the 2nd node from the end:");
        printList(result1);
        System.out.println();
        // Test Case 2: Remove the 1st node from the end
        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.println("Original list:");
        printList(head2);
        ListNode result2 = solution.removeNthFromEnd(head2, 1);
        System.out.println("List after removing the 1st node from the end:");
        printList(result2);
        System.out.println();
        // Test Case 3: Remove the 2nd node from a two-node list
        ListNode head3 = new ListNode(1, new ListNode(2));
        System.out.println("Original list:");
        printList(head3);
        ListNode result3 = solution.removeNthFromEnd(head3, 2);
        System.out.println("List after removing the 2nd node from a two-node list:");
        printList(result3);
        System.out.println();
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
