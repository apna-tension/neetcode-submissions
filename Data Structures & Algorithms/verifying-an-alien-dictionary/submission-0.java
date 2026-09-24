class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), i);
        }
        System.out.println(map);
        for (int i = 0; i < words.length-1; i++) {
            String a = words[i];
            for (int j = i+1; j < words.length; j++) {
                if (!big(a, words[j], map)) return false;
            }
        }
        return true;
    }

    private boolean big(String a, String b, Map<Character, Integer> map) {
        
        int i = 0;
        int j = 0;
        // System.out.println(a + " : " + b);
        while (i < a.length() && j < b.length()) {
            if (map.get(a.charAt(i)) > map.get(b.charAt(j))) return false;
            
            if (map.get(a.charAt(i)) < map.get(b.charAt(j))) return true;
            // System.out.println(a.charAt(i) + " : " + b.charAt(j));
            i++;
            j++;
        }

        if (i != a.length()) return false;
        return true;
    }
}