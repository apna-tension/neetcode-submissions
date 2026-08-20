class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        int closest = binary(arr, x);

        int i = closest;
        int j = closest+1;
        // list.add(arr[closest]);
        // k--;
        while (k > 0 && i >= 0 && j < arr.length) {
            if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                list.add(arr[i]);
                i--;
            } else {
                list.add(arr[j]);
                j++;
            }
            k--;
        }
        while ( k > 0 && i >= 0) {
            list.add(arr[i]);
            i--;
            k--;
        }

        while (k > 0 && j < arr.length) {
            list.add(arr[j]);
            j++;
            k--;
        }
        Collections.sort(list);
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