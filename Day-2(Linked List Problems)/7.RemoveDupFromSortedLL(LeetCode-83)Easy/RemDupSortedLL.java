class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
class RemDupSortedLL{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: Duplicates in the middle and end
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(3);
        System.out.println("Original list:");
        printList(head1);
        ListNode result1 = solution.deleteDuplicates(head1);
        System.out.println("List after removing duplicates:");
        printList(result1);
        System.out.println();
        // Test case 2: No duplicates
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.println("Original list:");
        printList(head2);
        ListNode result2 = solution.deleteDuplicates(head2);
        System.out.println("List after removing duplicates:");
        printList(result2);
        System.out.println();
        // Test case 3: All duplicates
        ListNode head3 = new ListNode(5);
        head3.next = new ListNode(5);
        head3.next.next = new ListNode(5);
        System.out.println("Original list:");
        printList(head3);
        ListNode result3 = solution.deleteDuplicates(head3);
        System.out.println("List after removing duplicates:");
        printList(result3);
        System.out.println();
        // Test case 4: Empty list
        ListNode head4 = null;
        System.out.println("Original list:");
        printList(head4);
        ListNode result4 = solution.deleteDuplicates(head4);
        System.out.println("List after removing duplicates:");
        printList(result4);
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
