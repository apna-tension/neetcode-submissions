class Solution {
    public void rotate(int[] nums, int k) {
        while (k --> 0) {
            int ele = nums[nums.length-1];
            for (int i = nums.length-1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = ele;
        }
    }
}