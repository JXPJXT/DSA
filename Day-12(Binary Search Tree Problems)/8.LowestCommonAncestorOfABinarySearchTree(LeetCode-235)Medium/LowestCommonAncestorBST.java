class LowestCommonAncestorBST {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val > Math.max(p.val, q.val))
      return lowestCommonAncestor(root.left, p, q);
    if (root.val < Math.min(p.val, q.val))
      return lowestCommonAncestor(root.right, p, q);
    return root;
  }

  public static void main(String[] args) {
    LowestCommonAncestorBST solution = new LowestCommonAncestorBST();

    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);

    TreeNode p1 = new TreeNode(2);
    TreeNode q1 = new TreeNode(8);
    TreeNode lca1 = solution.lowestCommonAncestor(root, p1, q1);
    System.out.println("LCA of " + p1.val + " and " + q1.val + " is: " + lca1.val);

    TreeNode p2 = new TreeNode(2);
    TreeNode q2 = new TreeNode(4);
    TreeNode lca2 = solution.lowestCommonAncestor(root, p2, q2);
    System.out.println("LCA of " + p2.val + " and " + q2.val + " is: " + lca2.val);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}