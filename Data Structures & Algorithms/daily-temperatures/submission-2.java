class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] arr = new int[n];
        
        for (int i = n-1; i >= 0; i--) {
            int j = i + 1;
            while (j < n && temp[j] <= temp[i]) {
                if (arr[j] == 0) {
                    j = n;
                    break;
                }

                j += arr[j];
            }

            if (j < n) arr[i] = j - i;
        }
        return arr;
    }
}
