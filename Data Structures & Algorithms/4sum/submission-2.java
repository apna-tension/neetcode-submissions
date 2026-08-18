class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            // int remain = target - nums[i];

            for (int j = i+1; j < n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;

                // remain -= nums[j];
                int l = j+1;
                int r = n-1;
                while (l < r) {
                    long sum = (long) nums[l] + nums[r] + nums[i] + nums[j];
                    if (sum == target) {
                        list.add(new ArrayList<>(
                            Arrays.asList(nums[i], nums[j], nums[l], nums[r])
                        ));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l-1]) l++;
                        while (l < r && nums[r] == nums[r+1]) r--;
                        // r--;
                    } else if (sum > target) r--;
                    else l++;
                }
                
            }
        }

        // List<List<Integer>> setToList = new ArrayList<>();
        // setToList.addAll(list);
        return list;
    }
}