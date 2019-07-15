package com.hr.cc;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author himan
 * Cutsticks
 *
 */
public class challenge1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr ;
        ArrayList<Integer> temp=new ArrayList<Integer>();
        in.nextLine();
        String input=in.nextLine();
        arr=input.split(" ");
        for(int arr_i=0; arr_i < arr.length; arr_i++){
            temp.add(Integer.parseInt(arr[arr_i]));
        }
        
        //temp=(ArrayList) Arrays.asList(arr);
        //System.out.println(temp);
        while(temp.size()>0){
        	System.out.println(temp.size());
        	temp=cutStick(temp);
        	//System.out.println(arr);
        }
        
    }
    static int findSmall(ArrayList<Integer> arr){
    	int small=1001;
        for(int i=0; i<arr.size();i++){
        	if(arr.get(i)<small)
        		small=arr.get(i);
        }
		return small;
    }
    public static ArrayList<Integer> cutStick(ArrayList<Integer> arr){
    	ArrayList<Integer> cutArr=new ArrayList<Integer>();
    	int smallest=findSmall(arr);
    	for(int i=0; i<arr.size();i++){
    		int newLength=arr.get(i)-smallest;
    		if(newLength>0){
    			cutArr.add(newLength);
    		}
        }
		return cutArr;}
}
