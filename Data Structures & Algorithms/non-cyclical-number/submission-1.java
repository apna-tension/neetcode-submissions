class Solution {
    public boolean isHappy(int temp) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sqSum = 0;
            while (temp != 0) {
                int dig = (temp % 10);
                temp /= 10;
                sqSum += (dig * dig);
            }
            if (sqSum == 1) return true;
            if (!set.add(sqSum)) return false;
            temp = sqSum;
        }
    }
}
