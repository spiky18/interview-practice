package com.leetcode;

import java.util.Stack;

public class LC394 {

	public String decodeString(String s) {
		Stack<Integer> stkNum = new Stack<>();
		Stack<StringBuilder> stkSB = new Stack<>();
		StringBuilder currStr = new StringBuilder();
		boolean isNum=false;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				if(!isNum && currStr.toString().length()>0){
					stkSB.push(currStr);
					currStr=new StringBuilder();
				}
                isNum=true;
				currStr.append(ch);
				
			}else if(ch=='['){
                //System.out.println(currStr.toString());
				stkNum.push(Integer.parseInt(currStr.toString()));
				isNum=false;
				currStr=new StringBuilder();
			}else if(ch==']'){
				int repeat=stkNum.pop();
				StringBuilder sb=new StringBuilder(currStr);
				for(int j=1;j<repeat;j++){
					currStr.append(sb);
				}
				if(!stkSB.isEmpty()){
					currStr=stkSB.pop().append(currStr);
				}else{
					res.append(currStr);
					currStr=new StringBuilder();
				}
			}else{
				currStr.append(ch);
                isNum=false;
            }
		}

		return res.append(currStr).toString();
	}

	
	public static void main(String[] args) {
		LC394 obj=new LC394();
		
	}
}
