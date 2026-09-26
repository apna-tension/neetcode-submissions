class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        subset(nums, 0, list, new ArrayList<>());
        return new ArrayList<>(list);
    }

    private void subset(int[] nums, int i, Set<List<Integer>> list, List<Integer> ds) {
        if (i >= nums.length) {
            list.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[i]);
        subset(nums, i+1, list, ds);
        ds.remove(ds.size()-1);
        subset(nums, i+1, list, ds);
    }
}
