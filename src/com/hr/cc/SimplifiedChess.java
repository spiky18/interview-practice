package com.hr.cc;

import java.util.ArrayList;

public class SimplifiedChess {
	String[] row1={"A","B","C","D"};
	String[] row2={"A","B","C","D"};
	String[] row3={"A","B","C","D"};
	String[] row4={"A","B","C","D"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=6,y=7;
		
	}
	public static int[] convertToBinary(int x){
		ArrayList<Integer> binary=new ArrayList<Integer>();
		while(x>0){
			int r=x%2;
			binary.add(r);
			x/=2;
		}
		//int[] arr=(int) binary.toArray();
		return null;
	}
}
