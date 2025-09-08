class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
public class LowestCommonAncestorRoot {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        Solution solution = new Solution();
        TreeNode p1 = root.left;
        TreeNode q1 = root.right;
        TreeNode lca1 = solution.lowestCommonAncestor(root, p1, q1);
        System.out.println("The lowest common ancestor of " + p1.val + " and " + q1.val + " is " + lca1.val);
        TreeNode p2 = root.left;
        TreeNode q2 = root.left.right.right;
        TreeNode lca2 = solution.lowestCommonAncestor(root, p2, q2);
        System.out.println("The lowest common ancestor of " + p2.val + " and " + q2.val + " is " + lca2.val);
    }
}
