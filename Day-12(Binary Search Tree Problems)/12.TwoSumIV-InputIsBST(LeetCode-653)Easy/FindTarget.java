import java.util.HashSet;
import java.util.Set;

class FindTarget {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k);
    }

    boolean helper(TreeNode node, int k) {
        if (node == null) {
            return false;
        }
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return helper(node.left, k) || helper(node.right, k);
    }

    public static void main(String[] args) {
        FindTarget solution = new FindTarget();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);
        int k1 = 9;
        System.out.println("For k=" + k1 + ", target found: " + solution.findTarget(root1, k1));

        FindTarget solution2 = new FindTarget();
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        int k2 = 4;
        System.out.println("For k=" + k2 + ", target found: " + solution2.findTarget(root2, k2));
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