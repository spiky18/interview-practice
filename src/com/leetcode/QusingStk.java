package com.leetcode;

import java.util.Stack;

public class QusingStk {
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public QusingStk() {
		// TODO Auto-generated constructor stub
		s1=new Stack<Integer>();
		s2=new Stack<Integer>();
	}
    // Push element x to the back of queue.
    public void push(int x) {
    	s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	while(s1.isEmpty())
    		s2.push(s1.pop());
        s2.pop();
        while(s2.isEmpty())
    		s1.push(s2.pop());
    }

    // Get the front element.
    public int peek() {
    	while(s1.isEmpty())
    		s2.push(s1.pop());
        int temp=s2.peek();
        while(s2.isEmpty())
    		s1.push(s2.pop());
		return temp;
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
		return s1.isEmpty();
        
    }

}
