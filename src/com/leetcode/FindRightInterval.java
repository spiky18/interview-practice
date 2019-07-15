package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class FindRightInterval {
	public int[] findRightInterval(Interval[] intervals) {
		int[] res = new int[intervals.length];
		HashMap<Interval, Integer> map = new HashMap<>();
		for (int i = 0; i < intervals.length; i++) {
			map.put(intervals[i], i);
		}
		Comparator<Interval> comparator = new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		};
		Arrays.sort(intervals, comparator);
		for (int i = 0; i < intervals.length - 1; i++) {
			int j = i + 1;
			for (; j < intervals.length; j++) {
				if (intervals[i].end <= intervals[j].start) {
					res[map.get(intervals[i])] = map.get(intervals[j]);
					break;
				}
			}
			if (j == intervals.length)
				res[map.get(intervals[i])] = -1;
		}
		res[map.get(intervals[intervals.length - 1])] = -1;
		return res;
	}

	public int eraseOverlapIntervals(Interval[] intervals) {
		int cnt = 0;
		Comparator<Interval> comparator=new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start!=o2.start)
					return o1.start-o2.start;
				else
					return o1.end-o2.end;
			}
		};
		Arrays.sort(intervals, comparator);
		Interval prev=intervals[0];
		for(int i=1;i<intervals.length;i++){
			if(prev.end>intervals[i+1].end)
				cnt++;
			else
				prev=intervals[i];
		}
		return cnt;
	}
}
