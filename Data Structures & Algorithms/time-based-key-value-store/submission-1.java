class Pair {
    int time;
    String val;
    Pair(int time, String val) {
        this.time = time;
        this.val = val;
    }
}
class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int s = 0;
        while (s < list.size() && list.get(s).time <= timestamp) s++;
        if (s == 0) return "";
        return list.get(s-1).val;
    }
}
