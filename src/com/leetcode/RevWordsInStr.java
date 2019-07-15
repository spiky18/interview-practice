package com.leetcode;

import java.util.ArrayList;

public class RevWordsInStr {
	public static void main(String[] args) {
		String s="Let's take LeetCode contest";
		RevWordsInStr rw=new RevWordsInStr();
		System.out.println(rw.reverseWords(s));
	}

	public String reverseWords(String s) {
		// StringBuilder sb =new StringBuilder();
		char[] charArr = s.toCharArray();
		int i = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (i < s.lastIndexOf(' ')) {
			i = s.indexOf(' ', i);
			list.add(i);
			i++;
		}
		// int[]
		int last = s.length() - 1;
		int count=list.size()-1;
		while (i>=0) {
			int k = 0;
			for (int j = i; j <= (last + i) / 2; j++) {
				char ch = charArr[j];
				charArr[j] = charArr[last - k];
				charArr[last - k] = ch;
				k++;
			}
			//list.remove(list.size() - 1);
			last = i - 2;
			if(count==0){
				if(i>0)
					i = 0;
				else
					i=-1;
			}
			else{
					count--;
					i = list.get(count)+1;
				}
		}
		return String.valueOf(charArr);

	}

}
