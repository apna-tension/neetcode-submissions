class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int n = nums.length;
        int j = 0;
        int min = nums.length+1;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (j <= i && sum >= target) {
                sum -= nums[j];
                min = Math.min(i - j + 1, min);
                j++;
            }
        }
        return min == n+1 ? 0 : min;
    }
}