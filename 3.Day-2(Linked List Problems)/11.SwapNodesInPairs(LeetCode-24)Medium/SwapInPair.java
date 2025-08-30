class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first;
        }
        return dummy.next;
    }
}
class SwapInPair {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test Case 1: Odd number of nodes
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Original list:");
        printList(head1);
        ListNode result1 = solution.swapPairs(head1);
        System.out.println("List after swapping pairs:");
        printList(result1);
        System.out.println();
        // Test Case 2: Even number of nodes
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("Original list:");
        printList(head2);
        ListNode result2 = solution.swapPairs(head2);
        System.out.println("List after swapping pairs:");
        printList(result2);
        System.out.println();
        // Test Case 3: One node
        ListNode head3 = new ListNode(1);
        System.out.println("Original list:");
        printList(head3);
        ListNode result3 = solution.swapPairs(head3);
        System.out.println("List after swapping pairs:");
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
