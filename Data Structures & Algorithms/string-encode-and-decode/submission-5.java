class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            st.append(strs.get(i).length());
            st.append(":");
            st.append(strs.get(i));
        }
        return st.toString();
    }

    public List<String> decode(String str) {
        // System.out.println(str);
        List<String> list = new ArrayList<>();
        
        int i = 0;
        while (i < str.length()) {
            StringBuilder len = new StringBuilder();
            while (str.charAt(i) != ':') {
                len.append(str.charAt(i));
                i++;
            }
            i++;
            int length = Integer.parseInt(len.toString());
            StringBuilder st = new StringBuilder();
            while (length != 0) {
                st.append(str.charAt(i));
                i++;
                length--;
            }
            list.add(st.toString());
        }

        return list;
    }
}
// π