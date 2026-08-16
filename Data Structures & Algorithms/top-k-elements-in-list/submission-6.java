class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            set.add(ele);
        }


        Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
        for (int ele : set) {
            int freq = map.get(ele);
            if (!pq.contains(freq)) pq.offer(freq);
            if (!map2.containsKey(freq)) map2.put(freq, new ArrayList<>());
            map2.get(freq).add(ele);
        }

        int[] ans = new int[k];
        while (k != 0) {
            List<Integer> list = map2.get(pq.poll());
            for (int ele : list) {
                ans[k-1] = ele;
                k--;
                if (k == 0) return ans;
            }
        }

        return ans;
    }

}
