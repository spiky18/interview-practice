package com.hr.cc;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int maxcount=0;
        String p;
        
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=i+1;j<n;j++){
                int sum=arr[i]+arr[j];
                if(sum%k!=0)
                    count++;
                if(count>maxcount)
                    maxcount=count;
            }
        }
        System.out.print(maxcount);
    }
}