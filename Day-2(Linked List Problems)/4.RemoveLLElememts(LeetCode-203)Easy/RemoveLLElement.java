class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test Case 1: Elements to remove are in the middle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(6);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next = new ListNode(6);
        System.out.println("Original list:");
        printList(head1);
        ListNode newHead1 = solution.removeElements(head1, 6);
        System.out.println("List after removing 6:");
        printList(newHead1);
        System.out.println();
        // Test Case 2: Head needs to be removed
        ListNode head2 = new ListNode(7);
        head2.next = new ListNode(7);
        head2.next.next = new ListNode(7);
        head2.next.next.next = new ListNode(7);
        System.out.println("Original list:");
        printList(head2);
        ListNode newHead2 = solution.removeElements(head2, 7);
        System.out.println("List after removing 7:");
        printList(newHead2);
        System.out.println();
        // Test Case 3: Empty list
        ListNode head3 = null;
        System.out.println("Original list:");
        printList(head3);
        ListNode newHead3 = solution.removeElements(head3, 1);
        System.out.println("List after removing 1:");
        printList(newHead3);
        System.out.println();
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
