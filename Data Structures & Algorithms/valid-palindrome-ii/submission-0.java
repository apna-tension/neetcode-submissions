class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) break;
            i++;
            j--;
        }

        if (i >= j) return true;

        int i2 = i+1;
        int j2 = j;
        while (i2 < j2) {
            if (s.charAt(i2) != s.charAt(j2)) break;
            i2++;
            j2--;
        }

        if (i2 >= j2) return true;

        i2 = i;
        j2 = j-1;
        while (i2 < j2) {
            if (s.charAt(i2) != s.charAt(j2)) break;
            i2++;
            j2--;
        }

        return i2 >= j2;
    }
}