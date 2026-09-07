/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mnt) {
        int peak = -1;
        int s = 0;
        int e = mnt.length();
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int midEle = mnt.get(mid);
            if (mid > 0 && mid < mnt.length()-1 && midEle > mnt.get(mid-1) && midEle > mnt.get(mid+1)) {
                peak = mid;
                if (midEle == target) return mid;
                break;
            }

            if (mid > 0 && midEle > mnt.get(mid-1)) s = mid + 1;
            else e = mid - 1;
        }



        // System.out.println(peak);


        s = 0;
        e = peak-1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int midEle = mnt.get(mid);
            if (midEle == target) return mid;

            if (midEle > target) e = mid - 1;
            else s = mid + 1;
        }

        e = mnt.length()-1;
        s = peak+1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int midEle = mnt.get(mid);
            if (midEle == target) return mid;

            if (midEle > target) s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }
}