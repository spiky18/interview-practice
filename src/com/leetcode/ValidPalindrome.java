package com.leetcode;

public class ValidPalindrome {
	public boolean validPalindrome(String s) {
        return isPalindrome(new StringBuilder(s), 0);
    }
	
	public boolean isPalindrome(StringBuilder s,int noOfDelChars){
		if(noOfDelChars>=2){
			return false;
		}
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!=s.charAt(s.length()-i-1)){
				return isPalindrome(s.deleteCharAt(i), noOfDelChars+1) || isPalindrome(s.deleteCharAt(s.length()-i-1), noOfDelChars+1);
			}
		}
		return true;
	}
}
