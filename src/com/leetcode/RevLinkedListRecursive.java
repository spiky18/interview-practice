package com.leetcode;

public class RevLinkedListRecursive {
	public ListNode reverseList(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode p=reverseList(head.next);
		head.next.next=head;
		head.next=null;
		//p.next=head;
		return p;
	}
	
	 public ListNode reverseBetween(ListNode head, int m, int n) {
		 	if(m==n || m>n)
		 		return head;
		 	int i=1;
		 	ListNode curr=head,prevM=null;
		 	while(i<m){
		 		prevM=curr;
		 		curr=curr.next;
		 		i++;
		 	}
		 	ListNode front=curr,rear=curr;
		 	
		 	curr=curr.next;
		 	while(i<n){
		 		ListNode next=curr.next;
		 		rear.next=next;
		 		curr.next=front;
		 		//front.next=next;
                front=curr;
                rear=rear.next;
		 		curr=next;
		 		i++;
		 	}
		 	prevM.next=front;
	        return head;
	    }
	
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode two= new ListNode(2);
		two.next=new ListNode(3);
		head.next=two;
		RevLinkedListRecursive obj=new RevLinkedListRecursive();
		head=obj.reverseList(head);
		ListNode h=ListNode.arrayConstructor(new int[]{1,2,3,4,5});
		h=obj.reverseBetween(h, 2, 4);
	}

}
