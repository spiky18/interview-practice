package BlackRock;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		
		for(int i=0;i<nums.length;i++){
			int j=nums[i]-1;
			while(i+1!=j && j>=0 && j<nums.length){
				int temp=nums[j];
				nums[j]=j;
				nums[i]=temp;
				j=nums[i]-1;
			}
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=i+1){
				return i+1;
			}
			
		}
		
		
		return nums.length;
	}
	
	public static void main(String[] args) {
		int[] t1={1};
		System.out.println(firstMissingPositive(t1));
		
	}
	
	
	public void rotate(int[][] m) {
		int n=m.length-1;
		for(int i=0;i<=n/2;i++){
			swapRows(m, i, n-i);
		}
		
		for(int i=0;i<=n;i++){
			for(int j=i+1;j<=n;j++){
				int temp=m[i][j];
				m[i][j]=m[j][i];
				m[j][i]=temp;
			}
			
		}
		
		
	}
	
	public void swapRows(int[][ ]m,int r1,int r2){
		for(int i=0;i<m[0].length;i++){
			int temp=m[r1][i];
			m[r1][i]=m[r2][i];
			m[r2][i]=temp;
		}
		
		
	}
	
	
	public int[][] flipAndInvertImage(int[][] m) {
		for(int i=0;i<m.length;i++)
			flip(m,i);
		
        return m;
    }
	
	public void flip(int[][]m,int row){
		int n=m[0].length-1;
		for(int i=0;i<=n/2;i++){
			int temp=m[row][i];
			m[row][i]=1-m[row][n-i];
			m[row][n-i]=1-temp;
		}
		
	}
	
	//Changing the array
    public int findDuplicate(int[] nums) {
        int i=0;
        while(nums[i]>=0 && nums[i]<nums.length){
            if(nums[i]>0){
                nums[i]*=-1;
                i=Math.abs(nums[i]);
            }  
            
        }
        return Math.abs(i);
        
    }
}
