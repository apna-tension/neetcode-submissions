class Solution {
    public boolean canJump(int[] nums) {
        return can(nums, 0);
    }

    private boolean can(int[] nums, int i) {
        if (i >= nums.length-1) return true;
        if (nums[i] == 0) return false;

        boolean isTrue = false;
        for (int j = i+1; j <= i+nums[i]; j++) {
            isTrue = isTrue || can(nums, j);
        }

        return isTrue;
    }
}
