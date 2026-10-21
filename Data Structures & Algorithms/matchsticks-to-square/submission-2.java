class Solution {
    int count = 0;
    public boolean makesquare(int[] match) {
        
        Arrays.sort(match);
        boolean[] taken = new boolean[match.length];
        int sum = 0;
        for (int i = 0; i < match.length; i++) sum += match[i];
        if (sum % 4 != 0) return false;
        int oneside = sum / 4;
        // for (int i = 0; i < 4; i++) {
        //     dfs(match, 0, oneside, new ArrayList());
        // }
        // return count == 4;
        return dfs(match, 0, oneside, oneside, oneside, oneside);
    }

    private boolean dfs(int[] mat, int i, int left, int right, int top, int bottom) {
        if (i == mat.length && left == 0 && right == 0 && top == 0 && bottom == 0) return true;
        if (i == mat.length || left < 0 && right < 0 && top < 0 && bottom < 0) return false;

        return dfs(mat, i+1, left-mat[i], right, top, bottom) ||
                dfs(mat, i+1, left, right-mat[i], top, bottom) ||
                dfs(mat, i+1, left, right, top-mat[i], bottom) ||
                dfs(mat, i+1, left, right, top, bottom-mat[i]);
    }

    private boolean dfs(int[] mat, int i, int req, List<Integer> list) {
        if (0 == req) {
            System.out.println(list);
            System.out.println(Arrays.toString(mat));

            for (int ele : list) {
                for (int idx = 0; idx < mat.length; idx++) {
                    if (mat[idx] == ele) {
                        mat[idx] = -1;
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(mat));
            count++;
            return true;
        }

        if (i >= mat.length) return false;

        boolean left = false;
        boolean taken = false;
        if (mat[i] != -1) {
            list.add(mat[i]);
            taken = true;
            left = dfs(mat, i+1, req-mat[i], list);
        }

        if (taken) list.remove(list.size()-1);
        boolean right = dfs(mat, i+1, req, list);
        return left || right;
    }
}