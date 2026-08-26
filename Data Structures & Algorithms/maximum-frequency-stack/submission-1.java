class FreqStack {
    Map<Integer, Integer> map;
    // Stack<Integer> stack;
    List<Integer> list;
    public FreqStack() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        list.add(val);
    }
    
    public int pop() {
        int maxCnt = Collections.max(map.values());
        int i = list.size() - 1;
        while (map.get(list.get(i)) != maxCnt) {
            i--;
        }
        int val = list.remove(i);
        map.put(val, map.get(val) - 1);
        return val;

    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */