package com.leetcode;

public class StringIterator {
	int cursor=-1; 
	StringBuilder sb=new StringBuilder();
    public StringIterator(String compressedString) {
        int i=0;
        while(i<compressedString.length()){
        	char ch=compressedString.charAt(i);
        	i+=1;
        	StringBuilder num=new StringBuilder();
        	while(!Character.isLetter(compressedString.charAt(i))){
        		num.append(compressedString.charAt(i));
        		i++;
        	}
        	int rep=Integer.parseInt(num.toString()),k=0;
        	System.out.println(rep);
        	while(k<rep){	
        		sb.append(ch);k++;}
        }
        
        System.out.println(sb.toString());
    }
    
    public char next() {
    	cursor++;
       if(cursor<sb.length()){
    	   return sb.charAt(cursor);
       }
       Character myChar = null;
       return myChar;
    }
    
    public boolean hasNext() {
        return cursor!=sb.length();
    }
}
