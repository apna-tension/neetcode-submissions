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
    TreeNode a, b;
    Pair(TreeNode a, TreeNode b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(p, q));
        while (!qu.isEmpty()) {
            Pair pr = qu.poll();
            if (pr.a == null && pr.b == null) continue;
            if (pr.a == null || pr.b == null || pr.a.val != pr.b.val) return false;
            
            qu.offer(new Pair(pr.a.left, pr.b.left));
            qu.offer(new Pair(pr.a.right, pr.b.right));
        }
        return true;
    }
}
