package com.google.techdevguide;

public class LongestWordInDictionary {

	/**
	 * Former Coding Interview Question: Find longest word in dictionary that is
	 * a subsequence of a given string
	 * https://techdevguide.withgoogle.com/paths/foundational/find-longest-word-in-dictionary-that-subsequence-of-given-string/
	 */

	public String findLongestWord(String s, String[] dict) {
		int maxlen=0;
		StringBuilder sb=new StringBuilder();
		for(String w : dict){
			if (w.length()<maxlen)
				continue;
			if(matchStrings(s, w)){
				maxlen=w.length();
				sb=new StringBuilder(w);
			}
		}
		
		return sb.toString();
	}
	
	public boolean matchStrings(String s,String t){
		int i=0,j=0;
		while(i<s.length() && j<t.length()){
			if(s.charAt(i)==t.charAt(j))
				j++;
			i++;
		}
		return j==t.length();
	} 
	
	public static void main(String[] args) {
		LongestWordInDictionary obj=new LongestWordInDictionary();
		String[] dict= {"able", "ale", "apple", "bale", "kangaroo"};
		System.out.println(obj.findLongestWord("abppplee", dict));
	}
}
