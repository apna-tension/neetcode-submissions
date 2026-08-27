class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long up = 0;
        long low = 0;
        for (int ele : weights) {
            up += (long)ele;
            low = Math.max(low, ele);
        }

        long min = up;
        while (low <= up) {
            long mid = low + (up - low) / 2;
            int d = 1;
            int cap = 0;
            for (int ele : weights) {
                cap += ele;
                if (cap > mid) {
                    cap = ele;
                    d++;
                }
            }
            if (d <= days) {
                min = Math.min(mid, min);
                up = mid - 1;
            } else low = mid + 1;
        }
        return (int)min;
    }
}