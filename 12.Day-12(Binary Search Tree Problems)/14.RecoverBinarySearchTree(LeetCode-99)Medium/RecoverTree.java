class RecoverTree {
    TreeNode prev = null, first = null, second = null;

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null)
                first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {
        RecoverTree solution = new RecoverTree();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        System.out.println("Original tree (in-order):");
        printInOrder(root1);
        System.out.println();

        solution.recoverTree(root1);
        System.out.println("Recovered tree (in-order):");
        printInOrder(root1);
        System.out.println();

        RecoverTree solution2 = new RecoverTree();
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(2);
        System.out.println("Original tree 2 (in-order):");
        printInOrder(root2);
        System.out.println();

        solution2.recoverTree(root2);
        System.out.println("Recovered tree 2 (in-order):");
        printInOrder(root2);
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