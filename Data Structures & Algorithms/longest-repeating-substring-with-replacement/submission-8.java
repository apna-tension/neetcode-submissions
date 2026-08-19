class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int[] freq = new int[26];
        int i = 0, j = 0;
        while (j < s.length()) {
            freq[s.charAt(j)-'A']++;
            while (j - i + 1 - maxFr(freq) > k) {
                freq[s.charAt(i)-'A']--;
                i++;
            }
            j++;
            max = Math.max(max, j-i);
        }
        return max;
    }

    private int maxFr(int[] fr) {
        int max = 0;
        for (int ele : fr) max = Math.max(max, ele);
        return max;
    }
}
