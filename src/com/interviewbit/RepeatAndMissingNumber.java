package com.interviewbit;

import java.util.HashSet;
import java.util.Set;

public class RepeatAndMissingNumber {
	public int[] repeatedNumber(final int[] A) {
        Set<Integer> set=new HashSet<>();
        long sum=0;
        int[] res=new int[2];
        for(int i : A){
            sum+=i;
            if(!set.contains(i))
                set.add(i);
            else{
                res[0]=i;
            }
        }
        long expsum=(A.length*(A.length+1))/2;
        int diff=(int)(expsum-sum);
        res[1]=diff+res[0];
        return res;
    }

}
