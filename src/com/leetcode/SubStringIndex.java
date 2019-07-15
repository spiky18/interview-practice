package com.leetcode;

public class SubStringIndex {
	public int strStr(String s, String t) {
		char[] sArr=s.toCharArray();
		char[] tArr=t.toCharArray();
		int startIndex=-1,matchIndex=0,i=0;
		while(i<s.length()){
			if(sArr[i]==tArr[matchIndex]){
				if(startIndex==-1)
					startIndex=i;
				matchIndex++;
			}else{
				startIndex=-1;
				matchIndex=0;
				if(sArr[i]==tArr[matchIndex]){
					if(startIndex==-1)
						startIndex=i;
					matchIndex++;
				}
			}
			if(matchIndex==tArr.length)
				return startIndex;
			i++;
		}
        return -1;
    }
}
