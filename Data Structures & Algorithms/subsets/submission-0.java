class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsets(nums, 0, list, new ArrayList<>());
        return list;
    }

    private void subsets(int[] nums, int i, List<List<Integer>> list, List<Integer> ds) {
        if (i >= nums.length) {
            list.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[i]);
        subsets(nums, i+1, list, ds);
        ds.remove(ds.size()-1);
        subsets(nums, i+1, list, ds);
    }
}
