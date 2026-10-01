class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                dp[i][i + l - 1] = isPalindrome(s, i, i+l-1);
            }
        }
        partition(s, 0, list, new ArrayList<>(), dp);
        return list;
    }

    private void partition(String s, int i, List<List<String>> list, List<String> ds, boolean[][] dp) {
        if (i >= s.length()) {
           
            list.add(new ArrayList<>(ds));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            
            if (dp[i][j]) {
                ds.add(s.substring(i, j+1));
                partition(s, j+1, list, ds, dp);
                ds.remove(ds.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str, int i, int j) {
       
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        
        return true;
    }
}
