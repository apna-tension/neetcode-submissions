class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        // boolean[] visit = 
        permute(nums, list, new ArrayList<>(), new boolean[nums.length]);
        return new ArrayList<>(list);
    }

    private void permute(int[] nums, Set<List<Integer>> list, List<Integer> ds, boolean[] visit) {
        if (ds.size() == nums.length) {
            list.add(new ArrayList<>(ds));
            return;
        }

        // if (i >= nums.length) return;

        for (int j = 0; j < nums.length; j++) {
            if (!visit[j]) {
                visit[j] = true;
                ds.add(nums[j]);
                permute(nums, list, ds, visit);
                ds.remove(ds.size()-1);
                visit[j] = false;
            }
        }
    }
}