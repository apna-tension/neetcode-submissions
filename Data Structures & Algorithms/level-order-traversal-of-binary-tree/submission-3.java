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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        dfs(root, list, 0);

        return list;
    }

    private void dfs(TreeNode root, List<List<Integer>> list, int h) {
        if (root == null) return;

        if (h >= list.size()) list.add(new ArrayList<>());
        list.get(h).add(root.val);

        dfs(root.left, list, h+1);
        dfs(root.right, list, h+1);
    }
}
