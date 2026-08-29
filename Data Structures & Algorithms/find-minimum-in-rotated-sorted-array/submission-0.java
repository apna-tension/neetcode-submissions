class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        int min = nums[0];
        while (s <= e) {

            if (nums[s] <= nums[e]) {
                min = Math.min(min, nums[s]);
                return min;
            } 
            int mid = s + (e - s) / 2;
            min = Math.min(min, nums[mid]);
            
            if (nums[mid] >= nums[s]) {
                s = mid + 1;
            } else e = mid - 1;
        }

        return min;
    }
}
