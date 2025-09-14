import java.lang.Math;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
               isBalanced(root.left) &&
               isBalanced(root.right);
    }
    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
public class BalancedBinTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode balancedRoot = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        balancedRoot.right.left = new TreeNode(15);
        balancedRoot.right.right = new TreeNode(7);
        System.out.println("Is the balanced tree balanced? " + solution.isBalanced(balancedRoot));
        TreeNode unbalancedRoot = new TreeNode(1);
        unbalancedRoot.left = new TreeNode(2);
        unbalancedRoot.left.left = new TreeNode(3);
        System.out.println("Is the unbalanced tree balanced? " + solution.isBalanced(unbalancedRoot));
    }
}
