/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(i == size - 1) {
                    list.add(current.val);
                }
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                
            }
            
        }
        return list;
    }
}

// 1
// 2,3

