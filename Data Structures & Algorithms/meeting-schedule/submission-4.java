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
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = 0; j < intervals.size(); j++) {
                if (i == j) continue;
                Interval it = intervals.get(i);
                Interval jt = intervals.get(j);
                if ((jt.start >= it.start && jt.start < it.end) || (it.start >= jt.start && it.start < jt.end)) return false;
            }
        }
        return true;
    }
}
