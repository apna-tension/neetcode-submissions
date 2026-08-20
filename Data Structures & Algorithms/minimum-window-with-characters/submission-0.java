class Solution {
    public String minWindow(String s, String t) {
        int fr1[] = new int[58];
        int fr2[] = new int[58];

        for (int tc : t.toCharArray()) {
            fr2[tc-'A']++;
        }

        int startIdx = -1;
        int len = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            fr1[s.charAt(right)-'A']++;
            // System.out.println(Arrays.toString(fr1));
            // System.out.println(Arrays.toString(fr2));
            while (isValid(fr1, fr2)) {
                if (len > right-left+1) {
                    len = right-left+1;
                    startIdx = left;
                }
                fr1[s.charAt(left)-'A']--;
                left++;
            }
        }
        // System.out.println(len + " : " + startIdx);
        if (startIdx == -1) return "";
        return s.substring(startIdx, startIdx+len);

    }
    private boolean isValid(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (b[i] != 0 && a[i] < b[i]) return false;
        }
        return true;
    }
}
