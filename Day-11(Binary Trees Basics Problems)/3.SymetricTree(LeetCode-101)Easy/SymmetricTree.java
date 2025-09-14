class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;

        return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode symmetricRoot = new TreeNode(1);
        symmetricRoot.left = new TreeNode(2);
        symmetricRoot.right = new TreeNode(2);
        symmetricRoot.left.left = new TreeNode(3);
        symmetricRoot.left.right = new TreeNode(4);
        symmetricRoot.right.left = new TreeNode(4);
        symmetricRoot.right.right = new TreeNode(3);

        System.out.println("Is the first tree symmetric? " + solution.isSymmetric(symmetricRoot));

        TreeNode asymmetricRoot = new TreeNode(1);
        asymmetricRoot.left = new TreeNode(2);
        asymmetricRoot.right = new TreeNode(2);
        asymmetricRoot.left.right = new TreeNode(3);
        asymmetricRoot.right.right = new TreeNode(3);

        System.out.println("Is the second tree symmetric? " + solution.isSymmetric(asymmetricRoot));
    }
}
