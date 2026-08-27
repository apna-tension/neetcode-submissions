class Solution {
    public int mySqrt(int x) {
        long s = 0;
        long e = x;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            System.out.println("hit : " + mid + " : " + s + " : " + e);
            if ((long)(mid * mid) == (long)x) return (int)mid;
            if ((long)(mid * mid) > (long)x) e = mid - 1;
            else s = mid + 1;
        }
        return (int)e;
    }
}