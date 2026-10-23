class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }
        Set<Integer> left = new HashSet<>();

        for (int i = 0; i < trust.length; i++) {
            map.get(trust[i][1]).add(trust[i][0]);
            left.add(trust[i][0]);
        }

        for (int i = 0; i < trust.length; i++) {
            if (map.get(trust[i][1]).size() == n-1 && !left.contains(trust[i][1])) return trust[i][1];
        }
        return -1;        
    }
}