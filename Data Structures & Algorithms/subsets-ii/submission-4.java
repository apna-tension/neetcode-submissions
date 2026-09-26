class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        subset(nums, 0, list, new ArrayList<>());
        return new ArrayList<>(list);
    }

    private void subset(int[] nums, int i, List<List<Integer>> list, List<Integer> ds) {
       
        list.add(new ArrayList<>(ds));

        for (int start = i; start < nums.length; start++) {
            if (start > i && nums[start] == nums[start-1]) continue;
            ds.add(nums[start]);
            subset(nums, start+1, list, ds);
            ds.remove(ds.size()-1);
        }
    }
}
