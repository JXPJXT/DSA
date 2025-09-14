class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    
    public ListNode sortList(ListNode head) {
      if (head == null || head.next == null)
        return head;
        
      ListNode prev = null, slow = head, fast = head;
      
      while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
      }
      
      prev.next = null;
      
      ListNode l1 = sortList(head);
      ListNode l2 = sortList(slow);
      
      return merge(l1, l2);
    }
    
    ListNode merge(ListNode l1, ListNode l2) {
      ListNode l = new ListNode(0), p = l;
      
      while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          p.next = l1;
          l1 = l1.next;
        } else {
          p.next = l2;
          l2 = l2.next;
        }
        p = p.next;
      }
      
      if (l1 != null)
        p.next = l1;
      
      if (l2 != null)
        p.next = l2;
      
      return l.next;
    }

}

public class SortList {
    public static void main(String[] args) {
        System.out.println("--- Test Case 1: Unsorted Linked List ---");
        ListNode unsortedHead = new ListNode(4);
        unsortedHead.next = new ListNode(2);
        unsortedHead.next.next = new ListNode(1);
        unsortedHead.next.next.next = new ListNode(3);
        
        System.out.print("Original list: ");
        printList(unsortedHead);
        
        Solution solution = new Solution();
        ListNode sortedHead = solution.sortList(unsortedHead);
        
        System.out.print("Sorted list: ");
        printList(sortedHead);

        System.out.println("\n--- Test Case 2: Already Sorted Linked List ---");
        ListNode sortedList = new ListNode(10);
        sortedList.next = new ListNode(20);
        sortedList.next.next = new ListNode(30);
        
        System.out.print("Original list: ");
        printList(sortedList);

        ListNode reSorted = solution.sortList(sortedList);
        
        System.out.print("Sorted list: ");
        printList(reSorted);
    }
    
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
