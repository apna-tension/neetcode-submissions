class Solution {
    public int[] twoSum(int[] num, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int req = t - num[i];
            if (map.containsKey(req)) return new int[]{map.get(req)+1, i+1};
            map.put(num[i], i);
        }
        return new int[]{-1, -1};
    }
}
