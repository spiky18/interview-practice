package BlackRock;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		int[][] memo=new int[s.length()][s.length()];
		int start=-1,end=-1,max=0;
		for(int i=0;i<s.length();i++)
			memo[i][i]=1;
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				if(s.charAt(i)==s.charAt(j)){
					if(i==j+1 || memo[i+1][j-1]>0)
						memo[i][j]=memo[i+1][j-1]+2;
					
				}
				if(memo[i][j]>max){
					start=i;
					end=j;
					max=memo[i][j];
				}
			}
		}
		
		
		return s.substring(start, end+1);
	}
	
	
}
