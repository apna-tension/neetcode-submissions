class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        // Set<String> set = new HashSet<>();
        // List<List<String>> list = new ArrayList<>();

        for (String str : strs) {
            int[] fr = new int[26];
            for (char ch : str.toCharArray()) {
                fr[ch-'a']++;
            }
            String frS = Arrays.toString(fr);
            if (!map.containsKey(frS)) {
                map.put(frS, new ArrayList<>());
                // set.add(frS);
            }
            map.get(frS).add(str);
        }
        
        // for (String s : set) {
        //     List<String> ds = new ArrayList<>();
        //     for (String str : map.get(s)) {
        //         ds.add(str);
        //     }
        //     list.add(new ArrayList<>(ds));
        // }


        // for (Map.Entry<String,List<String>> mapElement : map.entrySet()) {
        //     // String key = mapElement.getKey();

        //     // Adding some bonus marks to all the students
        //     List<String> ds = new ArrayList<>();
        //     for (String str : mapElement.getValue()) {
        //         ds.add(str);
        //     }

        //     // Printing above marks corresponding to
        //     // students names
        //     list.add(new ArrayList<>(ds));
        // }
        // return list;
        // return new ArrayList<>(map);
        return new ArrayList<>(map.values());
        // return result;
    }
}
