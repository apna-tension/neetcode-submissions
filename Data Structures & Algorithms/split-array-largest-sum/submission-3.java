class Solution {
    public int splitArray(int[] nums, int k) {
        int e = 0;
        int s = nums[0];
        for (int ele : nums) {
            e += ele;
            s = Math.max(s, ele);
        }
        int ans = e;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (split(mid, nums, k)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    private boolean split(int mid, int[] nums, int k) {
        int sum = 0;
        int ct = 0;
        for (int ele : nums) {
            sum += ele;
            if (sum > mid) {
                sum = ele;
                ct++;
            }
        }
        return ct + 1 <= k;
    }
}