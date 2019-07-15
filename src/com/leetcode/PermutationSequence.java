package com.leetcode;

public class PermutationSequence {
	public int cnt;

	public String getPermutation(int n, int k) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		cnt = 0;
		StringBuilder sb = new StringBuilder();
		permutation(arr, 0, k, sb);
		return sb.toString();
	}

	public void permutation(int[] arr, int l, int k, StringBuilder sb) {
		if (l >= arr.length) {
			cnt++;
			if (cnt == k)
				for (int i : arr)
					sb.append(i);
			return;
		}
		if (cnt <= k) {
			for (int i = l; i < arr.length; i++) {
				swap(arr, l, i);
				permutation(arr, l + 1, k, sb);
				swap(arr, l, i);
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		PermutationSequence obj = new PermutationSequence();
		System.out.println(obj.getPermutation(2, 2));
	}
}
