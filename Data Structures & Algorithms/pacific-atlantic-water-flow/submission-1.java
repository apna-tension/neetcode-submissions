
class Solution {
    int[] row = new int[]{0, -1, 0, 1};
    int[] col = new int[]{-1, 0, 1, 0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();

        Set<String> atlantic = new HashSet<>();
        Set<String> pacific = new HashSet<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0 || j == 0) {
                    boolean[][] vis = new boolean[heights.length][heights[0].length];
                    pacific.add(i + ":" + j);
                    vis[i][j] = true;
                    dfs(heights, i, j, vis, pacific);
                }
                if (i == heights.length-1 || j == heights[0].length-1) {
                    boolean[][] vis = new boolean[heights.length][heights[0].length];
                    atlantic.add(i + ":" + j);
                    vis[i][j] = true;
                    dfs(heights, i, j, vis, atlantic);
                }
            }
        }

        List<String> temp = new ArrayList<>();
        for (String str : atlantic) {
            if (pacific.contains(str)) temp.add(str);
        }
        Collections.sort(temp);

        for (String str : temp) {
            list.add(new ArrayList<>(split(str)));
        }

        return list;
    }

    private List<Integer> split(String str) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        while (str.charAt(i) != ':') {
            sb1.append(str.charAt(i));
            i++;
        }
        i++;
        while (i < str.length()) {
            sb2.append(str.charAt(i));
            i++;
        }

        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(sb1.toString()));
        list.add(Integer.parseInt(sb2.toString()));
        return list;
        
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] vis, Set<String> set) {
        for (int idx = 0; idx < 4; idx++) {
            int newI = row[idx] + i;
            int newJ = col[idx] + j;

            if (newI >= 0 && newJ >= 0 && newI < grid.length && newJ < grid[0].length && !vis[newI][newJ] && grid[newI][newJ] >= grid[i][j]) {
                vis[newI][newJ] = true;
                set.add(newI + ":" + newJ);
                dfs(grid, newI, newJ, vis, set);
            }
        }
    }
}
