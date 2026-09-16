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
    int globalMax;
    public int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        dfs(root);
        return globalMax;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int currMax = Math.max(root.val, Math.max(root.val + left, root.val + right));

        globalMax = Math.max(globalMax, Math.max(currMax, root.val + left + right));
        return currMax;
    }

}
