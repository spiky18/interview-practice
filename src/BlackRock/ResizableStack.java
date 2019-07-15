package BlackRock;

import java.util.Arrays;

public class ResizableStack {
	int size,curr;
	int[] stack;
	
	public ResizableStack(int size) {
		this.size=size;
		stack=new int[size];
		curr=-1;
	}
	
	public void push(int val){
		curr++;
		if(curr==size){
			size*=2;
			int[] temp=new int[size];
			temp=Arrays.copyOfRange(stack, 0, stack.length);
			stack=temp;
		}
		stack[curr]=val;
	}
	
	public int pop() throws Exception{
		if(curr==-1)
			throw new Exception("Empty Stack Exception");
		int result=stack[curr--];
		return result;
	}
	
}
