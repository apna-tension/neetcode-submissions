class Touple {
    int freq;
    int idx;
    int val;

    Touple(int freq, int idx, int val) {
        this.freq = freq;
        this.idx = idx;
        this.val = val;
    }
}
class FreqStack {
    Map<Integer, Integer> map;
    // Stack<Integer> stack;
    int idx;
    PriorityQueue<Touple> pq;
    public FreqStack() {
        idx = 0;
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> a.freq != b.freq ? 
        Integer.compare(b.freq, a.freq) : Integer.compare(b.idx, a.idx));
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        pq.offer(new Touple(map.get(val), idx, val));
        idx++;
    }
    
    public int pop() {
        Touple touple = pq.poll();
        int val = touple.val;
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