package com.leetcode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class QUsingStack {
	 public static class MyQueue<T> {
		 	ArrayList<Integer> a =new ArrayList<Integer>();
		 	
	        Stack<T> stackNewestOnTop = new Stack<T>();

	        public void enqueue(T value) { // Push onto newest stack
	        	//a.
	            Stack<T> temp = new Stack<T>();
	            while(!stackNewestOnTop.isEmpty())
	                temp.push(stackNewestOnTop.pop());
	            stackNewestOnTop.push(value);
	            while(!temp.isEmpty())
	                stackNewestOnTop.push(temp.pop());
	        }

	        public T peek() {
	             return stackNewestOnTop.peek();
	        }

	        public T dequeue() {
	            return stackNewestOnTop.pop();
	        }
	    }

	    
	    public static void main(String[] args) {
	        MyQueue<Integer> queue = new MyQueue<Integer>();
	        
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
	        
	        for (int i = 0; i < n; i++) {
	            int operation = scan.nextInt();
	            if (operation == 1) { // enqueue
	                queue.enqueue(scan.nextInt());
	            } else if (operation == 2) { // dequeue
	                queue.dequeue();
	            } else if (operation == 3) { // print/peek
	                System.out.println(queue.peek());
	            }
	        }
	        scan.close();
	    }
}
