/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
class OddEvenLL {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard odd-even list
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Original list:");
        printList(head1);
        ListNode result1 = solution.oddEvenList(head1);
        System.out.println("List after reordering:");
        printList(result1);

        System.out.println();

        // Test Case 2: List with even number of nodes
        ListNode head2 = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        System.out.println("Original list:");
        printList(head2);
        ListNode result2 = solution.oddEvenList(head2);
        System.out.println("List after reordering:");
        printList(result2);

        System.out.println();
        
        // Test Case 3: Empty list
        ListNode head3 = null;
        System.out.println("Original list:");
        printList(head3);
        ListNode result3 = solution.oddEvenList(head3);
        System.out.println("List after reordering:");
        printList(result3);
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
