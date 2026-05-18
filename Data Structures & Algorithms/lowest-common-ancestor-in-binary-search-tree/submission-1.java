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
            // System.out.println("Call for " + head.val);
            pFor = false;
            qFor = false;
            isExist(head, false, false, p, q);
            if(pFor && qFor) ans = head;
                // System.out.println("Hit");
            if (head.left != null) stack.offer(head.left);
            if (head.right != null) stack.offer(head.right);
        }
        return ans;
    }
    private boolean isExist(TreeNode root, boolean forP, boolean forQ, TreeNode p, TreeNode q) {
        if (root == null) return false;
        // System.out.println("Rec : " + forP + " : " + forQ + " : " + root.val);

        boolean left = false;
        boolean right = false;
        if (root.val == p.val) pFor = true;
        if (root.val == q.val) qFor = true;
        left = isExist(root.left, forP, forQ, p, q);
        right = isExist(root.right, forP, forQ, p, q);
        
        return left || right;
    }
}
