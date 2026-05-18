class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        List<Integer> size = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String str : strs) size.add(str.length());

        for (int sz : size) sb.append(sz).append(',');

        sb.append('#');

        for (String str : strs) sb.append(str);

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        if (str.length() == 0) return list;
        
        List<Integer> size = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuilder curr = new StringBuilder();
            while (str.charAt(i) != ',') {
                curr.append(str.charAt(i++));
            }

            size.add(Integer.parseInt(curr.toString()));
            i++;
        }

        i++;

        for (int sz : size) {
            list.add(str.substring(i, i+sz));
            i += sz;
        }
        return list;
    }
}
