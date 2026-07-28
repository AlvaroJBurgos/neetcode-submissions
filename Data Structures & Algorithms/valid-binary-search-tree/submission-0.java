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
    public boolean isValidBST(TreeNode root) {
        return range(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean range(TreeNode root, int lower, int higher) {
        if(root == null) {
            return true;
        }

        if(root.val > lower && root.val < higher) {
            return range(root.left, lower, root.val) && range(root.right, root.val, higher);
            
        }
        return false;

    }
}
