package com.leetcode;

import java.util.HashSet;
import java.util.Stack;

public class PostFixExpression {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stk=new Stack<>();
        HashSet<String> symbols=new HashSet<>();
        symbols.add("+");
        symbols.add("-");
        symbols.add("*");
        symbols.add("/");
        for(String token : tokens){
            if(symbols.contains(token)){
            	calc(token,stk);
            }
            else{
            	stk.push(Integer.parseInt(token));
            }
            
        }
        return stk.peek();
    }
	
	private void calc(String symbol,Stack<Integer> stk){
		int a=stk.pop();
		int b=stk.pop();
		switch(symbol){
		case "+" : a+=b;
			break;
		case "-" : a=b-a;
		break;
		case "*" : a=b*a;
		break;
		case "/" : a=b/a;
		}
		stk.push(a);
	}
	
	
}
