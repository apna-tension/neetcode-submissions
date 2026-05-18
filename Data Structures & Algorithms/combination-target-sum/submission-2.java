class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        back(nums, list, new ArrayList<>(), target, 0);
        // System.out.println(list);
        // for (List<Integer> temp : set) list.add(new ArrayList<>(temp));
        return list;
    }

    private void back(int[] arr, List<List<Integer>> list, List<Integer> temp, int target, int i) {
        if (target == 0) {
            if (!list.contains(temp)) list.add(new ArrayList<>(temp));
            return;
        }
        if (i >= arr.length || target < 0) return;
        temp.add(arr[i]);
        back(arr, list, temp, target-arr[i], i);
        temp.remove(temp.size()-1);
        back(arr, list, temp, target, i+1);
    }
}
