class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if (k == arr.length) {
            for (int ele : arr) list.add(ele);
            return list;
        }
        int closest = binary(arr, x);

        int i = closest;
        int j = closest+1;
        while (k > 0 && i >= 0 && j < arr.length) {
            if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                i--;
            } else {
                j++;
            }
            k--;
        }
        while ( k > 0 && i >= 0) {
            i--;
            k--;
        }

        while (k > 0 && j < arr.length) {
            j++;
            k--;
        }
        i++;
        while (i < j) {
            list.add(arr[i]);
            i++;
        }
        return list;
    }
    private int binary(int[] arr, int target) {
        int i = 0;
        int j = arr.length-1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) j = mid-1;
            else i = mid+1;
        }
        return j;
    }
}