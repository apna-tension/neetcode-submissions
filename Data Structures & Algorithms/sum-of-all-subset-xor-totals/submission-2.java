class Solution {
    private int xor = 0;
    public int subsetXORSum(int[] nums) {
        
        subset(nums, 0, new Stack<>());
        
        return xor;
    }

    private void subset(int[] nums, int i, Stack<Integer> ds) {
        if (i >= nums.length) {
            int xr = 0;
            for (int ele : ds) xr ^= ele;
            xor += xr;
            return;
        }

        ds.push(nums[i]);
        subset(nums, i+1, ds);
        ds.pop();
        subset(nums, i+1, ds);
    }
}