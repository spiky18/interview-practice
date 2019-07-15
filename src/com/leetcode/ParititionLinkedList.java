package com.leetcode;

public class ParititionLinkedList {

	public ListNode partition(ListNode head, int x) {
		if(head==null)
			return head;
		ListNode lowEnd = null, highEnd = null, highHead = null;
		ListNode count = head;
		while (count != null) {
			ListNode next=count.next;
			if (count.val >= x) {
				if (highHead != null) {
					highEnd.next=count;
					highEnd=highEnd.next;
				} else {
					highHead = count;
					highEnd = count;
				}
			} else {
				
				if (lowEnd != null){
					lowEnd.next=count;
					lowEnd=lowEnd.next;
				}
				else
					lowEnd = count;
			}
			count=next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		int[] nums={1,2,3,4,2,5};
		ListNode node= ListNode.arrayConstructor(nums);
		ParititionLinkedList obj=new ParititionLinkedList();
		obj.partition(node, 3);
		System.out.println(node);
	}
}
