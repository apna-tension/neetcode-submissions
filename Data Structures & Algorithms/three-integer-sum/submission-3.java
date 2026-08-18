class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            int left = i+1; 
            int right = nums.length-1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    // List<Integer> ds = Arrays.asList(nums[i], nums[left], nums[right]);  
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                }

                else if (nums[left] + nums[right] > target) right--;
                else left++;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(list);
        return ans;
    }
}
