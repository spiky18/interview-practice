package com.bloomberg.fall16;

import java.util.Scanner;

public class BirthdayCake {
	
	public int maximumEatableCake(int[] cakes){
		int curr=cakes[0];
		int max=cakes[0];
		for(int i=1;i<cakes.length;i++){
			if(cakes[i]>=cakes[i-1])
			{
				curr+=cakes[i];
			}
			else
				curr=cakes[i];
			max=Math.max(curr, max);
				
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] cakes=new int[n];
		for(int i=0;i<n;i++)
			cakes[i]=in.nextInt();
		BirthdayCake obj=new BirthdayCake();
		System.out.println(obj.maximumEatableCake(cakes));
	}

}
