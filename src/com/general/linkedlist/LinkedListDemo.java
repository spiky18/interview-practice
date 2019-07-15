package com.general.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		ListNode head=new ListNode(3);
		head=head.insertAtBegin(head, 5);
		head.display(head);
		System.out.println();
		head=head.insertAtEnd(head, 15);
		head=head.insertAtEnd(head, 30);
		head.display(head);
		System.out.println();
		head=head.insertAtIndex(head, 77, 3);
		head.display(head);
		System.out.println();
		head=head.insertAtIndex(head, 56, 1);
		head=head.insertAtIndex(head, 23, 7);
		head.display(head);
		System.out.println();
		head=head.deleteFirst(head);
		head.display(head);
		System.out.println();
		head=head.deleteLast(head);
		head.display(head);
		System.out.println();
		
		head=head.deleteAtIndex(head, 5);
		head.display(head);
		//System.out.println("Even Odd"+head.evenOdd(head));
		System.out.println();
		head=head.deleteAtIndex(head, 1);
		head.display(head);
		System.out.println();
		head=head.reverseLinkedListIterative(head);
		//System.out.println(head);
		head.display(head);
		//System.out.println("Even Odd"+head.evenOdd(head));
		//System.out.println();
		//head.displayFromEnd(head);
		head=head.reverseLinkedListRecurse(head, null);
		head.display(head);
	}

}
