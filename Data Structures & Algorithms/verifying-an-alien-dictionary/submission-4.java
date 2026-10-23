class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (!order(words[i-1], words[i], map)) {
                return false;
            }
        }

        return true;
    }   

    private boolean order(String str1, String str2, Map<Character, Integer> map) {
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            while (i < str1.length() && j < str2.length() && str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            }

            if (i < str1.length() && j < str2.length()) {
                return  map.get(str1.charAt(i)) < map.get(str2.charAt(j));
            }
        }

        return j == str1.length();
    }
}