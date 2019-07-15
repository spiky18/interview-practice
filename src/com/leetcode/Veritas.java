package com.leetcode;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Veritas {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++)
			num[i] = in.nextInt();
		if (num.length <= 2) {
			int sum = 0;
			for (int i = 0; i < num.length; i++)
				sum += num[i];

		}
		int prevsum = num[0] + num[1];
		int cost = prevsum;
		for (int i = 2; i < n; i++) {
			// int j=i+1;
			prevsum += num[i];
			cost += prevsum;
		}
		System.out.println(cost);
	}

	static int reductionCost(int[] num) {
		if (num.length <= 2) {
			int sum = 0;
			for (int i = 0; i < num.length; i++)
				sum += num[i];
			return sum;
		}
		int prevsum = num[0] + num[1];
		int cost = prevsum;
		for (int i = 2; i < num.length; i++) {
			// int j=i+1;
			prevsum += num[i];
			cost += prevsum;
		}
		return cost;

	}

	int reduceArray(int[] array) {
	    PriorityQueue<Integer> heap = new PriorityQueue<>();
	    for (int i : array) {
	      heap.add(i);
	    }
	    int totalCost = 0;
	    while (heap.size() > 1) {
	      int currentSum = heap.poll() + heap.poll();
	      totalCost += currentSum;
	      heap.add(currentSum);
	    }
	    return totalCost;
	  }
	
	public String rollingString(String s, int operations_size, String[] operations) {
	    StringBuilder sb = new StringBuilder(s);
	    for (int i = 0; i < operations_size; i++) {
	      String[] ops = operations[i].split(" ");
	      int left = Integer.parseInt(ops[0]);
	      int right = Integer.parseInt(ops[1]);
	      if (ops[2].equals("L")) {
	        for (int k = left; k <= right; k++) {
	          char c = sb.charAt(k);
	          sb.setCharAt(k, c == 'a' ? 'z' : (char) (c - 1));
	        }
	      } else {
	        for (int k = left; k <= right; k++) {
	          char c = sb.charAt(k);
	          sb.setCharAt(k, c == 'z' ? 'a' : (char) (c + 1));
	        }
	      }
	    }
	    return sb.toString();
	  }
	



}
