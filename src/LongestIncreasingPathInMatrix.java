
public class LongestIncreasingPathInMatrix {
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return 0;
		int[][] dp=new int[matrix.length][matrix[0].length];
		boolean[][] visited=new boolean[matrix.length][matrix[0].length];
		int max = 0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				dfs(matrix,dp,i,j,visited);
				if(dp[i][j]>max)
					max=dp[i][j];
			}
		}
		return max;
	}
	
	public void dfs(int[][] matrix,int[][] dp,int i,int j,boolean[][] visited){
		if(i>=matrix.length|| i<0 ||j<0|| j>=matrix[0].length)
			return ;
		if(visited[i][j]){
			return;
        }
		visited[i][j]=true;
		int u=0,l=0,r=0,d=0;
		if((i+1)<matrix.length && matrix[i][j]<matrix[i+1][j]){
			dfs(matrix, dp, i+1, j,visited);
			r=1+dp[i+1][j];
			}
		
		if((i-1)>=0 && matrix[i][j]<matrix[i-1][j]){
			dfs(matrix, dp, i-1, j,visited);
			l=1+dp[i-1][j];
			}
		
		if((j+1)<matrix[0].length && matrix[i][j]<matrix[i][j+1]){
			dfs(matrix, dp, i, j+1,visited);
			d=1+dp[i][j+1];
			}
		
		if((j-1)>=0 && matrix[i][j]<matrix[i][j-1]){
			dfs(matrix, dp, i, j-1,visited);
			u=1+dp[i][j-1];
			}
		dp[i][j]=Math.max(1,Math.max(Math.max(l, r),Math.max(u, d)));
	}
	
	public static void main(String[] args) {
		int[][] matrix={{7,7,5},{2,4,6},{8,2,0}};
		LongestIncreasingPathInMatrix obj=new LongestIncreasingPathInMatrix();
		System.out.println(obj.longestIncreasingPath(matrix));
	}
	
}
