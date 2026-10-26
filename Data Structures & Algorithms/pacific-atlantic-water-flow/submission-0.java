
class Solution {
    int[] row = new int[]{0, -1, 0, 1};
    int[] col = new int[]{-1, 0, 1, 0};
    boolean left, right;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                left = false;
                right = false;
                boolean[][] vis = new boolean[heights.length][heights[0].length];
                vis[i][j] = true;
                System.out.println("call for : " + heights[i][j]);
                dfs(heights, i, j, vis);
                System.out.println(left + " : " + right);

                if (left && right) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(new ArrayList<>(temp));
                }
            }
        }

        return list;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] vis) {
        if (left && right) return;

        if (i == 0 || j == 0) {
            left = true;
        }

        if (i == grid.length-1 || j == grid[0].length-1) {
            right = true;
        }

        for (int idx = 0; idx < 4; idx++) {
            int newI = row[idx] + i;
            int newJ = col[idx] + j;

            if (newI >= 0 && newJ >= 0 && newI < grid.length && newJ < grid[0].length && !vis[newI][newJ] && grid[newI][newJ] <= grid[i][j]) {
                vis[newI][newJ] = true;
                dfs(grid, newI, newJ, vis);
            }
        }
    }
}
