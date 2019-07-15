package com.hr.cc;

import java.util.Scanner;

public class AbsolutePermutation {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            permutation(n,k);
        }
    }
    public static void permutation(int n,int k){
        int[] pos=new int[n];
        int[] perArr=new int[n];
        int[] indicator=new int[n];
        int i=0;
        while(i<n){
            pos[i]=i+1;
            i++;
        }
        i=0;
        int signal=0;
        while(i<n){
        	if(k>n/2)
        	{
        		signal=-1;
        		break;
        	}
        	
        	perArr[i]=pos[i]-k;
            if(perArr[i]<=0)
                perArr[i]=pos[i]+k;
            indicator[perArr[i]]++;
            if(perArr[i]>n || perArr[i]<=0 || indicator[perArr[i]]>1){
                signal=-1;
            break;}
            //indicator[perArr[i]-1]+=1;
            //if(indicator[perArr[i]-1]>1){
            	
            //}
            i++;
        }
        i=0;
        if(signal==-1)
            System.out.println(signal);
        else{
            while(i<n){
                System.out.print(perArr[i]+" ");
            i++;}
        }
        System.out.println();
    }
}
