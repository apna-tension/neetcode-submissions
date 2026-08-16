class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1;
        while(i < n) {
            if (nums[i] == nums[i-1]) {
                for (int j = i; j < n-1; j++) {
                    nums[j] = nums[j+1];
                }
                n--;
            } else i++;
        }
        return n;
    }
}