class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }
}
class AddTwoNums {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test Case 1: 342 + 465 = 807
        ListNode l1_1 = new ListNode(2);
        l1_1.next = new ListNode(4);
        l1_1.next.next = new ListNode(3);
        ListNode l2_1 = new ListNode(5);
        l2_1.next = new ListNode(6);
        l2_1.next.next = new ListNode(4);
        System.out.print("List 1: ");
        printList(l1_1);
        System.out.print("List 2: ");
        printList(l2_1);
        ListNode result1 = solution.addTwoNumbers(l1_1, l2_1);
        System.out.print("Result: ");
        printList(result1);
        System.out.println();
        // Test Case 2: 999 + 1 = 1000
        ListNode l1_2 = new ListNode(9);
        l1_2.next = new ListNode(9);
        l1_2.next.next = new ListNode(9);
        ListNode l2_2 = new ListNode(1);
        System.out.print("List 1: ");
        printList(l1_2);
        System.out.print("List 2: ");
        printList(l2_2);
        ListNode result2 = solution.addTwoNumbers(l1_2, l2_2);
        System.out.print("Result: ");
        printList(result2);
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
