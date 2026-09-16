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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visit = new HashSet<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();

        map.put(root, null);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left == null && curr.right == null) {
                if (curr.val == target) {
                    TreeNode parent = map.get(curr);
                    if (parent == null) return null;

                    if (parent.left == curr) parent.left = null;
                    if (parent.right == curr) parent.right = null;
                }
            } else if (visit.add(curr)) {
                stack.push(curr);
                if (curr.left != null) {
                    stack.push(curr.left);
                    map.put(curr.left, curr);
                }

                if (curr.right != null) {
                    stack.push(curr.right);
                    map.put(curr.right, curr);
                }
            }
        }
        return root;
    }
}