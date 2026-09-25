class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> set = new ArrayList<>();

        backtrack(nums, set, new ArrayList<>(), target, 0);
        // return new ArrayList<>(set);
        return set;
    }

    private void backtrack(int[] arr, List<List<Integer>> list, 
    List<Integer> temp, int target, int i) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        if (i >= arr.length || target < 0) return;
        
        temp.add(arr[i]);
        backtrack(arr, list, temp, target-arr[i], i+1);
        temp.remove(temp.size()-1);
        while (i < arr.length-1 && arr[i] == arr[i+1]) i++;
        backtrack(arr, list, temp, target, i+1);

    }
    
}
