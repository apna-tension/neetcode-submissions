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
    int count = 1;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        solve(root.left, root.val);
        solve(root.right, root.val);
        return count;
    }

    private void solve(TreeNode root, int val) {
        if (root == null) return;

        if (root.val >= val) count++;
        solve(root.left, Math.max(val, root.val));
        solve(root.right, Math.max(val, root.val));
    }
}
