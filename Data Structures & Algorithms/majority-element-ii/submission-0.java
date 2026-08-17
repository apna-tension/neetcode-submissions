class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int req = nums.length / 3 + 1;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            if (map.get(ele) == req) list.add(ele);
        }

        return list;
    }
}