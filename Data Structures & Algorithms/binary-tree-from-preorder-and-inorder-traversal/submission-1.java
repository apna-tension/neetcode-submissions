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
    int i;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
            q.offer(preorder[i]);
        }
        i = 0;
        return solve(q, map, 0, preorder.length-1);
    }

    private TreeNode solve(Queue<Integer> q, HashMap<Integer, Integer> map, int l, int r) {
        if (l > r) return null;
        TreeNode node = new TreeNode(q.poll());
        int idx = map.get(node.val);
        node.left = solve(q, map, l, idx-1);
        node.right = solve(q, map, idx+1, r);
        return node;

    }
}
