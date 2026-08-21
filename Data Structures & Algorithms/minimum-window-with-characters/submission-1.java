class Solution {
    public String minWindow(String s, String t) {
        int fr1[] = new int[58];
        int fr2[] = new int[58];

        int need = 0;
        for (int tc : t.toCharArray()) {
            fr2[tc-'A']++;
            if (fr2[tc-'A'] == 1) need++;
        }

        int startIdx = -1;
        int len = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            fr1[s.charAt(right)-'A']++;
            if (fr1[s.charAt(right)-'A'] == fr2[s.charAt(right)-'A']) need--;

            while (need == 0 && left <= right) {
                if (len > right-left+1) {
                    len = right-left+1;
                    startIdx = left;
                }
                fr1[s.charAt(left)-'A']--;
                if (fr1[s.charAt(left)-'A'] < fr2[s.charAt(left)-'A']) need++;
                left++;
            }
        }

        if (startIdx == -1) return "";
        return s.substring(startIdx, startIdx+len);

    }
    // private boolean isValid(int[] a, int[] b, char ch) {
        
    // }
}
