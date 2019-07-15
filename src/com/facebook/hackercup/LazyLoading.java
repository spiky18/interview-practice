package com.facebook.hackercup;

import java.util.Arrays;
import java.util.Scanner;

public class LazyLoading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		int cases=in.nextInt();
		//String[] results=new String[cases];
		int j=1;
		LazyLoading l=new LazyLoading();
		while(cases>0){
			int n=in.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++){
				a[i]=in.nextInt();
			}
			System.out.println("Case #"+(j)+": "+l.lazyLoading(a));
			cases--;
			j++;
		}
		
		/*int[] a= {9,19,29,39,49,59};
		System.out.println(l.lazyLoading(a));*/

	}
	public int lazyLoading(int a[]){
		Arrays.sort(a);
		int trips=0;
		int total_items=a.length-1;
		int itm_rmng=a.length;
		int max=a[total_items];
		while(itm_rmng>0){
			int itm_crd=0;
			if(itm_rmng*max>=50)
				trips++;
			else 
				break;
			if(50%max!=0)
				itm_crd=1+50/max;
			else
				itm_crd=50/max;
			itm_rmng-=itm_crd;
			total_items-=1;
			if(total_items>=0)
				max=a[total_items];
		}
		return trips;
	}
}
