class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Double> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                list.add((double)nums1[i++]);
            } else {
                list.add((double)nums2[j++]);
            }
        }

        while (i < nums1.length) list.add((double)nums1[i++]);
        while (j < nums2.length) list.add((double)nums2[j++]);

        if (list.size() % 2 == 1) return list.get(list.size()/2);
        return (double)(list.get(list.size()/2-1) + list.get(list.size()/2)) / 2;
    }
}
