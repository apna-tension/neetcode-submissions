class Solution {
    public int[] twoSum(int[] num, int t) {
        int i = 0;
        int j = num.length-1;
        while (i <= j) {
            if (num[i] + num[j] == t) return new int[]{i+1, j+1};
            else if (num[i] + num[j] > t) j--;
            else i++;
        }
        return new int[]{-1, -1};
    }
}
