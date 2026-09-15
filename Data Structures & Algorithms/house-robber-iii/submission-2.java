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
    int take;
    int notTake;
    Pair(int take, int notTake) {
        this.take = take;
        this.notTake = notTake;
    }
}
class Solution {
    // private int i;
    // public int rob(TreeNode root) {
    //     Map<TreeNode, Integer> map = new HashMap<>();
    //     i = 0;
    //     mapBuild(root, map);
    //     int[][] dp = new int[map.size()][2];
    //     for (int i = 0; i < map.size(); i++) {
    //         dp[i][0] = -1;
    //         dp[i][1] = -1;
    //     }
    //     return rob(root, 0, map, dp);
    // }

    // private void mapBuild(TreeNode root, Map<TreeNode, Integer> map) {
    //     if (root == null) return;
    //     mapBuild(root.left, map);
    //     mapBuild(root.right, map);
    //     map.put(root, i);
    //     i++;
    // }
    public int rob(TreeNode root) {
        Pair p = dfs(root);
        return Math.max(p.take, p.notTake);
    }
    private Pair dfs(TreeNode root) {
        if (root == null) return new Pair(0, 0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        return new Pair(root.val + left.notTake + right.notTake, Math.max(left.take, left.notTake) + Math.max(right.take, right.notTake));
    }

    // private int rob(TreeNode root, int flag, Map<TreeNode, Integer> map, int[][] dp) {
    //     if (root == null) return 0;
    //     if (dp[map.get(root)][flag] != -1) return dp[map.get(root)][flag];

    //     int take = 0;
    //     if (flag == 0) take = root.val + rob(root.left, 1, map, dp) + rob(root.right, 1, map, dp);
    //     int notTake = rob(root.left, 0, map, dp) + rob(root.right, 0, map, dp);
    //     return dp[map.get(root)][flag] = Math.max(take, notTake);
    // }
}