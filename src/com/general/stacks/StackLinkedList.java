package com.general.stacks;

import com.general.linkedlist.ListNode;

public class StackLinkedList {
	ListNode top;
	
	public void displayStack(){
		ListNode topCount=top;
		System.out.print("top-->");
		while(topCount!=null){
			System.out.println(topCount.getData());
			topCount=topCount.getNext();
		}
	}

	public void push(int data) {
		ListNode temp = new ListNode(data);
		temp.setNext(top);
		top = temp;
	}

	public int pop() {
		int data = top.getData();
		top = top.getNext();
		return data;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty(){
		if(top!=null)
			return false;
		return true;
	}

}
