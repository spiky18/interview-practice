package com.interviewbit;

import java.util.Arrays;

public class NobleInteger {
	public int solve(int[] a) {	
		Arrays.sort(a);
		for(int i=0;i<a.length-1;i++){
			if(a[i]!=a[i+1] && a[i]==a.length-i-1)
				return 1;
		}
        return -1;
    }
}
