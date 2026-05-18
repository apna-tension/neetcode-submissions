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
    public int maxPathSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Stack<TreeNode> ds = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ds.push(curr);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        while (!ds.isEmpty()) {
            max = Math.max(max, sum(ds.peek(), ds.pop()));
        }
        return max;
    }
    private int sum(TreeNode root, TreeNode rt) {
        if (root == null) return 0;

        int left = sum(root.left, rt);
        int right = sum(root.right, rt);

        int max = Math.max(root.val, 
            Math.max(root.val + left, 
            root.val + right));
        if (root == rt) max = Math.max(max,  root.val + left + right);
        return max;
    }
}
