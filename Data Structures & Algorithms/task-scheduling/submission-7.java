class Pair {
    int fr;
    int time;
    Pair(int fr, int time) {
        this.fr = fr;
        this.time = time;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] fr = new int[26];

        int maxF = 0;
        for (char ch : tasks) {
            fr[ch-'A']++;
            maxF = Math.max(maxF, fr[ch-'A']);
        }

        int count = 0;
        for (int i : fr) if (i == maxF) count++;

        int time = (maxF-1) * (n + 1) + count;
        return Math.max(time, tasks.length);
    }
}
