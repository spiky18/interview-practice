package com.hr.cc;

import java.util.ArrayList;
import java.util.Scanner;

public class missingArray {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String[] arr ;
        ArrayList<Integer> inputArr=new ArrayList<Integer>();
        ArrayList<Integer> idealArr=new ArrayList<Integer>();
        ArrayList<Integer> missingNumbers=new ArrayList<Integer>();
        String input=sc.nextLine();
        arr=input.split(" ");
        for(int arr_i=0; arr_i < arr.length; arr_i++){
            inputArr.add(Integer.parseInt(arr[arr_i]));
        }
        int j=0;
        for(int i=0;i<inputArr.size()+2;i++){
        		idealArr.add(i+1);
        }
        for(int i=0;i<inputArr.size()+2;i++){
        	if(j<inputArr.size() && idealArr.get(i)==inputArr.get(j))
        		j++;
        	else
        		missingNumbers.add(idealArr.get(i));
        }
        System.out.println(missingNumbers.toString());
	}

}
