package com.leetcode;

public class LC402 {
	
	public String removeKdigit(String num, int k) {
        StringBuilder sb=new StringBuilder(num);
        int i=0;
        while(k>0){
            if(i+1<sb.length() && sb.charAt(i)<sb.charAt(i+1)){
            	sb.deleteCharAt(i+1);
            	k--;
            }
            i++;
        }
        while(sb.length()>0 && sb.charAt(0)=='0')
        	sb.deleteCharAt(0);
        return sb.length()==0?"0":sb.toString();
    }
	
	public String removeKdigits(String num, int k) {
        StringBuilder sb=new StringBuilder(num);
        char[] stk=new char[num.length()];
        int newlen=num.length()-k;
        int top=0;
        for(int i=0;i<num.length();i++){
        	char ch=num.charAt(i);
        	while(top>0 && stk[top-1]>ch && k>0){
                //stk[top]=
        		top--;
        		k--;
        	}
        	stk[top]=ch;
        	top++;
        }
        int index=0;
        while(index<newlen && stk[index]=='0')index++;
        return newlen==index?"0":String.valueOf(stk, index, newlen-index);
    }

}
