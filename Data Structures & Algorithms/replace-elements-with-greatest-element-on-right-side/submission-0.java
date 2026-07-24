class Solution {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1];
        int prevMax = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            arr[i] = prevMax;
            prevMax = max;
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}