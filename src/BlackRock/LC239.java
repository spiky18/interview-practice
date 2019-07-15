package BlackRock;

import java.util.PriorityQueue;

public class LC239 {
	 public int[] maxSlidingWindow(int[] nums, int k) {
	        if(nums==null || nums.length==0)
	            return new int[0];
			PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
			for(int i=0;i<k;i++)
				pq.add(nums[i]);
			int[] result=new int[nums.length-k+1];
			int i=0;
			for(int j=0;j<result.length;j++){
				result[j]=pq.peek();
				pq.remove(nums[i]);
				if(j+k<nums.length)
					pq.add(nums[j+k]);
				i++;
			}
			return result;
		}
}
