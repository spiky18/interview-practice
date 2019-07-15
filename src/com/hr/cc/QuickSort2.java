package com.hr.cc;

import java.util.*;
public class QuickSort2 {
                 static int partition(int[] ar,int start,int end) {
              int j=start+1;
              int i=j-1;
              for(j=start+1;j<end;j++){
                  if(ar[j]<ar[start]){
                      i=i+1;
                      int t=ar[i];
                      ar[i]=ar[j];
                      ar[j]=t;
                  }
              }
              int t=ar[i];
              ar[i]=ar[start];
              ar[start]=t;
               return i;     
       }   
 
          static void quickSort(int[] ar,int start,int end) {
              if(start<end)
              {
                  int q=partition(ar,start,end);
              //System.out.println("q= "+q);
              quickSort(ar,start,q);
               if(q-start>1){
               for(int i=start;i<q;i++)
                  System.out.print(ar[i]+ " ");
                   System.out.println("");} 
               quickSort(ar,q+1,end);
              if(end-q-1>1){
               for(int i=q+1;i<end;i++)
                  System.out.print(ar[i]+ " ");
                  System.out.println(""); 
              }
              }
              
       }   
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           quickSort(ar,0,ar.length);
          printArray(ar);
       }    
   }
