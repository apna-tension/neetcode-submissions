class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(nums, set, new ArrayList<>(), target, 0);
        return new ArrayList<>(set);
    }

    private void backtrack(int[] arr, Set<List<Integer>> list, 
    List<Integer> temp, int target, int i) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (i >= arr.length || target < 0) return;
        
        temp.add(arr[i]);
        backtrack(arr, list, temp, target-arr[i], i);
        temp.remove(temp.size()-1);
        backtrack(arr, list, temp, target, i+1);
    }
}
