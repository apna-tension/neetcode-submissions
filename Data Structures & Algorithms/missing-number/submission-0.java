class Solution {
    public int missingNumber(int[] nums) {
        int[] arr = new int[nums.length+1];
        Arrays.fill(arr, nums.length+1);
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (arr[i] != i) return i;
        }
        return nums.length;
    }
}
