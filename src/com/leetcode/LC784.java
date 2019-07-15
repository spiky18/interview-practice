package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC784 {

	public List<String> letterCasePermutation(String S) {
		List<String> list = new ArrayList<>();
		helper(list, 0, S.toCharArray());
		return list;
	}

	public void helper(List<String> list, int curr, char[] sAr) {
		if (curr == sAr.length) {
			list.add(String.valueOf(sAr));
			return;
		}
		char ch = sAr[curr];
		if (Character.isLetter(sAr[curr])) {
			sAr[curr] = Character.isUpperCase(sAr[curr]) ? Character.toLowerCase(sAr[curr])
					: Character.toUpperCase(sAr[curr]);
			
			for(int i=curr+1;i<sAr.length;i++)
				helper(list, i, sAr);
		}
		sAr[curr]=ch;
	}
	
	
	 public List<List<String>> groupAnagramsPrime(String[] strs) {
		 List<List<String>> list = new ArrayList<>();
		 HashMap<Long,List<String>> map=new HashMap<>();
		 for(String s : strs){
			 long hash=calcHash(s);
			 List<String> l=map.getOrDefault(hash, new ArrayList<>());
			 l.add(s);
			 map.put(hash, l);
		 }
		 
		 for(long l : map.keySet()){
			 list.add(map.get(l));
		 }
		 
		 
		 return list;
	    }
	 
	 public long calcHash(String s ){
		 int[] arr={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73, 79, 83, 89, 97, 101};
		 long hash=1;
		 for(char ch: s.toCharArray()){
			 hash*=arr[ch-'a'];
		 }
		 
		 
		 return hash;
	 }
	 
	 public List<List<String>> groupAnagrams(String[] strs) {
		 List<List<String>> list = new ArrayList<>();
		 HashMap<String,List<String>> map=new HashMap<>();
		 
		 for(String s : strs){
			 char[] arr=s.toCharArray();
			 
			 Arrays.sort(arr);
			 String k=String.valueOf(arr);
			 List<String> l=map.getOrDefault(k, new ArrayList<>());
			 l.add(s);
			 map.put(k, l);
		 }
		 
		 list.addAll(map.values());
		 
		 return list;
	 }
}
