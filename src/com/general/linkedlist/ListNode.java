package com.general.linkedlist;

public class ListNode {
	private int data;
	private ListNode next;
	public ListNode(int data) {
		//super();
		this.data = data;
		this.next = null;
	}
	
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public ListNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(ListNode next) {
		this.next = next;
	}

	/**
	 * Inserts at the end of list
	 * @param head
	 * @param data
	 * @return
	 */
	public ListNode insertAtEnd(ListNode head,int data){
		ListNode newNode=new ListNode(data);
		ListNode count=head;
		if(head==null){
			head=newNode;
			return head;
			}
		while(count.next!=null)
			count=count.next;
		count.next=newNode;
		return head;
	}
	/**
	 * inserts at beginning
	 * @param head
	 * @param data
	 * @return
	 */
	public ListNode insertAtBegin(ListNode head,int data){
		ListNode newNode=new ListNode(data);
		if(head==null){
			head=newNode;
			return head;
			}
		newNode.next=head;
		return newNode;
	}
	/**
	 * Inserts at specified index
	 * @param head
	 * @param data
	 * @param i
	 * @return
	 */
	public ListNode insertAtIndex(ListNode head,int data,int i){
		ListNode newNode=new ListNode(data);
		ListNode countNode=head;
		int count=1;
		if(i==1 || head==null)
			return insertAtBegin(head, data);
		while(countNode.next!=null){
			countNode=countNode.next;
			count++;
			if(count==i-1) 
				break;
			}
		ListNode nextNode=countNode.next;
		countNode.next=newNode;
		newNode.next=nextNode;
		return head;
	}
	
	/**
	 * displays the current linked list
	 * @param head
	 */
	public void display(ListNode head){
		ListNode count=head;
		while(count!=null){
			System.out.print(count.data+" ");
			count=count.next;
		}
	}
	/**
	 * delete first node
	 * @param head
	 * @return
	 */
	public ListNode deleteFirst(ListNode head){
		if(head==null)
			return null;
		head=head.next;
		return head;
	}
	/**
	 * deletes the last node
	 * @param head
	 * @return
	 */
	public ListNode deleteLast(ListNode head){
		if(head==null)
			return null;
		ListNode countNode=head.next;
		ListNode prev=null;
		while(countNode.next!=null){
			prev=countNode;
			countNode=countNode.next;}
		prev.next=null;
		return head;
	}
	/**
	 * deletes at index i
	 * @param head
	 * @return
	 */
	public ListNode deleteAtIndex(ListNode head,int i){
		if(head==null)
			return null;
		ListNode countNode=head;
		ListNode prev=null;
		int count=1;
		if(i==1)
			return deleteFirst(head);
		while(countNode.next!=null){
			if(count==i)
				break;
			prev=countNode;
			countNode=countNode.next;
			count++;}
		prev.next=countNode.next;
		return head;
	}
	/**
	 * Reverse Linked list
	 */
	public ListNode reverseLinkedListIterative(ListNode head){
	
		
		ListNode prev=null;
		ListNode current=head;
		while(current!=null){
			ListNode next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		return prev;
		
	}
	
	public static ListNode reverseLinkedListRecurse(ListNode ptr,ListNode prev){
		if( ptr.next==null){
			ptr.next=prev;
			return ptr;
		}
		
		else{	
		ListNode temp=reverseLinkedListRecurse(ptr.next,prev);
		ptr.next=prev;
		return temp;
		}
	}
	
	public void displayFromEnd(ListNode head){
		if(head==null)
			return;
		displayFromEnd(head.next);
		System.out.print(head.data+" ");
	}
	
	public int evenOdd(ListNode head){
		while(head !=null && head.next!=null)
			head=head.next.next;
		if(head==null)
			return 0;
		return 1;
	}
}
