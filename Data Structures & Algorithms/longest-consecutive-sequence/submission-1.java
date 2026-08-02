class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int max = 0;
        Arrays.sort(nums);
        for (int n : nums) {
            map.put(n, map.getOrDefault(n-1, 0)+1);
            set.add(n);
            max = Math.max(max, map.get(n));
        }
        return max;
    }
}
