package com.hr.cc;

import java.util.Scanner;

public class Power extends NumberFormatException{
	int power(int n, int p){
        if(n<0 || p<0){
        throw new NumberFormatException("n and p should be non-negative");
    }
    if(p==1)
        return n;
    else if(p==0)
    	return 1;
    else
        return n*power(n,p-1);
	}

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0){
			int n=in.nextInt();
			int p=in.nextInt();
			Power pObj=new Power();
			try{
				int ans=pObj.power(n, p);
				System.out.println(ans);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			}
			
		}

	}


