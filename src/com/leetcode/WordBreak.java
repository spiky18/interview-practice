package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	 public  boolean wordBreak(String s, List<String> wordDict) {
		 Set<String> set=new HashSet<>(wordDict);
		 return isPresent(s, set);
	 }
	 
	 public  boolean isPresent(String s,Set<String> set){
		 if(s.length()==0 || set.contains(s))
			 return true;
		 
		 for(int i=1;i<=s.length();i++){
			 if(set.contains(s.substring(0, i))&& s.length()-i>=0&&isPresent(s.substring(i,s.length()-i), set))
				 return true;
		 }
		 return false;
	 }
	 
	 public static void main(String[] args) {
		List<String> list=Arrays.asList("dog","s","gs");
		WordBreak obj=new WordBreak();
		
		System.out.println(obj.wordBreak("dogs", list));
		
	}
}
