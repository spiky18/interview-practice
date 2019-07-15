package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumOfDigits {
	public static List<Integer> list=new ArrayList<>();
	public static void main(String[] args) {
		
	}
	
	public void sumLevel(int n){
		if(n/10==0)
		{
			list.add(n);
			return;
		}
		list.add(n%10);
		//return list;
	}
	
	public int sum(int n){
		if(n/10==0)
			return n;
		return n%10+sum(n/10);
	}
}
