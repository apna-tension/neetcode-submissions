class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int next = 0;
            for (int j = i+1; j < n; j++) {
                if (temp[j] > temp[i]) {
                    next = j-i;
                    break;
                }
            }
            arr[i] = next;
        }
        return arr;
    }
}
