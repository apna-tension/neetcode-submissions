class Solution {
    public int countSubstrings(String s) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String str = "";
            for (int j = i; j < s.length(); j++) {
                str += s.charAt(j);
                list.add(str);
            }
        }

        int count = 0;
        for (String temp : list) {
            count += pal(temp);
        }
        // System.out.println(list);
        return count;
    }

    private int pal(String list) {
        int s = 0;
        int e = list.length()-1;
        while (s < e) {
            if (list.charAt(s) != list.charAt(e)) return 0;
            s++;
            e--;
        }
        return 1;
    }

    private void sub(String s, int i, List<Character> ds, List<List<Character>> list) {
        if (i >= s.length()) {
            list.add(new ArrayList<>(ds));
            return;
        }

        ds.add(s.charAt(i));
        sub(s, i+1, ds, list);
        ds.remove(0);
        sub(s, i+1, ds, list);
    }
}
