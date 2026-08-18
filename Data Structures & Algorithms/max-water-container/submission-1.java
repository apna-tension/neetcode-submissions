class Solution {
    public int maxArea(int[] hg) {
        int left = 0;
        int right = hg.length-1;
        int max = 0;
        while (left < right) {
            max = Math.max((right-left)*Math.min(hg[left], hg[right]), max);
            if (hg[left] > hg[right]) right--;
            else left++;
        }
        return max;
    }
}
