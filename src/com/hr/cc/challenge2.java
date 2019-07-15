package com.hr.cc;

import java.util.ArrayList;
import java.util.Scanner;

public class challenge2 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1=in.nextLine();
        String[] line1Arr=line1.split(" ");
        //System.out.println(line1Arr);
        int totalNumbers = Integer.parseInt(line1Arr[0]);
        int divisor=Integer.parseInt(line1Arr[1]);
        //System.out.println(totalNumbers+"  "+divisor);
        String[] arr ;
        ArrayList<Integer> temp=new ArrayList<Integer>();
        //in.nextLine();
        String input=in.nextLine();
        arr=input.split(" ");
        for(int arr_i=0; arr_i < totalNumbers; arr_i++){
            temp.add(Integer.parseInt(arr[arr_i]));
        }
        System.out.println(maxlength(temp, divisor));
	}
	public static int maxlength(ArrayList<Integer> arr, int d){
		int subsetLength=0;
		for(int i=0;i<arr.size();i++){
			ArrayList<Integer> tempAr=new ArrayList<Integer>();
			tempAr.add(arr.get(i));
			for(int j=0;j<arr.size();j++){
				if(i!=j)
				{
					int x=arr.get(i)+arr.get(j);
					if(x%d!=0)
						tempAr.add(j);
				}	
			}
			if(tempAr.size()>subsetLength)
				subsetLength=tempAr.size();
		}
		return subsetLength;
	}
}
