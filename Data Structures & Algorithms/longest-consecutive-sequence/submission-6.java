class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
    
        // Set<Integer> startSeq = new HashSet<>();
        int max = 0;

        for (int n : set) {
            if (!set.contains(n-1)) {
                int currSeq = 1;
                while (set.contains(n+1)) {
                    currSeq++;
                    n++;
                }
                max = Math.max(max, currSeq);
            }
        }
        return max;
    }
}
