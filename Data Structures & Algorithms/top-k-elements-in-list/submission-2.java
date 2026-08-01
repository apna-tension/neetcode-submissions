class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
            // update(arr, map.get(ele));
        }
        // System.out.println(map);
        // return arr;

        for (Map.Entry<Integer, Integer> hm : map.entrySet()) {
            update(arr, hm.getValue());
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < k; i++) {
            // int fr = arr[i];
            for (Map.Entry<Integer, Integer> hm : map.entrySet()) {
                if (arr[i] == hm.getValue()) {
                    arr[i] = hm.getKey();
                    map.remove(hm.getKey());
                    break;
                }
            }
        }
        return arr;
    }

    private void update(int arr[], int fr) {
        int minFr = arr[0];
        int minIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minFr) {
                minFr = arr[i];
                minIdx = i;
            }
        }
        
        if (arr[minIdx] < fr) arr[minIdx] = fr;
    }
}
