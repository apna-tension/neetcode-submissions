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
        List<Pair> list = map.get(key);
        int s = 0;
        int e = list.size()-1;
        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (list.get(mid).time == time) return list.get(mid).val;

            if (list.get(mid).time > time) e = mid-1;
            else s = mid+1;
        }

        // System.out.println(s + " : " + e);

        if (e < 0) return "";
        return list.get(e).val;
    }
}
