import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	/*public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		 int number = in.nextInt();
		 int max=(int) Math.sqrt(number);
		 int sum=0;
		 for(int i=1;i<=max;i++){
			 for(int j=i;j<=max;j++){
				 for(int k=j;k<=max;k++){
					 if((i*i+j*j+k*k)==number)
						 sum+=i+j+k;
			 }
		 }
		 }
		 
		    in.close();
		    System.out.println(sum);
	}*/
	public static void main(String[] args) {
		
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		
	}
	
	/*public static void fillMap(HashMap<String, String[]> map,String line){
		String[] splitArr=line.split(" ");
		String[] keyArr=new String[Integer.parseInt(splitArr[1])];
		int j=0;
		for(int i=2;i<splitArr.length;i++){
			keyArr[j]=splitArr[i];
			j++;
		}
		map.put(splitArr[0], keyArr);
	}*/

	
	 public static String minWindow(String s, String t) {
		 HashMap<Character,Integer> tFreq=calcFreq(t);
		 int len=t.length();
		 int left=0,right=0,min=Integer.MAX_VALUE;
		 String result="";
		 while(right<s.length()){
			 if(tFreq.containsKey(s.charAt(right)) ){
				 if(tFreq.get(s.charAt(right))>0)
				 len--;
				 int freq=tFreq.get(s.charAt(right))-1;
				 
				 tFreq.put(s.charAt(right), freq);
				 
			 }
			 while(len==0){
				if (min > right - left) {
					min=right-left+1;
					System.out.println(left+" "+right);
					result = s.substring(left, right + 1);
				}
				 if(tFreq.containsKey(s.charAt(left))){
					 
					 tFreq.put(s.charAt(left),tFreq.get(s.charAt(left))+1);
					 if(tFreq.get(s.charAt(left))>0)
						 len++;
					 
				 }
				 left++;
			 }
			 
			 right++;
		 }
		 
		 
	        return result;
	    }
	    
	    public static HashMap<Character,Integer> calcFreq(String s){
	        HashMap<Character,Integer> map=new HashMap<>();
	        
	        for(char ch : s.toCharArray()){
	            map.put(ch,map.getOrDefault(ch, 0)+1);
	        }
	        
	        return map;
	        
	    }
	    
	    
	
}
