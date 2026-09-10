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
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> q = new Stack<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode poll = q.pop();
            if (poll.right != null) q.push(poll.right);
            if (poll.left != null) q.push(poll.left);
            list.add(poll.val);
        }
        return list;
    }

}