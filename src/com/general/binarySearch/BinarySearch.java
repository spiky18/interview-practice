package com.general.binarySearch;

public class BinarySearch {
	private int[] arr;

	public int binarySearch(int searchElement, int left, int right) {
		if (right >= left) {
			int mid = (left + right) / 2;
			if (arr[mid] == searchElement)
				return mid;
			else if (arr[mid] > searchElement)
				return binarySearch(searchElement, left, mid - 1);
			else
				return binarySearch(searchElement, mid + 1, right);
		}
		return -1;

	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] arr = { 1, 2, 7, 9, 10, 29, 100, 109 };
		bs.setArr(arr);
		System.out.println("index of 9 is " + bs.binarySearch(9, 0, arr.length - 1));
		System.out.println("index of 10 is " + bs.binarySearch(10, 0, arr.length - 1));
		System.out.println("index of 13 is " + bs.binarySearch(13, 0, arr.length - 1));
		System.out.println("index of 133 is " + bs.binarySearch(133, 0, arr.length - 1));
	}
}
