/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> comparator = new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                if (i1.start == i2.start)
                    return 0;
                else if (i1.start > i2.start)
                    return 1;
                return -1;
            }
        };
        Collections.sort(intervals, comparator);
        LinkedList<Interval> res = new LinkedList<>();
        Interval prev = null;
        for (Interval i : intervals){
            if (prev == null || i.start > prev.end){
                res.add(i);
                prev = i;
            }
            else if (i.end > prev.end)
                prev.end = i.end;
        }

        return res;
    }
}