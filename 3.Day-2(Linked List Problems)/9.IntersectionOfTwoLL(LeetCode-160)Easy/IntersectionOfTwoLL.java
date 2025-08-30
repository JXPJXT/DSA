class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
class IntersectionOfTwoLL {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Intersecting lists
        // List A: 4 -> 1 -> 8 -> 4 -> 5
        // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        // Intersection at node with value 8
        ListNode commonNode = new ListNode(8);
        commonNode.next = new ListNode(4);
        commonNode.next.next = new ListNode(5);
        ListNode headA1 = new ListNode(4);
        headA1.next = new ListNode(1);
        headA1.next.next = commonNode;
        ListNode headB1 = new ListNode(5);
        headB1.next = new ListNode(6);
        headB1.next.next = new ListNode(1);
        headB1.next.next.next = commonNode;
        System.out.println("Test Case 1: Intersecting lists");
        System.out.println("Intersection value: " + (solution.getIntersectionNode(headA1, headB1) != null ? solution.getIntersectionNode(headA1, headB1).val : "null"));
        System.out.println();

        // Test Case 2: Non-intersecting lists
        // List A: 2 -> 6 -> 4
        // List B: 1 -> 5
        ListNode headA2 = new ListNode(2);
        headA2.next = new ListNode(6);
        headA2.next.next = new ListNode(4);
        ListNode headB2 = new ListNode(1);
        headB2.next = new ListNode(5);
        System.out.println("Test Case 2: Non-intersecting lists");
        System.out.println("Intersection value: " + (solution.getIntersectionNode(headA2, headB2) != null ? solution.getIntersectionNode(headA2, headB2).val : "null"));
        System.out.println();

        // Test Case 3: One list is null
        ListNode headA3 = null;
        ListNode headB3 = new ListNode(1);
        System.out.println("Test Case 3: One list is null");
        System.out.println("Intersection value: " + (solution.getIntersectionNode(headA3, headB3) != null ? solution.getIntersectionNode(headA3, headB3).val : "null"));
        System.out.println();
    }
}
