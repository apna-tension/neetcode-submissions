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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        sum(root);
        return max;
    }
    private int sum(TreeNode root) {
        if (root == null) return 0;

        int left = sum(root.left);
        int right = sum(root.right);

        int currMax = Math.max(root.val, 
            Math.max(root.val + left, 
            root.val + right));

        max = Math.max(max, Math.max(currMax, root.val + left + right));
        return currMax;
    }
}
