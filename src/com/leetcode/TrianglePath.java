package com.leetcode;

import java.util.List;

public class TrianglePath {
    public int minimumTotal(List<List<Integer>> triangle) {
    	 int sum=0;
    	 int i=0;
         for(List<Integer> list : triangle){
             if(list.size()==1)
            	 sum+=list.get(i);
             else{
            	 int adj0=Integer.MAX_VALUE,adj1=list.get(i),adj2=list.get(i+1);
            	 if((i-1)>=0)
            		 adj0=list.get(i-1);
            	 int min=Math.min(Math.min(adj0, adj1),adj2);
            	 if(min==adj0)
            		 i--;
            	 else if(min==adj2)
            		 i++;
            	 sum+=min;
             }
         }
         return sum;
    }
}
