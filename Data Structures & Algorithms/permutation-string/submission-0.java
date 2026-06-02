class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] fr1 = new int[26];
        int[] fr2 = new int[26];

        for (char ch : s1.toCharArray()) {
            fr1[ch-'a']++;
        }

        int i = 0, j = 0;
        while (i < s2.length()) {
            if (i + 1 - j > s1.length()) {
                fr2[s2.charAt(j)-'a']--;
                j++;
            }
            fr2[s2.charAt(i)-'a']++;
            if (is(fr1, fr2)) return true;
            i++;
        }

        
        return false;
    }

    private boolean is(int[] fr1, int[] fr2) {
        for (int i = 0; i < 26; i++) {
            if (fr1[i] != 0 && fr2[i] < fr1[i]) return false;
        }
        return true;
    }
}
