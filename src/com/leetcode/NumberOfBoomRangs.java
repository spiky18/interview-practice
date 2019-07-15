package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfBoomRangs {
	public int numberOfBoomerangs(int[][] points) {
		Set<Double> distSet=new HashSet<>();
		int cnt=0;
        for(int i=0;i<points.length;i++){
            for( int j=i+1;j<points.length;j++){
            	double dist=findDist(points[i], points[j]);
            	if(distSet.contains(dist))
            		cnt+=2;
            	else
            		distSet.add(dist);
            }
            distSet.clear();
        }
        return cnt;
    }
    
    public double findDist(int[] cord1,int[] cord2){
    	int dist=(cord2[0]-cord1[0])*(cord2[0]-cord1[0])+(cord2[1]-cord1[1])*(cord2[1]-cord1[1]);
        return Math.sqrt(dist);
    }
}
