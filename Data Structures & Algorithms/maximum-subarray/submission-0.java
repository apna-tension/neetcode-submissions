class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxSoFar = 0;
        for (int num : nums) {
            maxSoFar += num;
            max = Math.max(max, maxSoFar);
            if (maxSoFar < 0) maxSoFar = 0;
        }
        return max;
    }
}
