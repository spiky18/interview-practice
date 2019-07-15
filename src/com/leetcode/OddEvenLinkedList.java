package com.leetcode;

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		boolean update=false;
		ListNode oddListEnd=head,prev=null,runner=head.next;
		while(runner!=null){
			if(update){
				ListNode temp=oddListEnd.next;
				oddListEnd.next=runner;
				prev.next=runner.next;
				runner.next=temp;
				runner=prev.next;
				oddListEnd=oddListEnd.next;
			}
			else{
				prev=runner;
				runner=runner.next;
			}
			update=!update;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode runner=head;
		for(int i=2;i<=100;i++){
			runner.next=new ListNode(i);
			runner=runner.next;
		}
		OddEvenLinkedList obj=new OddEvenLinkedList();
		System.out.println(obj.oddEvenList(head));
	}
}
