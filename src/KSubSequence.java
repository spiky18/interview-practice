import java.util.Scanner;

public class KSubSequence {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
        int n = scanner.nextInt();
        for(int l = 0; l < tests; l++)
		{
			int k = scanner.nextInt();
			int[] numbers = new int[n];

			for(int i = 0; i < n; i++)
			{
				numbers[i] = scanner.nextInt();
			}
        long res=kSubsequence(k,numbers);
            System.out.println(res);
        }
    }
    
    static long kSubsequence(int k, int[] nums){
	long[] commulativeSum = new long[k];
	
	commulativeSum[0] = 1;

	int prefixSum = 0;
	for(int i = 0; i < nums.length; i++)
	{
		prefixSum += nums[i];
		prefixSum %= k;
		commulativeSum[prefixSum] += 1;
	}

	long result = 0;
	for(int i = 0; i < k; i++)
	{
		result += commulativeSum[i] * (commulativeSum[i] - 1) / 2;
	}
	return result;
}
}
