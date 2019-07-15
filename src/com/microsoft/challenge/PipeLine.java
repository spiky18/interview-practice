package com.microsoft.challenge;

import java.util.Scanner;

public class PipeLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int n = sc.nextInt();
		int[] time = new int[s];
		int tmax = -1;
		//int cycleTime=0;
		for (int i = 0; i < s; i++) {
			time[i] = sc.nextInt();
			tmax = Math.max(tmax, time[i]);
			//cycleTime+=time[i];
		}
		//System.out.println(tmax);
		int combine=time[0];
		for(int i=1;i<time.length;i++){
			if(combine+time[i]<=tmax){
				combine+=time[i];
				s--;
			}
			else
				combine=time[i];
		}
		System.out.println(s);
	}
	
	int pipelineTime(int cycleTime,int n,int tmax){
		return cycleTime+((n-1)*tmax);
	}
}
