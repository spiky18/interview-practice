package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC252 {
	 public boolean canAttendMeetings(Interval[] intervals) {
	        if(intervals.length<=1)
	            return true;
	        
	        Arrays.sort(intervals, (a,b)->a.start-b.start);
	        Interval prev=intervals[0];
	        for(int i=1;i<intervals.length;i++){
	        	if(prev.end>intervals[i].start){
	            	return false;
	            }
	            prev=intervals[i];
	        }
	        return true;
	    }
	 
	 public int minMeetingRooms(Interval[] intervals) {
		 if(intervals.length<=1)
			 return intervals.length;
		 int count=1;
		 Arrays.sort(intervals, (a,b)->a.start-b.start);
		 Interval prev=intervals[0];
		 List<Interval> list=new ArrayList<>();
		 list.add(prev);
		 for(int i=1;i<intervals.length;i++){
			 if(prev.end>intervals[i].start){
				 
			 }
			 
		 }
		 
		 return count;
	    }
	 
}
