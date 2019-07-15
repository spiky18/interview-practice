package com.leetcode;

public class LC445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null && l2 ==null )
			return l1;
		if(l2==null)
			return l1;
		if(l1==null)
			return l2;
		int sizeOfl1 = sizeOfList(l1);
		int sizeOfl2 = sizeOfList(l2);
		int diff = sizeOfl1 - sizeOfl2;
		if (diff < 0) {
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
			diff *= -1;
		}
		ListNode sumhead = l1;
		int cnt = 0;
		while (cnt < diff) {
			sumhead = sumhead.next;
			cnt++;
		}
		sumhead = addEqualList(sumhead, l2);
		cnt = 0;
		int carry=addCarry(l1, sumhead);
		if(carry>0){
			ListNode cryHead=new ListNode(carry);
			cryHead.next=l1;
			l1=cryHead;
		}
		return l1;

	}

	public ListNode addEqualList(ListNode l1, ListNode l2) {
		if (l1.next == null && l2.next == null) {
			l1.val += l2.val;
			return l1;
		}
		addEqualList(l1.next, l2.next);
		int c = 0;
		if (l1.next.val > 9) {
			c = l1.next.val / 10;
			l1.next.val %= 10;
		}
		l1.val += c + l2.val;
		return l1;
	}

	public int sizeOfList(ListNode head) {
		int size = 0;
		ListNode count = head;
		while (count != null) {
			size++;
			count = count.next;
		}
		return size;

	}

	public int addCarry(ListNode head, ListNode sumhead) {
		if (head == sumhead) {
			int c=sumhead.val / 10;
			sumhead.val = sumhead.val > 9 ? sumhead.val % 10 : sumhead.val;
			return c;
		}
		int carry = addCarry(head.next, sumhead);
		head.val += carry;
		carry=head.val/10;
		head.val = head.val > 9 ? head.val % 10 : head.val;
		return carry;
	}

	public static void main(String[] args) {
		int[] arr1 = { 7, 2, 4, 3 };
		int[] arr2 = { 9, 5,6, 4 };
		ListNode l2 = ListNode.arrayConstructor(arr1);
		ListNode l1 = ListNode.arrayConstructor(arr2);
		// ListNode.print(l1);
		// ListNode.print(l2);
		LC445 obj = new LC445();
		l1 = obj.addTwoNumbers(l1, l2);
		System.out.println(l1.toString());
	}

}
