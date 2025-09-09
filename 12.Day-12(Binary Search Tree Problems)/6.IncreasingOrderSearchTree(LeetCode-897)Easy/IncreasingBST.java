import java.util.ArrayList;
import java.util.List;

class IncreasingBST {
  List<Integer> list = new ArrayList<>();

  public TreeNode increasingBST(TreeNode root) {
    inOrder(root, list);
    TreeNode dummy = new TreeNode(0);
    TreeNode temp = dummy;
    int index = 0;
    while (index < list.size()) {
      temp.right = new TreeNode(list.get(index++));
      temp = temp.right;
    }
    return dummy.right;
  }

  public static void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
  }

  public static void main(String[] args) {
    IncreasingBST solution = new IncreasingBST();

    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);
    root.right.right = new TreeNode(8);
    root.right.right.left = new TreeNode(7);
    root.right.right.right = new TreeNode(9);

    System.out.println("Original tree structure is a BST.");

    TreeNode newRoot = solution.increasingBST(root);

    System.out.println("In-order traversal of the new tree (should be a linked list):");
    TreeNode current = newRoot;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.right;
    }
    System.out.println();
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