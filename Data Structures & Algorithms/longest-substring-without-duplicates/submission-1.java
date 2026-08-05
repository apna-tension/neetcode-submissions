class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxWin = 0;
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.getOrDefault(s.charAt(j), 0) > 1) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            maxWin = Math.max(maxWin, j-i+1);
            j++;
        }
        return maxWin;
    }
}
