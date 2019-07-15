package com.leetcode;

import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
		
        int curr=0;
        Stack<Integer> stack=new Stack<>();
        for(char ch : s.toCharArray()){
        	if(ch==' ')
        		continue;
        	else if(ch=='('){
        		stack.push(curr);
        	}
        	else if(ch=='+'){
        		
        	}
        	else if(ch=='-'){
        		
        	}
        	else if(ch==')'){
        		
        	}
        	else{
        		
        	}
        	
        }
        
        
        return curr;
    }
}
