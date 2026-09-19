class Solution {
    private int xor = 0;
    public int subsetXORSum(int[] nums) {
        
       return subset(nums, 0, 0);
    }

    private int subset(int[] nums, int i, int sum) {
        if (i >= nums.length) return sum;
        return subset(nums, i+1, sum ^ nums[i]) + subset(nums, i+1, sum);
    }
}