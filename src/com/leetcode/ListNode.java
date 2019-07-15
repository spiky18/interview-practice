package com.leetcode;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static ListNode arrayConstructor(int[] nums) {
		if (nums != null && nums.length != 0) {
			ListNode head = new ListNode(nums[0]);
			ListNode count = head;
			for (int i = 1; i < nums.length; i++) {
				count.next = new ListNode(nums[i]);
				count = count.next;
			}
			return head;
		}
		return null;
	}
	
	
	public ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode p=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return p;
        
    }

	@Override
	public String toString() {
		ListNode count = this;
		StringBuilder sb=new StringBuilder();
		while(count!=null) {
			sb.append(count.val+"-->");
			count=count.next;
		}
		sb.append("Null");
		return sb.toString();
	}
}
