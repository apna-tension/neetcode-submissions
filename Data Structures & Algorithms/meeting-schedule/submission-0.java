/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int[] line = new int[1000002];
        int max = 0;
        for (Interval it : intervals) {
            max = Math.max(max, it.end);
            line[it.start]++;
            line[it.end]--;
        }
        for (int i = 1; i <= max; i++) {
            line[i] += line[i-1];
            if (line[i] > 1) return false;
        }
        return true;
    }
}
