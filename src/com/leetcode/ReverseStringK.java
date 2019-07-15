package com.leetcode;

public class ReverseStringK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="abcdefgh";
		ReverseStringK rs=new ReverseStringK();
		System.out.println(rs.reverseStr(s, 4));

	}

	/**
	 * https://leetcode.com/problems/reverse-string-ii/#/description 
	 * Given a string and an integer k, you need to reverse the first k characters for
	 * every 2k characters counting from the start of the string. If there are
	 * less than k characters left, reverse all of them. If there are less than
	 * 2k but greater than or equal to k characters, then reverse the first k
	 * characters and left the other as original.
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public String reverseStr(String s, int k) {
		StringBuilder sb =new StringBuilder();
		if(k<=1)
			return s;
		if(k>=s.length()){
		    sb= new StringBuilder(s);
		    return sb.reverse().toString();}
		//StringBuilder sb =new StringBuilder();
		char[] charArray=s.toCharArray();
		int rmngStr=s.length();
		int start=0;
		//int kMul=0;
		while(rmngStr>0){
			charArray=revHelper(charArray, start*k, k);
			start+=2;
			rmngStr-=2*k;
		}
		return sb.append(charArray).toString();
	}
	
	public char[] revHelper(char[] charArray,int start,int k){
		int end=charArray.length>start+k ? start+k : charArray.length;
		k=(end-start)>k?k:(end-start);
		for(int i=0;i<k/2;i++){
			char temp=charArray[start+i];
			charArray[start+i]=charArray[end-1-i];
			charArray[end-1-i]=temp;
		}
		return charArray;
	}
	

}
