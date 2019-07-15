package com.leetcode;

public class WildCardMatching {
	public boolean isMatch(String s, String p) {
        int i=0,j=0,star=-1,starptr=-1;
        while(i<s.length()){
        	if(j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'))
        	{
        		i++;
        		j++;
        	}
        	else if(j<p.length() && p.charAt(j)=='*'){
        		star=j;
        		starptr=i;
        		j++;
        		i++;
        	}
        	else if(star!=-1){
        		i=starptr+1;
        		j=star;
        	}
        	else
        		return false;
        }
        return true;
    }
	
	public boolean isMatch2(String s, String p) {
		boolean[][] m=new boolean[s.length()+1][p.length()+1];
		
		m[0][0]=true; //Empty string matches empty pattern 
		
		for(int j=1;j<=p.length();j++){
			if(p.charAt(j-1)=='*')
				m[0][j]=m[0][j-1];
		}
		
		for(int i=1;i<s.length();i++){
			for(int j=1;j<p.length();j++){
				if(s.charAt(i-1)==p.charAt(j-1)|| p.charAt(j-1)=='?')
					m[i][j]=m[i-1][j-1];
				else if(p.charAt(j-1)=='*'){
					m[i][j]=m[i][j-1]||m[i-1][j];//ignoring the character or *
				}
				
			}
		}
		
		
		
		return m[s.length()][p.length()];
	}
}
