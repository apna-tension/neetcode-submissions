class Solution {
    public int trap(int[] hg) {
        int n = hg.length;
        int postfix[] = new int[n];
        postfix[n-1] = hg[n-1];
        
        for (int i = n-2; i >= 0; i--) {
            postfix[i] = Math.max(postfix[i+1], hg[i]);
        }

        int prefix = hg[0];
        int totalRain = 0;
        for (int i = 1; i < n-1; i++) {
            int minHg = Math.min(prefix, postfix[i]);
            if (minHg > hg[i]) totalRain += (minHg - hg[i]);
            prefix = Math.max(prefix, hg[i]);
        }

        return totalRain;
    }
}
