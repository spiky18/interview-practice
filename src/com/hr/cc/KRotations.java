package com.hr.cc;

import java.util.Scanner;

public class KRotations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int q = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		a = rotation(a, k);
		for (int a0 = 0; a0 < q; a0++) {
			int m = in.nextInt();
			System.out.println(a[m]);
		}
	}

	public static int[] rotation(int[] arr, int k) {
		int[] temp = new int[arr.length];
		k %= arr.length;
		for (int i = 0; k + i < arr.length; i++)
			temp[i + k] = arr[i];
		for (int i = 1; k - i >= 0; i++)
			temp[k - i] = arr[arr.length - i];
		return temp;
	}
}
