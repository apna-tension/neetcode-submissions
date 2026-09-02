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
    
    public String get(String key, int time) {
        if (!map.containsKey(key)) return "";
        int s = 0;
        int e = map.get(key).size()-1;
        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (map.get(key).get(mid).time == time) return map.get(key).get(mid).val;

            if (map.get(key).get(mid).time > time) e = mid-1;
            else s = mid+1;
        }

        if (e < 0) return "";
        return map.get(key).get(e).val;
    }
}
