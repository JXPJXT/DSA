class BSTFromPreorder {
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode construct(int[] preorder, int low, int high) {
        if (i >= preorder.length)
            return null;
        if (preorder[i] < low || preorder[i] > high)
            return null;

        TreeNode root = new TreeNode(preorder[i++]);
        root.left = construct(preorder, low, root.val);
        root.right = construct(preorder, root.val, high);

        return root;
    }

    public static void main(String[] args) {
        BSTFromPreorder solution = new BSTFromPreorder();
        int[] preorder = {8, 5, 1, 7, 10, 12};

        TreeNode root = solution.bstFromPreorder(preorder);

        System.out.println("The preorder array converted to a BST.");
        System.out.print("In-order traversal of the BST: ");
        printInOrder(root);
        System.out.println();
    }

    public static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}