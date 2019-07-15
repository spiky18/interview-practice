package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinations {
	public List<String> letterCombinations(String digits) {
		List<String> list=new LinkedList<>();
		if(digits.contains("0")|| digits.contains("1") || digits.isEmpty())
			return list;
        String s="abcdefghijklmnopqrstuvwxyz";
        int i=0,k=2;
        HashMap<Integer,char[]> map=new HashMap<>();
        while(i<26){
        	int size=3,cnt=0;
        	if(k==7 || k==9)
        		size=4;
        	char[] arr=new char[size];
        	while(cnt<size){
        		arr[cnt]=s.charAt(i);
        		cnt++;
        		i++;
        	}
        	map.put(k, arr);
        	k++;
        }
        Queue<StringBuilder> sblist=new LinkedList<>();
        char[] arr= map.get((int)(digits.charAt(0)-'0'));
        for(char ch : arr){
        	StringBuilder sb =new StringBuilder();
        	sb.append(ch);
        	sblist.add(sb);
        }
        k=1;
        int qSize=sblist.size();
        while(k<digits.length()){
        	while(qSize>0){
        	StringBuilder sb=sblist.poll();
        	int a=(int)(digits.charAt(k)-'0');
        	for(char ch :  map.get(a)){
        	    StringBuilder tmp=new StringBuilder(sb);
        	    tmp.append(ch);
            	sblist.add(tmp);
            }
            qSize--;
        	}
        	qSize=sblist.size();
        	k++;
        }
        while(!sblist.isEmpty()){
            StringBuilder tmp=sblist.poll();
        	list.add(tmp.toString());
        }
        return list;
    }
}
