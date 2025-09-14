/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class MinAbsDiff {
  private int min = Integer.MAX_VALUE, prev = -1;

  private void find(TreeNode root) {
    if (root == null) {
      return;
    }
    find(root.left);
    if (prev >= 0 && min > root.val - prev) {
      min = root.val - prev;
    }
    prev = root.val;
    find(root.right);
  }

  public int getMinimumDifference(TreeNode root) {
    find(root);
    return min;
  }

  public static void main(String[] args) {
    MinAbsDiff solution = new MinAbsDiff();

    // Example 1:
    //      4
    //     / \
    //    2   6
    //   / \
    //  1   3
    TreeNode root1 = new TreeNode(4);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(6);
    root1.left.left = new TreeNode(1);
    root1.left.right = new TreeNode(3);
    System.out.println("The minimum absolute difference is: " + solution.getMinimumDifference(root1)); // Expected: 1

    // Example 2:
    //      1
    //       \
    //        3
    //       /
    //      2
    TreeNode root2 = new TreeNode(1);
    root2.right = new TreeNode(3);
    root2.right.left = new TreeNode(2);
    System.out.println("The minimum absolute difference is: " + solution.getMinimumDifference(root2)); // Expected: 1
  }
}

// A simplified TreeNode class for demonstration purposes.
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