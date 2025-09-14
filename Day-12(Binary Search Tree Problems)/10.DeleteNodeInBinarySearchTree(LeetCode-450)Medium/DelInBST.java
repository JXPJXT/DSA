public class DelInBST{
    // Your deleteNode and findMin methods go here
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        Solution solution = new Solution();

        System.out.println("Original tree structure (in-order traversal):");
        printInOrder(root);
        System.out.println();

        int keyToDelete = 30;
        System.out.println("Deleting node with key: " + keyToDelete);
        
        // Call the deleteNode method
        root = solution.deleteNode(root, keyToDelete);

        System.out.println("Tree after deletion (in-order traversal):");
        printInOrder(root);
        System.out.println();
    }

    // Helper method to print the tree in-order for verification
    public static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }
}