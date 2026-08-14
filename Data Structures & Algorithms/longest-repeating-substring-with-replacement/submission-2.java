class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, r = 0;
        int max = 0;
        boolean rChange = true;
        while (r < s.length()) {
            if (rChange) freq[s.charAt(r) - 'A']++;
            int maxFreq = 0;
            for (int i = 0; i < 26; i++) {
                maxFreq = Math.max(maxFreq, freq[i]);
            }

            if (r - l + 1 - maxFreq > k) {
                freq[s.charAt(l)-'A']--;
                l++;
                rChange = false;
            } else {
                max = Math.max(max, r - l + 1);
                r++;
                rChange = true;
            }
            // System.out.println(Arrays.toString(freq));
            // System.out.println(max);
        }
        return max;

    }
}
