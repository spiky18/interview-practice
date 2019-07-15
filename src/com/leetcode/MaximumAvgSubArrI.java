package com.leetcode;

public class MaximumAvgSubArrI {

	 public double findMaxAverage(int[] nums, int k) {
		 	if(k==0 || nums.length==0)
		 		return 0;
	        if(k>nums.length)
	        {
	            double sum=0l;
	            for(int i=0;i<nums.length;i++)
	            	sum+=nums[i];
	            return sum/nums.length;
	                
	        }
	        double sum=0,max=0;
	        for(int i=0;i<k;i++)
	        	max+=nums[i];
	        int i=0,j=k;
	        sum=max;
	        while(j<nums.length){
	        	sum=sum-nums[i]+nums[j];
	        	max=Math.max(sum, max);
	        	j++;
	        	i++;
	        }
	        
	        return max/k;
	    }

	 public double findMaxAverageII(int[] nums, int k) {
		 if(k==0 || nums.length==0)
		 		return 0;
	        if(k>nums.length)
	        {
	            double sum=0l;
	            for(int i=0;i<nums.length;i++)
	            	sum+=nums[i];
	            return sum/nums.length;
	                
	        }
	        double[] sumArr=new double[nums.length];
	        double sum=0;
	        for(int i=0;i<nums.length;i++){
	        	sum+=nums[i];
	        	sumArr[i]=sum;
	        }
	        double max=sumArr[k-1]/k;
	        //int i=0,j=k;
	        while(k<nums.length){
	        	double localmax=sumArr[k-1]/k;
	        	int j=0;
	        	for(int i=k;i<nums.length;i++){
	        		double val=sumArr[i]-sumArr[j];
	        		localmax=Math.max(localmax, val/k);
	        		j++;
	        	}
	        	max=Math.max(localmax, max);
	        	k++;
	        	
	        }
	        return max;
	 }
}
