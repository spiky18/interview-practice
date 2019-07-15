package BlackRock;

public class LC129 {

	 public int sumNumbers(TreeNode root) {
	        int sum=0;
	        helper(root, new StringBuilder(), sum);
	        return sum;
	    }
	 
	 public void helper(TreeNode root, StringBuilder prefix,int sum){
		 if(root==null)
			 return;
		 prefix.append(root.val);
		 if(root.left==null && root.right==null){
			 sum+=Integer.parseInt(prefix.toString());
		 }
		 helper(root.left, prefix, sum);
		 helper(root.right, prefix, sum);
		 prefix.deleteCharAt(prefix.length()-1);
	 }
}
