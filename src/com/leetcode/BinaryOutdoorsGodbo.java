package com.leetcode;
import java.util.Scanner;
//Your submission should ONLY use the following class name
public class BinaryOutdoorsGodbo
{
	public static void main(String[] args)
  {

     Scanner stdin = new Scanner(System.in);
     while(stdin.hasNext()) 
     {
         int n = stdin.nextInt();
         int k = stdin.nextInt();
         int digit = k-1;
         if(k < 1 || k > Math.pow(2,n)){
          System.out.println(-1);
          continue;
         }
          
          
         String result = retDigit(digit/2,n);
         
         System.out.println(result.charAt(digit%2));
     }
     stdin.close();
  }

  public static String retDigit(int digit,int level){
      if(level == 0)
          return "0";
      String num = retDigit(digit/2,level-1);
      if(num.charAt(digit%2) == '0')
          return "01";
      else
          return "10";
  }
}