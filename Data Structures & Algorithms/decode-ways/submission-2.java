class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return rec(s, 0, dp);
    }
    
    private int rec(String s, int i, int[] dp) {
        if (i >= s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != -1) return dp[i];

        int one = rec(s, i+1, dp);
        int two = 0;
        if (i != s.length()-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
            two = rec(s, i+2, dp);
        }
        return dp[i] = one + two;
    }
}
