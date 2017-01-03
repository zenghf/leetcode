/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

import java.util.LinkedList;

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
        int start = 0;
        int end = Integer.MIN_VALUE;
        for (Interval i : intervals){
            if (i.start <= end){
                end = Math.max(end, i.end);
            }
            else{
                if (end >= start)
                    res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        if (end >= start)
            res.add(new Interval(start, end));
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        Interval interval = new Interval(1, 3);
        LinkedList<Interval> list = new LinkedList<>();
        list.add(interval);

    }
}