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
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);

        // // visit all the nodes to check if this node gives max path sum or not
        // while (!stack.isEmpty()) {
        //     TreeNode curr = stack.pop();
        //     max = Math.max(max, sum(curr, curr));
        //     if (curr.left != null) stack.push(curr.left);
        //     if (curr.right != null) stack.push(curr.right);
        // }
        sum(root);
        return max;
    }
    private int sum(TreeNode root) {
        if (root == null) return 0;

        int left = sum(root.left);
        int right = sum(root.right);

        // we don't allow to take both side of ordinary node(except the node we called), only left or right node shoud be taken 
        max = Math.max(max, Math.max(root.val, 
            Math.max(root.val + left, 
            Math.max(root.val + right, root.val + left + right))));

        return Math.max(root.val, 
            Math.max(root.val + left, 
            root.val + right));
    }
}
