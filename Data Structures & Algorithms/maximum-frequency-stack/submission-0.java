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
        // System.out.println(map + " : " + list);
    }
    
    public int pop() {
        int maxFr = 0;
        int index = -1;
        for (int i = list.size()-1; i >= 0; i--) {
            // System.out.println(list.get(i) + " : " + map);
            if (map.get(list.get(i)) > maxFr) {
                maxFr = map.get(list.get(i));
                index = i;
            }
        }

        int ele = list.get(index);
        map.put(ele, map.get(ele)-1);
        list.remove(index);
        // System.out.println("delete " + ele + " : " + map);
        return ele;

    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */