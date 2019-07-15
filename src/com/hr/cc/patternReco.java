package com.hr.cc;
/**
 * Check if string follows order of 
 * characters defined by a pattern or not
 * @author himan
 *
 */
public class patternReco {
	public static void  main(String[] args) {
		String input="engineers";
		String pattern="egr";
		//String[] charArray=pattern.split("");
		//System.out.println(charArray[2]);
		int[][] indexStore=searchChar(input, pattern);
		/*for(int i=0;i<pattern.length();i++){
			for(int j=0;j<input.length();j++)
				System.out.print(indexStore[i][j]);
			System.out.println();
		}*/
		
		indexStore=maxMin(indexStore);
		System.out.println(result(indexStore));
	}
	public static int[][] searchChar(String searchInput, String pattern){
		String[] charArray=pattern.split("");
		//System.out.println(charArray[2]);
		int[][] indexStore=new int[charArray.length][searchInput.length()];
		for(int i=0;i<charArray.length;i++){
			for(int j=0;j<searchInput.length();j++)
				indexStore[i][j]=searchInput.indexOf(charArray[i], j);
		}
		
		return indexStore;
	}
	public static int[][] maxMin(int[][] indexS){
		int[][] maxMinArr=new int[indexS.length][2];
		for(int i=0;i<indexS.length;i++){
			maxMinArr[i][0]=max(indexS[i]);
			maxMinArr[i][1]=min(indexS[i]);
		}
			
		return maxMinArr;
	}
	public static boolean result(int[][] arr){
		boolean flag=true;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i+1][0]<arr[i][1])
				{flag= false;
				break;}
		}
		return flag;
	}
	
	public static int max(int[] iar){
		int max=-1;
		for(int i=0;i<iar.length;i++){
			if(iar[i]>max)
				max=iar[i];
				}
		return max;
	}
	
	public static int min(int[] iar){
		int min=10000;
		for(int i=0;i<iar.length;i++){
			if(iar[i]<min && iar[i]>-1)
				min=iar[i];
				}
		return min;
	}
}
