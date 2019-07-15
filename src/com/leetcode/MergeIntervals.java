package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
public List<Interval> merge(List<Interval> intervals) {
		List<Interval> mergedIntervals=new ArrayList<Interval>();
		if(intervals.isEmpty())
			return mergedIntervals;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1,Interval i2){
				return Integer.compare(i1.start, i2.start);
			}
		});

		mergedIntervals.add(intervals.get(0));
		int j=0;
		//Iterator<Interval> itr=intervals.iterator();
		for(int i=1;i<intervals.size();i++){
			Interval temp=mergedIntervals.get(j);
			Interval temp2=intervals.get(i);
			if(temp.start==temp2.start)
			{
				temp.end=Math.max(temp.end,temp2.end);
			}
			else if(temp.end>=	temp2.start)
				temp.end=Math.max(temp.end,temp2.end);
			else
			{
				mergedIntervals.add(temp2);
				j++;
			}
		}
        return mergedIntervals;
    }
}
