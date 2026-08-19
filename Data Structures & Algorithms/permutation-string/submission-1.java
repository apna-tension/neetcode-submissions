class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] fr1 = new int[26];
        int[] fr2 = new int[26];

        for (char ch : s1.toCharArray()) fr1[ch-'a']++;

        int left = 0;
        for (int j = 0; j < s2.length(); j++) {
            fr2[s2.charAt(j)-'a']++;
            if (j-left+1 == s1.length()) {
                if (isPermute(fr1, fr2)) return true;
                fr2[s2.charAt(left)-'a']--;
                left++;
            }
        }
        return false;
    }

    private boolean isPermute(int[] fr1, int[] fr2) {
        for (int i = 0; i < 26; i++) {
            if (fr1[i] != fr2[i]) return false;
        }
        return true;
    }
}
