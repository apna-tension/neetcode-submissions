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
class Pair {
    TreeNode head;
    int depth;
    Pair(TreeNode head, int depth) {
        this.head = head;
        this.depth = depth;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        int max = 1;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            max = Math.max(max, p.depth);
            if (p.head.left != null) q.offer(new Pair(p.head.left, p.depth+1));
            if (p.head.right != null) q.offer(new Pair(p.head.right, p.depth+1));
        }
        return max;
    }
}
