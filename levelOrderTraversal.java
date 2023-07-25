import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

 class levelOrderTraversal {
     public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.peek();
                queue.remove();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                level.add(node.val);
            }
            ans.add(level);
        }
        return ans;
    }
}
