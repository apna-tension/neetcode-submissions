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
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
            q.offer(pre[i]);
        }

        return dfs(map, q, 0, in.length);
    }

    private TreeNode dfs(Map<Integer, Integer> map, Queue<Integer> q, int l, int r) {
        if (l > r || q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());
        int i = map.get(root.val);
        root.left = dfs(map, q, l, i-1);
        root.right = dfs(map, q, i+1, r);
        return root;
    }
}
