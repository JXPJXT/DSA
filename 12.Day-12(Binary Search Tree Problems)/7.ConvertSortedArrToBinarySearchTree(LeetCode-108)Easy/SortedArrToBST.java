class SortedArrToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int s, int e) {
        if (s > e)
            return null;
        int i = s + (e - s) / 2;
        TreeNode node = new TreeNode(nums[i]);
        if (s == e)
            return node;
        node.left = buildTree(nums, s, i - 1);
        node.right = buildTree(nums, i + 1, e);
        return node;
    }

    public static void main(String[] args) {
        SortedArrToBST solution = new SortedArrToBST();
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = solution.sortedArrayToBST(nums);
        System.out.println("The sorted array converted to a balanced BST.");
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