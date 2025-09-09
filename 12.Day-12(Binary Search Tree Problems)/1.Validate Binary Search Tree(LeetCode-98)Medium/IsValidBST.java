class IsValidBST {
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  private boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
    if (root == null)
      return true;
    if (minNode != null && root.val <= minNode.val)
      return false;
    if (maxNode != null && root.val >= maxNode.val)
      return false;

    return
        isValidBST(root.left, minNode, root) &&
        isValidBST(root.right, root, maxNode);
  }

  public static void main(String[] args) {
    IsValidBST solution = new IsValidBST();

    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(3);
    System.out.println("Is the first tree a valid BST? " + solution.isValidBST(root1));

    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(1);
    root2.right = new TreeNode(4);
    root2.right.left = new TreeNode(3);
    root2.right.right = new TreeNode(6);
    System.out.println("Is the second tree a valid BST? " + solution.isValidBST(root2));
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