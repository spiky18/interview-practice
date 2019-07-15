package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {

	public List<Integer> list;
	public int cursor;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		cursor = 0;
		list = new ArrayList<>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}

	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (cursor != list.size())
			return list.get(cursor);
		else
			return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		cursor++;
		return list.get(cursor - 1);
	}

	@Override
	public boolean hasNext() {
		return cursor != list.size();
	}
}
