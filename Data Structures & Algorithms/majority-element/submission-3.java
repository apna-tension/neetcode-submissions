class Solution {
    public int majorityElement(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int ele : nums) {
        //     map.put(ele, map.getOrDefault(ele, 0) + 1);
        //     if (map.get(ele) > nums.length/2) return ele;
        // }
        // return -1;

        // Arrays.sort(nums);
        // return nums[nums.length/2];

        int cnt = 0;
        int ele = nums[0];
        for (int n : nums) {
            if (cnt == 0 || ele == n) {
                cnt++;
                ele = n;
            } else cnt--;
        }
        return ele;
    }
}