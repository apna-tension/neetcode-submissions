class Solution {
    public int subsetXORSum(int[] nums) {
        int xor = 0;
        List<List<Integer>> list = new ArrayList<>();
        subset(nums, 0, list, new Stack<>());
        for (List<Integer> ds : list) {
            int xr = 0;
            for (int ele : ds) xr ^= ele;
            xor += xr;
        }
        return xor;
    }

    private void subset(int[] nums, int i, List<List<Integer>> list, Stack<Integer> ds) {
        if (i >= nums.length) {
            list.add(new ArrayList(ds));
            return;
        }

        ds.push(nums[i]);
        subset(nums, i+1, list, ds);
        ds.pop();
        subset(nums, i+1, list, ds);
    }
}