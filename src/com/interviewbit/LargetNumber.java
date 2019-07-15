package com.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargetNumber {
	public String largestNumber(final List<Integer> a) {
		List<Integer> arr=new ArrayList<>(a);
		StringBuilder sb=new StringBuilder();
		
		Collections.sort(arr,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String xy=o1.intValue()+""+o2.intValue();
				String yx=o2.intValue()+""+o1.intValue();
				return xy.compareTo(yx)>0?-1:1;
			}
		});
		for(int i : arr){
			sb.append(i);
		}
		
		return sb.toString();
	}
	
	public List<Integer> numberToArr(int num){
		List<Integer> result=new ArrayList<>();
		if(num==0){
			result.add(0);
			return result;
			}
		while(num!=0){
			result.add(num%10);
			num=num/10;
		}
		Collections.reverse(result);
		return result;
	}
	
	
}
