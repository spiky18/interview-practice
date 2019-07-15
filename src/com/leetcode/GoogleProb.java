package com.leetcode;

import java.util.Scanner;

public class GoogleProb {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int totMem = in.nextInt();
		int[] timeArr = new int[n];
		int[] memArr = new int[n];
		for (int i = 0; i < n; i++) {
			timeArr[i] = in.nextInt();
			memArr[i] = in.nextInt();
		}
		int t = 0;
		for (int i = 0; i < n; i++) {
			int memAvl = totMem - memArr[i];
			int j = i + 1;
			int tmin = timeArr[i];
			int tindex = i;
			while (j<n && memAvl >= memArr[j]) {
				memAvl = totMem - memArr[j];
				if (tmin > timeArr[j]) {
					tmin = timeArr[j];
					tindex = j;
				}
				
				if (j<n && memAvl < memArr[j]) {
					t += tmin;
					memAvl+=memArr[tindex];

				}
				j++;
				
			}
			if(tindex!=i)
			t += timeArr[i];
			
		}
		System.out.println(t);
	}

}
