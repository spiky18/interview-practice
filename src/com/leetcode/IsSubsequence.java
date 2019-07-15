package com.leetcode;

public class IsSubsequence {

	public static void main(String[] args) {
		String s="aec";
		String t="abcde";
		IsSubsequence is= new IsSubsequence();
		System.out.println(is.isSubsequence(s, t));

	}

public boolean isSubsequence(String s, String t) {
	if(s.length()==0)
		return true;
	if(s.length()>t.length() )
		return false;
	int i=0;
	for(char ch :  t.toCharArray()){
		if(ch==s.charAt(i))
			i++;
		if(i==s.length())
			break;
	}
	if(i==s.length())
		return true;
	
	return false;
        
    }
}
