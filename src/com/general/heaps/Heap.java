package com.general.heaps;

public class Heap {
	public int[] array;
	public int count;
	public int capacity;
	public int heap_type;

	
	
	
	public Heap(int capacity, int heap_type) {
		super();
		this.capacity = capacity;
		this.heap_type = heap_type;
		this.count=0;
		this.array=new int[capacity];
	}
	
	public int findMax(){
		if(count ==0)
			return -1;
		return array[0];
		
	}
	public int parent(int i) {
		if(i<=0)
			return 0;
		return (i-1)/2;
	}
	public int leftChild(int i){
		if(i*2+1>count)
			return -1;
		return i*2+1;
	}
	public int rightChild(int i){
		if(i*2+2>count)
			return -1;
		return i*2+2;
	}
	public void percolateDown(int i){
		int max=i;
		if(leftChild(i)!=-1 && array[leftChild(i)]>array[max])
			max=leftChild(i);
		if(rightChild(i)!=-1 && array[rightChild(i)]>array[max])
			max=rightChild(i);
		if(max!=i){
			int temp=array[i];
			array[i]=array[max];
			array[max]=temp;
			percolateDown(max);
		}
		
	}
	
	public void insertMax(int item){
		if(capacity>count)
			{
			array[count]=item;
			count++;
			}
		else
			resizeHeap();
		percolateUp(count);
	}
	
	public void resizeHeap(){
		capacity*=2;
		int[] newArr=new int[capacity];
		for(int i=0;i<capacity/2;i++){
			newArr[i]=array[i];
		}
		array=newArr;
	}
	
	public void percolateUp(int i){
		if(array[parent(i)]>array[i] && i>0){
			int temp=array[parent(i)];
			array[parent(i)]=array[i];
			array[i]=temp;
			percolateUp(parent(i));
		}
	}
	
	public void displayHeap(){
		for(int i=0;i<count;i++)
			System.out.print(array[i]+" ");
	}
}
