class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, r = 0;
        int max = 0;
        boolean rChange = true;
        while (r < s.length()) {
            freq[s.charAt(r) - 'A']++;

            while (r - l + 1 - maxFreq(freq) > k) {
                freq[s.charAt(l)-'A']--;
                l++;
            } 

            r++;
            max = Math.max(max, r - l);
        }
        return max;

    }

    private int maxFreq(int[] arr) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
