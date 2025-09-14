import java.util.Objects;
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
public class SameTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree1_p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode tree1_q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Are tree1 and tree1_q the same? " + solution.isSameTree(tree1_p, tree1_q));
        TreeNode tree2_p = new TreeNode(1, new TreeNode(2), null);
        TreeNode tree2_q = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Are tree2_p and tree2_q the same? " + solution.isSameTree(tree2_p, tree2_q));
    }
}
