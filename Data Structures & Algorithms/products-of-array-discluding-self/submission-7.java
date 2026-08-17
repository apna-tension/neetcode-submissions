public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int postfix[] = new int[nums.length];
        postfix[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] == 0) zeroCount++;
            postfix[i] = postfix[i+1] * nums[i];
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        int prefix = 1;
        for (int i = 0; i < nums.length-1; i++) {
            int curr = nums[i];
            nums[i] = prefix * postfix[i+1];
            prefix *= curr;
        }
        nums[nums.length-1] = prefix;
        return nums;
    }
}