package com.leetcode;

import java.util.Collections;
import java.util.List;

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Collections.sort(intervals, (a,b)->a.start-b.start);
        
        int lo=0,hi=intervals.size()-1,i=-1;
        while(lo<=hi){
        	int mid=lo+(hi-lo)/2;
        	Interval temp = intervals.get(mid);
			if(temp.start==newInterval.start){
        		lo=mid;
        		break;
        	}else if(temp.start>newInterval.start){
        		hi=mid-1;
        	}else
        		lo=mid+1;
        	
        }
        Interval insertionPoint=intervals.get(lo);
        Interval nextPoint=null;
        if(lo<intervals.size()-1)
        	nextPoint=intervals.get(lo+1);
        
        if(insertionPoint.end>newInterval.start){
        	
        	
        }
		
		
		return intervals;
    }
	
	

}
