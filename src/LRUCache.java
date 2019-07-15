import java.util.HashMap;

public class LRUCache {
	HashMap<Integer, Node> map;
	int size;
	Node head, tail;

	public LRUCache(int capacity) {
		map = new HashMap<>();
		size = capacity;
		head = null;
		tail = null;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node node = map.get(key);
		updateHead(node);
		return node.val;
	}

	public void put(int key, int value) {

		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.val = value;
			updateHead(node);

		} else {
			Node node = new Node(key, value);
			if (map.size() < size) {

				if (head == null) {
					head = node;
					tail = node;
				} else
					updateHead(node);

			} else {
				map.remove(tail.key);
				removeTail();
				updateHead(node);

			}
			map.put(key, node);
		}

	}

	public void updateHead(Node newHead) {
		Node prev = newHead.prev;
		Node next = newHead.next;
		if (prev != null) {
			prev.next = next;
			if (next != null)
				next.prev = prev;
			else
				tail = prev;
		}
		newHead.prev = null;
		newHead.next = head;
		if (head != null)
			head.prev = newHead;
		head = newHead;
	}

	public void removeTail() {
		if (tail != null) {
			Node prev = tail.prev;
			if (prev != null)
				prev.next = null;
			tail = prev;
			map.remove(tail.key);
		}
	}
}

class Node {
	Node prev, next;

	int key, val;

	Node(int k, int v) {
		this.key = k;
		this.val = v;
		prev = null;
		next = null;
	}

}