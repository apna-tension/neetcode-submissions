class Solution {
    public int trap(int[] hg) {
        int[] pre = new int[hg.length];
        int[] post = new int[hg.length];
        pre[0] = hg[0];
        for (int i = 1; i < hg.length; i++) {
            pre[i] = Math.max(pre[i-1], hg[i]);
        }
        post[hg.length-1] = hg[hg.length-1];
        for (int i = hg.length-2; i >= 0; i--) {
            post[i] = Math.max(post[i+1], hg[i]);
        }

        int total = 0;
        for (int i = 1; i < hg.length-1; i++) {
            if (pre[i] > hg[i] && post[i] > hg[i]) total += Math.min(pre[i], post[i]) - hg[i];
        }
        return total;
    }
}
