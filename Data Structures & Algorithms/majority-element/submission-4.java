class Solution {
    public int majorityElement(int[] nums) {

        int cnt = 0;
        int ele = -1;
        for (int n : nums) {
            if (cnt == 0 || ele == n) {
                cnt++;
                ele = n;
            } else cnt--;
        }
        return ele;
    }
}