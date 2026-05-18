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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null) return false;
        boolean ans = subTree(root, subRoot);
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        return ans || left || right;
    }
    private boolean subTree(TreeNode root, TreeNode sub) {
        if (root == null && sub == null) return true;
        if (root == null || sub == null || root.val != sub.val) return false;
        return subTree(root.left, sub.left) && subTree(root.right, sub.right);
    }
}
