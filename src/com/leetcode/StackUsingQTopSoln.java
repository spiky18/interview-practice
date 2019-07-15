package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQTopSoln {
	 Queue<Integer> queue;
	    
	    public StackUsingQTopSoln()
	    {
	        this.queue=new LinkedList<Integer>();
	    }
	    
	    // Push element x onto stack.
	    public void push(int x) 
	    {
	       queue.add(x);
	       for(int i=0;i<queue.size()-1;i++)
	       {
	           queue.add(queue.poll());
	       }
	    }

	    // Removes the element on top of the stack.
	    public void pop() 
	    {
	        queue.poll();
	    }

	    // Get the top element.
	    public int top() 
	    {
	        return queue.peek();
	    }

	    // Return whether the stack is empty.
	    public boolean empty() 
	    {
	        return queue.isEmpty();
	    }
	    
	    
    
public static void main(String[] args) {
	StackUsingQTopSoln stk=new StackUsingQTopSoln();
	stk.push(1);
	stk.push(2);
	System.out.println(stk.top());
	for(int i : stk.queue){
		System.out.println(i);
	}
}
}
