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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

public class InvertTree {
    public static void printTreeInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printTreeInOrder(node.left);
        System.out.print(node.val + " ");
        printTreeInOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.print("Original tree (in-order traversal): ");
        printTreeInOrder(root);
        System.out.println();

        Solution solution = new Solution();
        TreeNode invertedRoot = solution.invertTree(root);

        System.out.print("Inverted tree (in-order traversal): ");
        printTreeInOrder(invertedRoot);
        System.out.println();
    }
}
