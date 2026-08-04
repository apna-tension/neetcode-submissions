class Solution {
    public int trap(int[] hg) {
        int leftMax = hg[0];
        int[] post = new int[hg.length];
        post[hg.length-1] = hg[hg.length-1];

        for (int i = hg.length-2; i >= 0; i--) {
            post[i] = Math.max(post[i+1], hg[i]);
        }

        int total = 0;
        for (int i = 1; i < hg.length-1; i++) {
            leftMax = Math.max(leftMax, hg[i]);
            if (leftMax > hg[i] && post[i] > hg[i]) total += Math.min(leftMax, post[i]) - hg[i];
        }
        return total;
    }
}
