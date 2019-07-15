package com.bloomberg.fall16;

import java.util.Arrays;
import java.util.Scanner;

public class SportsBar {

	public static void main(String[] args) {
		//System.out.println(Integer.parseInt("5.0"));
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		Interval[] intervals=new Interval[n];
		for(int i=0;i<n;i++){
			String s=in.nextLine();
			String[] arr=s.split("\\|");
			//System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
			intervals[i]=new Interval(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
		}
		SportsBar obj=new SportsBar();
		System.out.println(obj.numberOfTVs(intervals));

	}
	static class Interval implements Comparable<Interval>{
		int starttime,endtime;
		public Interval(int starttime,int endtime) {
			this.starttime=starttime;
			this.endtime=endtime;
		}
		@Override
		public int compareTo(Interval o) {
			// TODO Auto-generated method stub
			return  this.starttime-o.starttime;
		}
	}
	
	public int numberOfTVs(Interval[] intervals){
		Arrays.sort(intervals);
		int count=1;
		Interval prev=intervals[0];
		for(int i=1;i<intervals.length;i++){
			System.out.println(prev.starttime+" "+prev.endtime);
			if(prev.endtime>intervals[i].starttime)
				count++;
			prev=intervals[i];
		}
		return count;
	}
}
