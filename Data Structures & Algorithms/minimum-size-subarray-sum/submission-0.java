class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int min = nums.length+1;
        while (i < nums.length) {
            sum += nums[i];
            while (j <= i && sum >= target) {
                sum -= nums[j];
                min = Math.min(i - j + 1, min);
                j++;
            }
            i++;
        }
        return min == nums.length+1 ? 0 : min;
    }
}