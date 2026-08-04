class Solution {
    public int maxArea(int[] hg) {
        int max = 0;
        int l = 0;
        int r = hg.length-1;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(hg[l], hg[r]));
            if (hg[l] < hg[r]) l++;
            else r--;
        }
        return max;
    }
}
