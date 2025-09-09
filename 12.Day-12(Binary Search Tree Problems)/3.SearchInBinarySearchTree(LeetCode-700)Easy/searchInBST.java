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
class searchInBST {
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null || root.val == val) {
      return root;
    }
    if (root.val < val) {
      return searchBST(root.right, val);
    } else {
      return searchBST(root.left, val);
    }
  }

  public static void main(String[] args) {
    searchInBST solution = new searchInBST();

    // Example BST:
    //      4
    //     / \
    //    2   7
    //   / \
    //  1   3
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);

    int target1 = 2;
    TreeNode result1 = solution.searchBST(root, target1);
    if (result1 != null) {
      System.out.println("Node with value " + target1 + " found: " + result1.val);
    } else {
      System.out.println("Node with value " + target1 + " not found.");
    }

    int target2 = 5;
    TreeNode result2 = solution.searchBST(root, target2);
    if (result2 != null) {
      System.out.println("Node with value " + target2 + " found: " + result2.val);
    } else {
      System.out.println("Node with value " + target2 + " not found.");
    }
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