package com.leetcode;

import java.util.Stack;

public class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<Integer>();
        minStack=new Stack<Integer>();
    }
    
    public void push(int x) {
    	stack.push(x);
    	if(minStack.isEmpty()|| minStack.peek()>=x){
    		minStack.push(x);
    	}
        
    }
    
    public void pop() {
    	if(!stack.isEmpty()){
        if(stack.pop().intValue()==minStack.peek().intValue())
        	minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
    public static void main(String[] args) {
		MinStack obj=new MinStack();
		obj.push(512);
		obj.push(-1024);
		obj.push(-1024);
		obj.push(512);
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
	}
}
