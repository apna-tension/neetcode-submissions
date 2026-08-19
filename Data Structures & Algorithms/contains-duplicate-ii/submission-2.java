class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // int i = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i - j > k) {
                map.put(nums[j], map.get(nums[j]) - 1);
                j++;
            }
            if (map.get(nums[i]) >= 2) return true;
        }
        return false;
    }
}