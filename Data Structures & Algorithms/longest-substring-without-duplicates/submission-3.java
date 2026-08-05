class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxWin = 0;
        while (j < s.length()) {
            char chJ = s.charAt(j);
            if (map.containsKey(chJ)) {
                i = Math.max(i, map.get(chJ) + 1);
            }
            map.put(chJ, j);
            maxWin = Math.max(maxWin, j-i+1);
            j++;
        }
        return maxWin;
    }
}
