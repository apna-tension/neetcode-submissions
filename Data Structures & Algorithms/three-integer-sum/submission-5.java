class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        Set<List<Integer>> list = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i] == arr[i-1]) continue;
            int target = 0 - arr[i];
            int l = i+1; 
            int r = n-1;
            while (l < r) {
                if (arr[l] + arr[r] == target) {
                    list.add(new ArrayList<>(Arrays.asList(arr[i], arr[l], arr[r])));
                    l++;
                    r--;
                }

                else if (arr[l] + arr[r] > target) r--;
                else l++;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(list);
        return ans;
    }
}
