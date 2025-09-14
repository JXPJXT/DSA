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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }
        return dummy.next;
    }
}
public class MergeTwoSortedLL {
    public static void main(String[] args) {
        // Example 1: Merging two non-empty lists
        ListNode list1_1 = new ListNode(1);
        list1_1.next = new ListNode(2);
        list1_1.next.next = new ListNode(4);
        ListNode list1_2 = new ListNode(1);
        list1_2.next = new ListNode(3);
        list1_2.next.next = new ListNode(4);
        System.out.print("List 1: ");
        printList(list1_1);
        System.out.print("List 2: ");
        printList(list1_2);
        Solution solution = new Solution();
        ListNode mergedList1 = solution.mergeTwoLists(list1_1, list1_2);
        System.out.print("Merged List: ");
        printList(mergedList1);
        System.out.println();
        // Example 2: Merging one empty list
        ListNode list2_1 = null;
        ListNode list2_2 = new ListNode(0);
        System.out.print("List 1: ");
        printList(list2_1);
        System.out.print("List 2: ");
        printList(list2_2);
        ListNode mergedList2 = solution.mergeTwoLists(list2_1, list2_2);
        System.out.print("Merged List: ");
        printList(mergedList2);
        System.out.println();
        // Example 3: Merging two empty lists
        ListNode list3_1 = null;
        ListNode list3_2 = null;
        System.out.print("List 1: ");
        printList(list3_1);
        System.out.print("List 2: ");
        printList(list3_2);
        ListNode mergedList3 = solution.mergeTwoLists(list3_1, list3_2);
        System.out.print("Merged List: ");
        printList(mergedList3);
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
