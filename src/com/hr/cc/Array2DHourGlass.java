package com.hr.cc;

import java.util.Scanner;

public class Array2DHourGlass {
	public static void main(String[] args) {
		int[][] arr = new int[6][6];
		Scanner sc = new Scanner(System.in);
		String row1 = sc.nextLine();
		String row2 = sc.nextLine();
		String row3 = sc.nextLine();
		String row4 = sc.nextLine();
		String row5 = sc.nextLine();
		String row6 = sc.nextLine();
		String[] row1Arr = row1.split(" ");
		String[] row2Arr = row2.split(" ");
		String[] row3Arr = row3.split(" ");
		String[] row4Arr = row4.split(" ");
		String[] row5Arr = row5.split(" ");
		String[] row6Arr = row6.split(" ");
		String[][] rowArr = { row1Arr, row2Arr, row3Arr, row4Arr, row5Arr, row6Arr };
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++)
				arr[i][j] = Integer.parseInt(rowArr[i][j]);
		}
		int largestSum = -10000;
		for (int i = 0; i < 4; i++) {
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1]
						+ arr[i + 2][j + 2];
				if(sum>largestSum)
					largestSum=sum;
			}
		}
		System.out.println(largestSum);
	}

}
