class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int e = Integer.MIN_VALUE;

        for (int ele : piles) e = Math.max(e, ele);

        int s = 1;
        int min = e;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            long hrs = 0;
            for (int ele : piles) hrs += Math.ceil((double)ele / mid);
            if (hrs <= h) {
                min = Math.min(min, mid);
                e = mid - 1;
            } else s = mid + 1;
        }
        return min;
    }
}
