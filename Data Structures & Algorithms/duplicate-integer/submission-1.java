class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int ele : nums) if (!set.add(ele)) return true;
        return false;
    }
}
