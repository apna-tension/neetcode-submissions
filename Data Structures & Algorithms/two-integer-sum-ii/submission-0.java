class Solution {
    public int[] twoSum(int[] num, int t) {
        for (int i = 0; i < num.length; i++) {
            int req = t - num[i];
            int src = search(num, i, req);
            if (src != -1) return new int[]{i+1, src+1};
        }
        return new int[]{-1, -1};
    }
    private int search(int[] num, int i, int t) {
        int j = num.length-1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (num[mid] == t) return mid;
            if (num[mid] > t) j = mid-1;
            else i = mid+1;
        }
        return -1;
    }
}
