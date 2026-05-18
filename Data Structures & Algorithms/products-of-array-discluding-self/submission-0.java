class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCnt = 0;
        int zeroIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if (ele == 0) {
                zeroCnt++;
                zeroIdx = i;
            }
            else product *= ele;
        }
        int[] ans = new int[nums.length];
        if (zeroCnt > 1) return ans;
        if (zeroCnt == 1) {
            ans[zeroIdx] = product;
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = product / nums[i];
        }
        return ans;
    }
}  
