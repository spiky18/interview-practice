package com.leetcode.topinterviewquestions.easy.arrays;

public class RotateArray {
	public void rotate(int[] arr, int k) {
		k=k%arr.length;
		reverse(arr,0,arr.length-1);
		reverse(arr,0,k-1);
		reverse(arr,k,arr.length-1);
	}
	
	public void reverse(int[] arr,int i,int j){
		while(i<=j){
			int temp=arr[j];
			arr[j]=arr[i];
			arr[i]=temp;
			i++;
			j--;
		}
	}
	
	public void rotateII(int[] arr, int k) {
		int[] temp=new int[arr.length];
		for(int i=0;i<arr.length;i++)
			arr[i]=temp[i];
		for(int i=k;i<arr.length;i++){
			arr[i]=temp[i-k];
		}
		for(int i=0;i<k;i++){
			arr[i]=temp[arr.length-k-i];
		}
	}
}
