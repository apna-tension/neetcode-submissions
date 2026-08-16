class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            st.append(strs.get(i).length()).append("#").append(strs.get(i));
        }
        return st.toString();
    }

    // public List<String> decode(String str) {
    //     // System.out.println(str);
    //     List<String> list = new ArrayList<>();
        
    //     int i = 0;
    //     while (i < str.length()) {
    //         StringBuilder len = new StringBuilder();
    //         while (str.charAt(i) != ':') {
    //             len.append(str.charAt(i));
    //             i++;
    //         }
    //         i++;
    //         int length = Integer.parseInt(len.toString());
    //         StringBuilder st = new StringBuilder();
    //         while (length != 0) {
    //             st.append(str.charAt(i));
    //             i++;
    //             length--;
    //         }
    //         list.add(st.toString());
    //     }

    //     return list;
    // }
    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        if (str.length() == 0) return list;
        
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            list.add(str.substring(i, j));
            i = j;
        }   
        return list;
    }
}
// π