class Solution {
    public void sortColors(int[] nums) {
        int one = 0;
        int zero = 0;
        for (int ele : nums) {
            if (ele == 1) one++;
            else if (ele == 0) zero++;
        }

        Arrays.fill(nums, 2);
        int i = 0;
        while (one > 0 || zero > 0) {
            if (zero > 0) {
                nums[i] = 0;
                zero--;
            } else if (one > 0) {
                nums[i] = 1;
                one--;
            }
            i++;
        } 
    }
}