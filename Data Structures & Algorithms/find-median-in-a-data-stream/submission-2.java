class MedianFinder {
    private ArrayList<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        int mid = list.size()/2;
        Collections.sort(list);
        if (list.size() % 2 == 1) return list.get(mid)/1;

        double ans = (double)((double)(list.get(mid) + list.get(mid-1)) / 2);
        return ans;
    }
}
