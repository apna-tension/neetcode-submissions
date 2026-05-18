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
    public TreeNode buildTree(int[] pre, int[] in) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < pre.length; i++) {
            map.put(in[i], i);
            q.offer(pre[i]);
        }
        return dfs(q, map, 0, pre.length-1);
    }

    private TreeNode dfs(Queue<Integer> q, HashMap<Integer, Integer> map, int l, int r) {
        if (l > r) return null;
        TreeNode root = new TreeNode(q.poll());
        int idx = map.get(root.val);
        root.left = dfs(q, map, l, idx-1);
        root.right = dfs(q, map, idx+1, r);
        return root;

    }
}
