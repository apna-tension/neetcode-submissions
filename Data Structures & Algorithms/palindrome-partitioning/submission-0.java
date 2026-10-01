class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        partition(s, 0, list, new ArrayList<>());
        return list;
    }

    private void partition(String s, int i, List<List<String>> list, List<String> ds) {
        if (i >= s.length()) {
           
            list.add(new ArrayList<>(ds));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s.substring(i, j+1))) {
                ds.add(s.substring(i, j+1));
                partition(s, j+1, list, ds);
                ds.remove(ds.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str) {
       
        int i = 0;
        int j = str.length()-1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        
        return true;
    }
}
