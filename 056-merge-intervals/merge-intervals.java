// Given a collection of intervals, merge all overlapping intervals.
//
//
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].


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
		List<Interval>list = new ArrayList<>();
        Collections.sort(intervals,new Comparator<Interval>() {
			@Override
			public int compare(Interval arg0, Interval arg1) {
				if(arg0.start<arg1.start)return -1;
				if(arg0.start==arg1.start&&arg0.end<arg1.end){
					return -1;
				}
				if(arg0.start==arg1.start&&arg0.end==arg1.end)return 0;
				return 1;
			}
		});
        int begin = 0,end = 0;
        for(int i=0;i<intervals.size();i++){
        	begin = intervals.get(i).start;
        	end = intervals.get(i).end;
        	while(i<intervals.size()-1){
        		if(end<intervals.get(i+1).start){
        			break;
        		}
        		else if(end<=intervals.get(i+1).end){
        			end = intervals.get(i+1).end;
        			i = i+1;
        		}else{
        			i++;
        		}
        	}
        	Interval in = new Interval(begin, end);
			list.add(in);
        }
		return list;
    }
}
