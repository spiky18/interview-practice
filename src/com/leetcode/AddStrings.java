package com.leetcode;

public class AddStrings {
	public String addStrings(String num1, String num2) {
		int i=num1.length()-1,j=num2.length()-1,c=0;
		StringBuilder sb=new StringBuilder();
		while(i>=0 && j>=0){
			int v1=Character.getNumericValue(num1.charAt(i));
            int v2=Character.getNumericValue(num2.charAt(j));
            int sum=v1+v2+c;
            c=sum/10;
            sum=sum%10;
            sb.insert(0, sum);
            i--;
            j--;
		}
		sb=(i==0)?addNext(num2, j, sb, c):addNext(num1, i, sb, c);
		return sb.toString();
	}
	
	public StringBuilder addNext(String s,int i,StringBuilder sb,int c){
        if(i==0)
            return sb;
        while(i>=0){
            int v2=Character.getNumericValue(s.charAt(i));
            int sum=v2+c;
            c=sum/10;
            sum=sum%10;
            sb.insert(0, sum);
            i--;
        }
        if(c!=0)
        	sb.insert(0, c);  
        return sb;
    }
}
