class KthSmallestElement {
  int c = 0;

  public int kthSmallest(TreeNode root, int k) {
    return solve(root, k).val;
  }

  private TreeNode solve(TreeNode root, int k) {
    if (root == null) {
      return null;
    }
    TreeNode left = solve(root.left, k);
    if (left != null) {
      return left;
    }
    c++;
    if (c == k) {
      return root;
    }
    return solve(root.right, k);
  }

  public static void main(String[] args) {
    KthSmallestElement solution = new KthSmallestElement();

    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.right = new TreeNode(2);

    int k1 = 1;
    System.out.println("The " + k1 + "st smallest element is: " + solution.kthSmallest(root, k1));

    KthSmallestElement solution2 = new KthSmallestElement();
    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(6);
    root2.left.left = new TreeNode(2);
    root2.left.right = new TreeNode(4);
    root2.left.left.left = new TreeNode(1);

    int k2 = 3;
    System.out.println("The " + k2 + "rd smallest element is: " + solution2.kthSmallest(root2, k2));
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