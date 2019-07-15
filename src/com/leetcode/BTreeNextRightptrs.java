package com.leetcode;

public class BTreeNextRightptrs {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode front = root;
		TreeLinkNode rear = root;
		int nextLevelNodes = 1;
		int currentLevelNodes = 0;
		while (front != null) {
			rear.next = front.left;
			if (rear.next != null)
				rear = rear.next;
			rear.next = front.right;
			if (rear.next != null)
				rear = rear.next;
			currentLevelNodes++;
			TreeLinkNode next = front.next;
			if (currentLevelNodes == nextLevelNodes) {
				front.next = null;
				nextLevelNodes *= 2;
				currentLevelNodes = 0;
			}
			front = next;
		}
	}

	public void connectII(TreeLinkNode root) {
		TreeLinkNode front = root;
		TreeLinkNode rear = root;
		TreeLinkNode dummy = new TreeLinkNode(Integer.MIN_VALUE);
		rear.next = dummy;
		rear = rear.next;
		while (front != null) {
			if (front.left != null)
				rear.next = front.left;
			if (rear.next != null)
				rear = rear.next;
			if (front.right != null)
				rear.next = front.right;
			if (rear.next != null)
				rear = rear.next;
			TreeLinkNode next = front.next;
			if (next == dummy) {
				front.next = null;
				if (dummy.next != null) {
					rear.next = dummy;
					next = dummy.next;
					dummy.next = null;
					rear = rear.next;
				}else{
					next=null;
				}
			}
			front = next;
		}
	}

}
