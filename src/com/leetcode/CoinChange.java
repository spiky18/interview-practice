package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		if(amount<0)
			return -1;
		int[] memo=new int[amount+1];
		//Arrays.fill(memo, Integer.MAX_VALUE);
		memo[0]=0;
		coinHelper(coins, amount, memo);
		return memo[amount]==Integer.MAX_VALUE?-1:memo[amount];
	}
	
	public int coinHelper(int[] coins,int amount,int[] memo){
		if(amount<0)
			return Integer.MAX_VALUE;
		if(amount==0)
			return 0;
		if(memo[amount]!=0)
			return memo[amount];
		int min=Integer.MAX_VALUE;
		for(int i : coins){
			int res=coinHelper(coins, amount-i, memo);
			if(res<min)
				min=1+res;
		}
		memo[amount]=min;
		return 0;
	}
	public int coinChangeBottomUp(int[] coins, int amount) {
		int[] memo=new int[amount+1];
		//int[] coinTracer=new int[amount+1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		//Arrays.fill(coinTracer, -1);
		memo[0]=0;
		for(int i : coins){
			for(int j=i;j<memo.length;j++){
				int comp=memo[j-i];
				if(comp!=Integer.MAX_VALUE){
					memo[j]=Math.min(memo[j], 1+comp);
				}
			}
			
		}
		
		return memo[amount];
	}

	
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		helper(n, list, "", 0, 0);
		return list;
	}
	
	public void helper(int max,List<String> list,String curr,int open, int close){
		if(curr.length()==max*2){
			list.add(curr);
			return;
		}
		
		if(open<max)
			helper(max, list, curr+"(", open+1, close);
		
		if(open>close){
			helper(max, list, curr+")", open, close+1);
			
		}
		
	}
}
