class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        // int min = nums[0];
        int idx = 0;
        while (s <= e) {

            if (nums[s] <= nums[e]) {
                // min = Math.min(min, nums[s]);
                if (nums[s] < nums[idx]) idx = s;
                break;
            } 

            int mid = s + (e - s) / 2;
            // min = Math.min(min, nums[mid]);
            if (nums[mid] < nums[idx]) {
                idx = mid;
            }
            
            if (nums[mid] >= nums[s]) {
                s = mid + 1;
            } else e = mid - 1;
        }

        if (nums[idx] == target) return idx;
        // System.out.println(idx);
        s = 0;
        e = idx-1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) return mid;
            
            if (nums[mid] > target) e = mid - 1;
            else s = mid + 1;
        }

        s = idx + 1;
        e = nums.length-1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) return mid;
            
            if (nums[mid] > target) e = mid - 1;
            else s = mid + 1;
        }
        return -1;
    }
}
