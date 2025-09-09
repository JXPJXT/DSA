import java.util.ArrayList;
import java.util.List;

class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        inOrder(root, li);
        return li;
    }

    private void inOrder(TreeNode root, List<Integer> li) {
        if (root == null) {
            return;
        }
        inOrder(root.left, li);
        li.add(root.val);
        inOrder(root.right, li);
    }

    public static void main(String[] args) {
        InorderTraversal solution = new InorderTraversal();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = solution.inorderTraversal(root);
        System.out.println("In-order traversal result: " + result);
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