import java.util.ArrayList;
import java.util.List;

public class C {
	public void printName() {
		System.out.println("Value C");
	}

	static long maxSum(int[][] matrix) {
		long sum = 0;
		int count = 0;
		List<Integer> set=new ArrayList<>();
		long[] negSumCol = new long[matrix[0].length];
		long[] posSumCol = new long[matrix[0].length];
		long[] diff = new long[matrix[0].length];
		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = 0; i < matrix.length; i++) {
				negSumCol[j] += -1 * matrix[i][j];
				posSumCol[j] += matrix[i][j];
			}
			diff[j] = posSumCol[j] - negSumCol[j];
			if (diff[j] < 0){
				count++;
				set.add(j);
				}
		}
		
		for (int i = 0; i < matrix[0].length; i++) {
			if(diff[i]>0)
				sum+=posSumCol[i];
			else
				sum+=negSumCol[i];
		}
		
		if (count % 2 == 0) {
			return sum;
		}else{
			long mindiff=Integer.MAX_VALUE;
			int minindex=-1;
			for(int i : set){
				if(mindiff>diff[i]){
					mindiff=diff[i];
					minindex=i;
				}
			}
			sum=sum-negSumCol[minindex]+posSumCol[minindex];
		}
		

		return sum;
	}

	/*
	 * @Override public void x() { // TODO Auto-generated method stub
	 * 
	 * }
	 */
}
