package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Fidessa1 {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
         Set<Character> set = new HashSet<Character>();
        Scanner in =new Scanner(System.in);
        String s=in.nextLine();
        in.close();
        int i=0;
        for(i=0; i<s.length();i++){
            if(!map.containsKey(s.charAt(i)))
            map.put(s.charAt(i),1);
            else
               map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }
        char ch=0;
        for(i=0; i<s.length();i++){
            if(map.get(s.charAt(i))>1)
            {ch=s.charAt(i);
             break;}
        }
        System.out.println(ch);
        
       
        
    }
}


