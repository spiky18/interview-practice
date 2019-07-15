package com.leetcode;

public class BeautifulArrangement {
	public int cnt = 0;

	public int countArrangement(int N) {

		int[] nums = new int[N];
		for (int i = 0; i < N; i++)
			nums[i] = i + 1;
		permutation(nums, 0, N - 1);
		return cnt;
	}

	public boolean permutation(int[] arr, int l, int r) {
		if (l > r) {
			cnt++;
			for(int i=0;i<arr.length;i++)
                System.out.print(arr[i]+" ");
            System.out.println("count="+cnt);
			return true;
		}

		for (int i = l; i <= r; i++) {

			swap(arr, l, i);
			if ((l + 1) % arr[l] == 0 || arr[l] % (l + 1) == 0)
				permutation(arr, l + 1, r);
			swap(arr, l, i);

		}

		return false;
	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		BeautifulArrangement obj = new BeautifulArrangement();
		obj.countArrangement(6);
	}
}
/**
 * 1,2,3,4 1,2,4,3
 */
