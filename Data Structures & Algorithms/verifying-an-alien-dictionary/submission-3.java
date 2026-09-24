class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) map.put(order.charAt(i), i);
        for (int i = 0; i < words.length-1; i++) {
            if (!big(words[i], words[i+1], map)) return false;
        }
        return true;
    }

    private boolean big(String a, String b, Map<Character, Integer> map) {
        
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            int n1 = map.get(a.charAt(i));
            int n2 = map.get(b.charAt(j));
            if (n1 > n2) return false;
            
            if (n1 < n2) return true;
            i++;
            j++;
        }

        if (i != a.length()) return false;
        return true;
    }
}