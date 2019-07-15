package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderAlt {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordset=new HashSet<>();
		for(String s : wordList)
			wordset.add(s);
		Queue<String> queue=new LinkedList<>();
		queue.add(beginWord);
		queue.add(null);
		Set<String> visited=new HashSet<>();
		visited.add(beginWord);
		int cnt=1;
		while(!queue.isEmpty()){
			String s=queue.poll();
			if(s!=null){
			char[] strArray=s.toCharArray();
			for(int index=0;index<s.length();index++){
			char ch=strArray[index];
			for(int i=0;i<26;i++){
				char tmp=(char)(i+'a');
				if(tmp!=ch)
				{
					strArray[i]=tmp;
					String nextword=String.valueOf(strArray);
					if(wordset.contains(nextword))
						{
							queue.add(nextword);
							wordset.remove(nextword);
							if(nextword.equals(endWord))
								return cnt+1;
						}
				}
				strArray[index]=ch; 
			}
			}
			}
			else
			{
				if(!queue.isEmpty())
					queue.add(null);
				cnt++;
			}
		}
		return 0;
	}
}
