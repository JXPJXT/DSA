class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        InsertIntoBST solution = new InsertIntoBST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int valueToInsert = 5;
        TreeNode newRoot = solution.insertIntoBST(root, valueToInsert);

        System.out.println("Original tree structure: [4, 2, 7, 1, 3, null, null]");
        System.out.println("Inserting value: " + valueToInsert);

        System.out.print("In-order traversal of the new tree: ");
        printInOrder(newRoot);
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

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}