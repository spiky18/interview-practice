package com.leetcode;

public class Division {
	public int naivedivide(int dividend, int divisor) {
		int count=1;
		int neg=1;
		if(dividend>0 && divisor<0 || dividend<0 && divisor>0 )
			neg=-1;
		long dvd=Math.abs(dividend);
		long dvs=Math.abs(divisor);
		if(dvd<dvs)
			return 0;
		while(dvs<=dvd){
			dvd-=dvs;
			dvs+=dvs;
			count+=count;
		}
		return count;
		
	}
	public int divide(int dividend, int divisor) {
		if(divisor==0)
			return Integer.MAX_VALUE;

		int sign=1;
		if((dividend>0 && divisor<0) || (dividend<0 && divisor>0))
			sign=-1;
		long ldividend=Math.abs(dividend);
		long ldivisor=Math.abs(divisor);
		if(ldivisor>ldividend)
			return 0;
		long multiple=ldivide(ldividend, ldivisor);
		if(sign==-1 && multiple>Integer.MAX_VALUE)
			return Integer.MIN_VALUE;
		if(sign!=-1 && multiple>Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return (int)(multiple*sign);
	}
	
	public long ldivide(long ldividend,long ldivisor){
		long multiple=1;
		long sum=ldivisor;
		while((sum+sum)<ldividend)
		{
			sum+=sum;
			multiple+=multiple;
		}
		
		return multiple+ldivide(ldividend-sum,ldivisor);
	}
}
