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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}

public class BinaryTreeDepth {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = solution.maxDepth(root);

        System.out.println("The maximum depth of the binary tree is: " + depth);

        TreeNode anotherRoot = new TreeNode(1);
        anotherRoot.right = new TreeNode(2);
        anotherRoot.right.right = new TreeNode(3);

        int anotherDepth = solution.maxDepth(anotherRoot);
        System.out.println("The maximum depth of the second tree is: " + anotherDepth);
    }
}
