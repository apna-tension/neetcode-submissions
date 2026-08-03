class Solution {
    public int[] twoSum(int[] num, int t) {
        int i = 0;
        int j = num.length-1;
        while (i <= j) {
            int sum = num[i] + num[j];
            if (sum == t) return new int[]{i+1, j+1};
            else if (sum > t) j--;
            else i++;
        }
        return new int[]{-1, -1};
    }
}
