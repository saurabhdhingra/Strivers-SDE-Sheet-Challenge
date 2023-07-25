import java.util.List;
import java.util.ArrayList;

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

class BTPreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<Integer>();
        recursive(root, traversal);
        return traversal;
    }

    private static void recursive(TreeNode root, List<Integer> traversal){
        if(root == null)
            return;        
        traversal.add(root.val);
        recursive(root.left, traversal);
        recursive(root.right, traversal);

    }
}