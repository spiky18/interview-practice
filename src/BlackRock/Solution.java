package BlackRock;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		int[] a={4,9,3,10,6,11};
		System.out.println(maxDifference(a));

	}
	
	public static int maxDifference(int[] a){
		int n=a.length-1;
		int maxDiff=-1,max=a[n];
		for(int i=n-1;i>=0;i--){
			int diff=-1;
			if(a[i]>=max){
				max=a[i];
				diff=-1;
			}else{
				diff=max-a[i];
			}
			maxDiff=Math.max(diff, maxDiff);
		}
		return maxDiff;
		
	}

	static int[][] aggregatePools(int[] poolList) {
		// Arrays.sort(poolList);
		List<int[]> pools = new ArrayList<int[]>();
		for (int i = 0; i < poolList.length; i++) {
			if (poolList[i] >= 1000) {
				pools.add(new int[] { poolList[i] });
				poolList[i] = -1;
			}
		}
		for (int i = 0; i < poolList.length - 1; i++) {
			for (int j = i + 1; j < poolList.length; j++) {
				if (poolList[i] + poolList[j] == 1000) {
					pools.add(new int[] { poolList[i], poolList[j] });
					poolList[i] = -1;
					poolList[j] = -1;
				}
			}
		}

		for (int i = 0; i < poolList.length - 2; i++) {
			for (int j = i + 1; j < poolList.length - 1; j++) {
				for (int k = j + 1; k < poolList.length - 2; k++) {
					if (poolList[i] + poolList[j] + poolList[k] == 1000) {
						pools.add(new int[] { poolList[i], poolList[j], poolList[k] });
						poolList[i] = -1;
						poolList[j] = -1;
						poolList[k] = -1;
					}
				}
			}

		}
		int[][] result = new int[pools.size()][];
		int k = 0;
		for (int[] i : pools) {
			result[k++] = i;
		}
		
		return result;

	}
	
	/*static int evaluate(String lisp){
		
		
		
	}*/
	
	
}
