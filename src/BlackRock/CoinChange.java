package BlackRock;

import java.util.Arrays;

public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int[] memo=new int[amount+1];
		coinHelper(coins, amount, memo);
		return memo[amount]==Integer.MAX_VALUE?-1:memo[amount];

	}

	public int coinHelper(int[] coins,int amount,int[] memo){
		if(amount<0)
			return Integer.MAX_VALUE;
		if(amount==0)
			return 0;
		int min=Integer.MAX_VALUE;
		for(int i: coins){
			int res=coinHelper(coins, amount-i, memo);
			if(res<min)
				min=res;
		}
		memo[amount]=min;
		return memo[amount];
		
	}
	
	
}
