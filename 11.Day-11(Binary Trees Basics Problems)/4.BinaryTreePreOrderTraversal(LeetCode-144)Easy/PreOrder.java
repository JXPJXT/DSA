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
    public java.util.List<Integer> preorderTraversal(TreeNode root) {
        java.util.List<Integer> li = new java.util.ArrayList<>();
        preOrder(root,li);
        return li;
    }
    private void preOrder(TreeNode node, java.util.List<Integer>li){
        if(node==null){
            return;
        }
        li.add(node.val);
        preOrder(node.left,li);
        preOrder(node.right,li);
    }
}
public class PreOrder {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println("Pre-order traversal of the tree: " + solution.preorderTraversal(root));
    }
}
