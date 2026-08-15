class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int length = nums.length;
        for (int i = 0; i < length-k; i++) {
            if (nums[i] == val) {
                for (int j = i; j < length-k-1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[length-k-1] = -1;
                k++;
                i--;
            }
        }
        // System.out.println(Arrays.toString(nums));
        return length-k;
    }
}