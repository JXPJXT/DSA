class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (head == null || head.next == null){
            return true;
        }
        ListNode mid = slow ;
        ListNode prev = null;
        ListNode curr = mid;
        ListNode next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode right = prev;
        ListNode left = head;
        while (right != null) {
            if(right.val != left.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
class PalindromeLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: Palindrome list (e.g., 1 -> 2 -> 2 -> 1)
        System.out.println("Test Case 1: Palindrome list");
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println("Is the list a palindrome? " + solution.isPalindrome(head1));
        System.out.println();
        // Test case 2: Non-palindrome list (e.g., 1 -> 2)
        System.out.println("Test Case 2: Non-palindrome list");
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Is the list a palindrome? " + solution.isPalindrome(head2));
        System.out.println();
        // Test case 3: Single-node list (e.g., 1)
        System.out.println("Test Case 3: Single-node list");
        ListNode head3 = new ListNode(1);
        System.out.println("Is the list a palindrome? " + solution.isPalindrome(head3));
        System.out.println();
        // Test case 4: Empty list
        System.out.println("Test Case 4: Empty list");
        ListNode head4 = null;
        System.out.println("Is the list a palindrome? " + solution.isPalindrome(head4));
        System.out.println();
    }
}
