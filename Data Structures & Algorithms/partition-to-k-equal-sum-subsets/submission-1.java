class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;
        int sum = 0;
        for (int ele : nums) sum += ele;
        if (sum % k != 0) return false;
        int[] arr = new int[k];
        Arrays.sort(nums);
        rev(nums);
        return dfs(nums, 0, arr, k, sum/k);
    }

    private void rev(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
    private boolean dfs(int[] nums, int idx, int[] arr, int k, int req) {
        if (idx == nums.length) {
            return true;
        }

        for (int i = 0; i < k; i++) {
            if (arr[i] + nums[idx] <= req) {
                arr[i] += nums[idx];
                if (dfs(nums, idx+1, arr, k, req)) return true;
                arr[i] -= nums[idx];
            }
        }
        return false;
    }
}