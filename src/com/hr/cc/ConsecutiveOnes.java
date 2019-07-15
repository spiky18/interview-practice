package com.hr.cc;

import java.util.Scanner;

public class ConsecutiveOnes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int localCount = 0;
		int maxCount = 0;
		while (n > 1) {
			if (n % 2 == 1)
				localCount++;
			else
				localCount = 0;
			if (localCount > maxCount)
				maxCount = localCount;
			n /= 2;
		}
		if ( n == 1) {
			localCount += 1;
			if (localCount > maxCount)
				maxCount = localCount;
		}
		System.out.println(maxCount);
	}
}
