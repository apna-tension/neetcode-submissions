class StockSpanner {
    // Stack<Integer> stack;
    List<Integer> list;
    public StockSpanner() {
        // stack = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int i = list.size()-1;
        while (i > 0 && list.get(i-1) <= list.get(list.size()-1)) i--;
        return list.size()-i;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */