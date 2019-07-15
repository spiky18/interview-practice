package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
	public String reverseVowels(String s) {
        Set<Character> vowels=new HashSet<>();
        char[] arr={'A','E','I','O','U','a','e','i','o','u'};
        for(int i=0;i<arr.length;i++)
        	vowels.add(arr[i]);
        arr=s.toCharArray();
        int fwd=0,bwd=s.length()-1;
        while(fwd<bwd){
        	if(vowels.contains(arr[fwd]) && vowels.contains(arr[bwd]))
        	{
        		char tmp=arr[fwd];
        		arr[fwd]=arr[bwd];
        		arr[bwd]=tmp;
        		fwd++;
        		bwd--;
        	}
        	else if(!vowels.contains(arr[fwd]) && vowels.contains(arr[bwd])){
        		fwd++;
        	}
        	else if(vowels.contains(arr[fwd]) && !vowels.contains(arr[bwd])){
        		bwd--;
        	}
        	else
        	{
        		fwd++;
        		bwd--;
        	}
        }
        
        return String.valueOf(arr);
    }
}
