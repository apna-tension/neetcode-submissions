class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        Arrays.sort(nums);
        for (int n : nums) {
            map.put(n, map.getOrDefault(n-1, 0)+1);
            max = Math.max(max, map.get(n));
        }
        // System.out.println(map);
        return max;
    }
}
