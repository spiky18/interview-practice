package com.leetcode;

public class LCABinaryTree {
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	//ArrayList<TreeNode> pAnc=new ArrayList<>();
	//search(root, p, pAnc );
	//ArrayList<TreeNode> qAnc=new ArrayList<>();
	//search(root, q, qAnc );
	//int small=pAnc.size()>qAnc.size()?qAnc.size():pAnc.size();
	//int i=0;
	/*TreeNode prev=null;
    while(i<small){
    	
    }*/
	if(root==null)
		return null;
	if(root==p || root==q)
		return root;
	TreeNode left=lowestCommonAncestor(root.left, p, q);
	TreeNode right=lowestCommonAncestor(root.right, p, q);
	if(left!=null && right!=null)
		return root;
	return left!=null?left:right;
    }
    
    /*public ArrayList<TreeNode> search(TreeNode root,TreeNode p,ArrayList<TreeNode> ancestors){
    	if(root==null)
    		return null;
        if(root==p){
            ancestors.add(p);
        	return ancestors;
            }
        ancestors.add(root);
        return search(root.left,p,new ArrayList(ancestors)) 
        return	search(root.right,p,new ArrayList(ancestors));
    }*/

}
