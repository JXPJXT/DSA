class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public java.util.List<Integer> inorderTraversal(TreeNode root) {
        java.util.List<Integer> li = new java.util.ArrayList<>();
        inOrder(root,li);
        return li;
    }
    private void inOrder(TreeNode root, java.util.List<Integer> li){
        if(root==null){
            return;
        }
        inOrder(root.left,li);
        li.add(root.val);
        inOrder(root.right,li);
    }
}
public class InOrder {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println("In-order traversal of the tree: " + solution.inorderTraversal(root));
    }
}
