/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }
}
public class ReverseLLV {
    public static void main(String[] args) {
        // Example 1: 1->2->3->4->5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.print("Original List 1: ");
        printList(head1);
        Solution solution = new Solution();
        ListNode reversed1 = solution.reverseList(head1);
        System.out.print("Reversed List 1: ");
        printList(reversed1);
        System.out.println();
        // Example 2: Empty list
        ListNode head2 = null;
        System.out.print("Original List 2: ");
        printList(head2);
        ListNode reversed2 = solution.reverseList(head2);
        System.out.print("Reversed List 2: ");
        printList(reversed2);
        System.out.println();
        // Example 3: Single node list
        ListNode head3 = new ListNode(10);
        System.out.print("Original List 3: ");
        printList(head3);
        ListNode reversed3 = solution.reverseList(head3);
        System.out.print("Reversed List 3: ");
        printList(reversed3);
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
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
