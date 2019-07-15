package com.leetcode;

import java.util.HashMap;

public class LRUCache {
	public HashMap<Integer, Node> cache;
	int cap, size;
	Node front, rear;

	public LRUCache(int capacity) {
		cache = new HashMap<>();
		cap = capacity;
		size = 0;
		front = null;
		rear = null;
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null) {
			return -1;
		}
		put(node.key,node.value);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = cache.get(key);
		if (size < cap) {
			if (node == null) {
				size++;
				node = new Node(key, value);
				cache.put(key, node);
				if (front == null) {
					front = node;
					rear = node;
				}
			} /*else {
				//node.prev = f;
				node.next = front;
				node.prev = null;
			}*/
		} else {
			if (node != null && node!=front) {
				node.prev.next = node.next;
				if(node.next!=null)
					node.next.prev = node.prev;
				else
					rear=node.prev;
				node.prev = null;
			} else {
				node=new Node(key,value);
				rear.prev.next = null;
				Node prev = rear.prev;
				rear.prev = null;
				cache.remove(rear.key);
				rear = prev;
				cache.put(key, node);
			}
		}
		if (front != node) {
			node.next = front;
			front.prev = node;
			front = node;
		}

	}

	class Node {
		public int key, value;
		public Node next, prev;

		Node(int k, int v) {
			key = k;
			value = v;
			next = null;
			prev = null;
		}
	}
	
	
	public static void main(String[] args) {
		LRUCache obj=new LRUCache(2);
		obj.put(1, 1);
		obj.put(2, 2);
		obj.get(1);
		obj.put(3, 3);
		obj.get(2);
		obj.put(4, 4);
		obj.get(1);
		obj.get(3);
	}
}
