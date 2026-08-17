class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
    
        Set<Integer> startSeq = new HashSet<>();
        for (int n : set) if (!set.contains(n-1)) startSeq.add(n);
        System.out.println(startSeq);
        int max = 0;

        for (int n : startSeq) {
            int currSeq = 1;
            while (set.contains(n+1)) {
                currSeq++;
                n++;
            }
            max = Math.max(max, currSeq);
        }

        return max;
    }
}
