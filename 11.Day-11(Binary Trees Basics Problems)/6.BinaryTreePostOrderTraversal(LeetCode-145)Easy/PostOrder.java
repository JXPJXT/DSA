import java.util.ArrayList;
import java.util.List;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        postOrder(root,li);
        return li;
    }
    private void postOrder(TreeNode root, List<Integer> li){
        if(root==null){
            return;
        }
        postOrder(root.left,li);
        postOrder(root.right,li);
        li.add(root.val);
    }
}
public class PostOrder {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println("Post-order traversal of the tree: " + solution.postorderTraversal(root));
    }
}
