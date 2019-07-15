package com.hr.cc;

import java.util.Scanner;

public class CheckSortRecusrion {
	
	public static void main(String[] args){
	Scanner in=new Scanner(System.in);
	int n=in.nextInt();
	int[] arr=new int[n];
	for(int i=0;i<n;i++){
		arr[i]=in.nextInt();
	}
	boolean checkSort=checkSorted(arr, n);
	System.out.println(checkSort);
	}
	public static boolean checkSorted(int[] a,int n){
		if(a[1]>a[0])
			return true;
		else if(a[n-1]>a[n-2])
			return checkSorted(a,n-1);
		
		else
			return false;
		
	}
	

}
