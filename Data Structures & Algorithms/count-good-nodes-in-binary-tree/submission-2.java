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
    public int goodNodes(TreeNode root) {
        // if (root == null) return count;
        return solve(root, Integer.MIN_VALUE);
        // return count;
    }

    private int solve(TreeNode root, int val) {
        if (root == null) return 0;
        // if (root.val >= val) count++;
        int cnt = root.val >= val ? 1 : 0;
        return cnt + solve(root.left, Math.max(val, root.val)) +    solve(root.right, Math.max(val, root.val));
    }
}
