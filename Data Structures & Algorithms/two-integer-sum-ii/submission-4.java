class Solution {
    public int[] twoSum(int[] num, int t) {
        int i = 0;
        int j = num.length-1;
        while (i < j) {
            int currSum = num[i] + num[j];
            if (currSum == t) return new int[]{i+1, j+1};
            if (currSum > t) j--;
            else i++;
        }

        return new int[]{-1, -1};
    }
}
