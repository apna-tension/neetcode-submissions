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
    boolean isBal = true;
    public boolean isBalanced(TreeNode root) {
        bal(root);
        return isBal;
    }
    public int bal(TreeNode root) {
        if (root == null) return 0;
        
        int left = 1 + bal(root.left);
        int right = 1 + bal(root.right);

        if (Math.abs(left - right) > 1) isBal = false;

        return Math.max(left, right);
    }
}
