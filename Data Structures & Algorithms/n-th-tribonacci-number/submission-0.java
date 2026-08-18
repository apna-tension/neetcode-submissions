class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int[] tr = new int[n+1];
        tr[0] = 0;
        tr[1] = tr[2] = 1;
        for (int i = 3; i <= n; i++) {
            tr[i] = tr[i-1] + tr[i-2] + tr[i-3];
        }

        return tr[n];
    }
}