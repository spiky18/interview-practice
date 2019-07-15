package com.leetcode;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		String[] arr=path.split("/");
		Stack<String> stk=new Stack<String>();
		for(String s: arr){
			if(!s.isEmpty())
			{
				if(s.equals(".."))
					stk.pop();
				else if(!s.equals(".")){
					stk.push(s);
				}
			}
			}
		 StringBuilder sb=new StringBuilder();
		 while(!stk.isEmpty()){
			 sb.append(new StringBuilder(stk.pop()).reverse());
			 if(!stk.isEmpty())
				 sb.append("/");
			 }
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		SimplifyPath sp=new SimplifyPath();
		sp.simplifyPath("");
	}
}
