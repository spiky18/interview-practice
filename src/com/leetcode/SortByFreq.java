package com.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortByFreq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortByFreq sf=new SortByFreq();
		System.out.println(sf.frequencySort("Aabb"));
		//tempClass tc=new tempClass();
		

	}
	
	public String frequencySort(String s) {
		PriorityQueue<tempClass> heap=new PriorityQueue<>();
		HashMap<Character, tempClass> map=new HashMap<>();
		StringBuilder sb=new StringBuilder();
		for(char c : s.toCharArray()){
			tempClass tc=null;
			if(!map.containsKey(c)){
				tc=new tempClass();
				tc.count=1;
				tc.ch=c;
			}
			else{
				tc=map.get(c);
				tc.count+=1;
			}
			map.put(c, tc);
			}
		for(char c : map.keySet()){
			heap.add(map.get(c));
		}
		while(!heap.isEmpty()){
			tempClass t=heap.poll();
			while(t.count>0)
				{
					sb.append(t.ch);
					t.count-=1;
				}
			}
        return sb.toString();
    }
	public class tempClass implements Comparable<tempClass>{
		public int count;
		public char ch;
		@Override
		public int compareTo(tempClass o) {
			return o.count-this.count;
		}
	}
	
}
