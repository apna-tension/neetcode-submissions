class Solution {
    public int countSubstrings(String s) {
        int count = s.length();
        for (int i = 0; i < s.length(); i++) {

            // for odd length palindrome
            int l = i-1; 
            int r = i+1;

            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    count++;
                } else break;
            }

            // for even length palindrome
            l = i;
            r = i+1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    count++;
                } else break;
            }

        }
        return count;
    }
}
