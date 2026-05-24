class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxSoFar = 0;
        for (int num : nums) {
            maxSoFar += num;
            max = Math.max(max, maxSoFar);
            maxSoFar = Math.max(0, maxSoFar);
        }
        return max;
    }
}
