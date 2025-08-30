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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;        
    }
}

class RotateList {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard rotation
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Original list:");
        printList(head1);
        int k1 = 2;
        ListNode result1 = solution.rotateRight(head1, k1);
        System.out.println("List after rotating right by " + k1 + ":");
        printList(result1);

        System.out.println();

        // Test Case 2: Rotation greater than list length
        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        System.out.println("Original list:");
        printList(head2);
        int k2 = 4;
        ListNode result2 = solution.rotateRight(head2, k2);
        System.out.println("List after rotating right by " + k2 + ":");
        printList(result2);

        System.out.println();

        // Test Case 3: Rotation of 0
        ListNode head3 = new ListNode(1, new ListNode(2));
        System.out.println("Original list:");
        printList(head3);
        int k3 = 0;
        ListNode result3 = solution.rotateRight(head3, k3);
        System.out.println("List after rotating right by " + k3 + ":");
        printList(result3);
    }
    
    // Helper method to print the list
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
