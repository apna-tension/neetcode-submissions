class Solution {
    public int mySqrt(int x) {
        // long s = 0;
        // long e = x;
        // while (s <= e) {
        //     long mid = s + (e - s) / 2;
        //     // System.out.println("hit : " + mid + " : " + s + " : " + e);
        //     if ((long)(mid * mid) == (long)x) return (int)mid;
        //     if ((long)(mid * mid) > (long)x) e = mid - 1;
        //     else s = mid + 1;
        // }
        // return (int)e;
        return sq(x, 0, (long)x);
    }

    private int sq(int x, long s, long e) {
        if (s > e) return (int)e;

        long mid = s + (e - s) / 2;
        long rt = mid * mid;
        if (rt == (long)x) return (int)mid;
        
        if (rt > (long)x) return sq(x, s, mid-1);
        else return sq(x, mid+1, e);
    }
}