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
    private boolean pFor = false;
    private boolean qFor = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        TreeNode ans = root;
        while (!stack.isEmpty()) {

            TreeNode head = stack.poll();
            pFor = false;
            qFor = false;
            
            isExist(head, p, q);

            if(pFor && qFor) ans = head;

            if (head.left != null) stack.offer(head.left);
            if (head.right != null) stack.offer(head.right);
        }
        return ans;
    }
    private void isExist(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;

        if (root.val == p.val) pFor = true;
        else if (root.val == q.val) qFor = true;

        isExist(root.left, p, q);
        isExist(root.right, p, q);
    }
}
