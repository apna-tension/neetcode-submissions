class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMin = 1;
        int currMax = 1;
        for (int i = 0; i < nums.length; i++) {
            int product = currMax * nums[i];
            currMax = Math.max(Math.max(nums[i] * currMax, nums[i] * currMin), nums[i]);
            currMin = Math.min(Math.min(nums[i] * currMin, product), nums[i]);
            max = Math.max(currMax, max);
        }
        return max;
    }
}
