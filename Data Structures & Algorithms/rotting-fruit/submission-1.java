class Trio {
    int i;
    int j;
    int time;
    Trio(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Trio> q = new LinkedList<>();
        int[] row = new int[]{0, 0, -1, 1};
        int[] col = new int[]{-1, 1, 0, 0};
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) {
                    q.offer(new Trio(i, j, 0));
                }
            }
        }

        if (fresh == 0) return 0;
        if (q.isEmpty()) return -1;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size --> 0) {
                Trio t = q.poll();
                for (int idx = 0; idx < 4; idx++) {
                    int newI = t.i + row[idx];
                    int newJ = t.j + col[idx];
                    if (newI < 0 || newI >= grid.length || newJ < 0 || newJ >= grid[0].length || grid[newI][newJ] != 1) continue;

                    grid[newI][newJ] = 0;
                    q.offer(new Trio(newI, newJ, t.time+1));
                    time = t.time+1;
                    fresh--;
                }
            }
        }

        if (fresh == 0) return time;
        return -1;
    }
}
