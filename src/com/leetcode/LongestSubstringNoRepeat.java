package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Problem : https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringNoRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcd";
		s=s.substring(0, 2);
		System.out.println("s"+s);
		LongestSubstringNoRepeat obj=new LongestSubstringNoRepeat();
		System.out.println(obj.lengthOfLongestSubstring(s));
		System.out.println(-1/2);
		System.out.println(obj.reverseBits(43261596));

	}

	public int reverseBits(int n) {
        String bstring=Integer.toBinaryString(n);
        
        System.out.println(bstring);
        StringBuilder sbuilder=new StringBuilder(bstring);
        bstring.substring(0, 0); 
        //sbuilder=sbuilder.reverse();
        long decimal=Long.parseLong(sbuilder.reverse().toString(),2);
        return (int) decimal;
        
    }
	
	
	/*
	 * O(n^2) soln
	 public int lengthOfLongestSubstring(String s) {
        int maxlength=0;
        
        for(int i=0;i<s.length();i++){
            int l=1;
            StringBuilder newS=new StringBuilder();
            newS.append(s.charAt(i));
            for(int j=i+1;j<s.length();j++){
                if(!newS.toString().contains(String.valueOf(s.charAt(j))))
                {
                	newS.append(s.charAt(j));
                	l++;
                }
                else
                    break;
            }
            if(l>maxlength)
                maxlength=l;
        }
        
        
     return maxlength;   
    }*/
	
	public int lengthOfLongestSubstring(String s) {
		int maxlength=0;
		HashSet<Character> uniqueChars=new HashSet<>();
		int windowStart=0,windowEnd=-1;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(uniqueChars.contains(ch)){
				int j=windowStart;
				while(uniqueChars.contains(ch))
				{
					uniqueChars.remove(s.charAt(windowStart));
					windowStart++;
				}
				uniqueChars.add(ch);
			}
			else
			{
				uniqueChars.add(ch);
				windowEnd++;
			}
			if(uniqueChars.size()>maxlength)
				maxlength=uniqueChars.size();
			
		}
	/*	for(int i=0;i<s.length();i++){
			List<Integer> list=null;
			if(map.containsKey(s.charAt(i))){
				list=map.get(s.charAt(i));
			}
			else{
				list=new ArrayList<>();
			}
			list.add(i);
			map.put(s.charAt(i), list);
		}
		
		for(int i=0;i<s.length();i++){
			List<Integer> list=map.get(s.charAt(i));
			int localength=0;
			if(list.size()>1)
				localength=list.get(1)-list.get(0);
			else
				localength=s.length()-list.get(0)-1;
			if(localength>maxlength)
				maxlength=localength;
			list.remove(0);
		}*/
		return maxlength;
	}
}
