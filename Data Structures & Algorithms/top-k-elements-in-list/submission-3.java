class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        int[] arr2 = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
            // update(arr, map.get(ele));
        }
        // System.out.println(map);
        // return arr;

        for (Map.Entry<Integer, Integer> hm : map.entrySet()) {
            update(arr, arr2, hm.getValue(), hm.getKey());
        }
        return arr2;
    }

    private void update(int arr[], int[] arr2, int fr, int key) {
        int minFr = arr[0];
        int minIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minFr) {
                minFr = arr[i];
                minIdx = i;
            }
        }
        
        if (arr[minIdx] < fr) {
            arr[minIdx] = fr;
            arr2[minIdx] = key;
        }
    }
}
