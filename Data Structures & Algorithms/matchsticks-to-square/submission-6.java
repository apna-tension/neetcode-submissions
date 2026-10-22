class Solution {
    int count = 0;
    public boolean makesquare(int[] match) {
        
        Arrays.sort(match);
        boolean[] taken = new boolean[match.length];
        int sum = 0;
        for (int i = 0; i < match.length; i++) sum += match[i];
        if (sum % 4 != 0) return false;
        int oneside = sum / 4;
        return dfs(match, 0, new int[4], oneside);
    }

    private boolean dfs(int[] mat, int i, int[] sides, int oneside) {
        if (i == mat.length) return true;
        
        for (int idx = 0; idx < 4; idx++) {
            if (sides[idx] + mat[i] <= oneside) {
                sides[idx] += mat[i];
                if (dfs(mat, i+1, sides, oneside)) return true;
                sides[idx] -= mat[i];
            }
            if (mat[i] == 0) break;
        }
        return false;
    }
}