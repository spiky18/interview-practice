package com.general.sorting;

public class Sorting {
	public int[] selectionSort(int[] a){
		for(int i=0;i<a.length;i++){
			int min=i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[min]){
					min=j;
				}
			}
			int temp=a[min];
			a[min]=a[i];
			a[i]=temp;
		}
		return a;
	}
	
	public int[] insertionSort(int[] a){
		for(int i=1;i<a.length;i++){
			int key=a[i];
			int j=i-1;
			while(j>-1 && a[j]>key){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=key;
		}
		return a;
	}
	public int[] quickSort(int[] a,int start,int end){
		if(start<end){
			int pivot=partition(a, start, end);
			quickSort(a,start,pivot-1);
			quickSort(a,pivot+1,end);
		}
		return a;
	}
	public int partition(int[] a, int start,int end){
		int pivot=a[end];
		int j=start;
		int i=j-1;
		while(j<end){
			if(a[j]<pivot){
				i++;
				int temp=a[j];
				a[j]=a[i];
				a[i]=temp;
			}
			j++;
		}
		a[end]=a[i+1];
		a[i+1]=pivot;
		return i+1;
	}
}
