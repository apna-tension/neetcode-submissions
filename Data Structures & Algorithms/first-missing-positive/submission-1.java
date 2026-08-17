class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int ele : nums) if (ele > 0) set.add(ele);
        for (int i = 1; i <= nums.length+1; i++) if (!set.contains(i)) return i;
        return -1;
    }
}