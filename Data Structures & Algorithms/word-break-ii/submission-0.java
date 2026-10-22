class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String wrd : wordDict) {
            set.add(wrd);
        }
        dfs(s, 0, set, new ArrayList<>(), list);
        List<String> ans = new ArrayList<>();
        for (List<String> temp : list) {
            String str = temp.get(0);
            for (int i = 1; i < temp.size(); i++) {
                str = str + " " + temp.get(i);
            }
            ans.add(str);
        }
        return ans;
    }

    private void dfs(String str, int i, Set<String> set, List<String> ds, List<List<String>> list) {
        if (i == str.length()) {
            list.add(new ArrayList<>(ds));
            return;            
        }
        for (int j = i; j < str.length(); j++) {
            String curr = str.substring(i, j+1);
            if (set.contains(curr)) {
                ds.add(curr);
                dfs(str, j+1, set, ds, list);
                ds.remove(ds.size()-1);
            }
        }
    }
}