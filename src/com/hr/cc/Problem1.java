package com.hr.cc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

//Problem        : Egyptian Cafe
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class Problem1
{
	static int front=0;
	static int rear=0;
  public static void main(String[] args)
  {

     Scanner stdin = new Scanner(System.in);
     String line1,line2;
      line1=stdin.nextLine();
      line2= stdin.nextLine();
     stdin.close();
     String[] line1Arr=line1.split(" ");
     int n=Integer.parseInt(line1Arr[0]);
     int m=Integer.parseInt(line1Arr[1]);
     String[] priorityArr=line2.split(" ");
     int priority=Integer.parseInt(priorityArr[m]);
     int[] arr =new int[priorityArr.length];
     for(int i=0;i<priorityArr.length;i++){
    	 arr[i]=Integer.parseInt(priorityArr[i]);
     }
     int maxIndex=findMax(arr);
     int initialdiff=maxIndex-m;
     int[] queue=new int[arr.length];
     //for(int i=0;)
     int count=0;
     Arrays.sort(arr);
     int j=0;
     for(int i=arr.length-1;i>=0;i--){
    	 if(arr[i]>priority)
    		 {queue[j]=arr[i];
        	 j++;
    		 } 
     }
     int index=findData(queue,priority);
     System.out.println(index);
     int res=index*2;
     /*if(diff+count !=0)
    	 res=2*(diff+count);*/
     
     System.out.println(res);
     
     //Arrays.
     //n-m;
     
     //Arrays.reverseOrder();
     
     
     
  }
  public static void enqueue(int[] arr,int data){
	  arr[rear]=data;
	  rear++;
  }
  public static int dequeue(int[] arr){
	  int data=arr[front];
	  front++;
	  return data;
  }
  public static int findMax(int[] arr){
	  int max=-10000;
	  int index=-10;
	  for(int i=0;i<arr.length;i++){
		  if(arr[i]>max){
			  max=arr[i];
			  index=i;}
	  }
	  return index;
  }
  public static int findData(int[] arr,int data){
	  int index=0;
	  for(int i=0;i<arr.length;i++){
		  if(arr[i]==data)
			  index= i;
	  }
	  return index;
  }
  //public bubble(int[] arr,int )
  /*public static int[] squeezedArr(int[] a){
	  int[] newAr;
	  for(int i=0;i<a.length;i++)
		  
	return a;
	  
  }*/
}
