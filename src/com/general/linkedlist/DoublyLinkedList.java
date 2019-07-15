package com.general.linkedlist;

public class DoublyLinkedList {
	private DLLNode head;
	private DLLNode tail;
	private int length;

	public DoublyLinkedList() { // super(); 
		this.head=new
		DLLNode(Integer.MAX_VALUE, null, null);
		this.tail = new DLLNode(Integer.MIN_VALUE, head, null);
		this.length=0;
		head.setNext(tail);
	}

	/**
	 * Inserts at begining sets the new head
	 * 
	 * @param node
	 */
	public void insertAtBegin(int data) {
		DLLNode newNode = new DLLNode(data);
		newNode.setPrev(head);
		newNode.setNext(head.getNext());
		head.getNext().setPrev(newNode);
		head.setNext(newNode);
		length++;
	}

	/**
	 * Inserts at the end
	 * 
	 * @param node
	 */
	public void insertAtEnd(int data) {
		DLLNode newNode = new DLLNode(data);
		tail.getPrev().setNext(newNode);
		tail.setPrev(newNode);
		newNode.setNext(tail);
		newNode.setPrev(tail.getPrev());
		length++;
	}
	/**
	 * inserts at the specified position
	 * 
	 * @param node
	 */
	public void insertAtPos(int data,int position) {
		DLLNode newNode = new DLLNode(data);
		DLLNode itr=head;
		int l=0;
		while(l<position-1){
			itr=itr.getNext();
			l+=1;
		}
		newNode.setNext(itr.getNext());
		newNode.setPrev(itr);
		itr.getNext().setPrev(newNode);
		itr.setNext(newNode);
		length++;
	}
	/**
	 * Remove from front
	 * 
	 * @param node
	 * @throws Exception 
	 */
	public DLLNode deleteFirst() throws Exception {
		DLLNode node=head.getNext();
		if(node==tail){
			Exception e = new Exception("Tail node can not be removed");
			throw e;}
		head.setNext(node.getNext());
		node.getNext().setPrev(head);
		node.setNext(null);
		node.setPrev(null);
		length--;
		return node;
	}
	
	/**
	 * Removes from last
	 * 
	 * @param node
	 */
	public DLLNode deleteLast() throws Exception {
		DLLNode node=tail.getPrev();
		if(node==head){
			Exception e = new Exception("head node can not be removed");
			throw e;}
		tail.setPrev(node.getPrev());
		node.getPrev().setNext(tail);
		node.setNext(null);
		node.setPrev(null);
		length--;
		return node;
	}
	/**
	 * Removes from speified position
	 * 
	 * @param node
	 */
	public DLLNode deletePos(int position) throws Exception {
		DLLNode node=head.getNext();
		int l=1;
		while(l<position){
			node=node.getNext();
			l+=1;
		}
		if(node==head || node==tail){
			Exception e = new Exception("head and tail nodes can not be removed");
			throw e;}
		node.getNext().setPrev(node.getPrev());
		node.getPrev().setNext(node.getNext());
		node.setNext(null);
		node.setPrev(null);
		length--;
		return node;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s="head-->";
		if(length==0)
			return "Empty List";
		else{
			DLLNode itr=head.getNext();
			while(itr != tail){
				s+=itr.getData()+"-->";
				itr=itr.getNext();
			}
			s+="tail";
		}
		return s;
	}
}
