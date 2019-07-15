package com.leetcode;

public class IsSubTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s==null && t==null)
    		return true;
    	if(s==null || t==null)
    		return false;
    	boolean isSame=false;
		if(s.val==t.val)
			isSame=isSameTree(s, t);
		
       return isSame || isSubtree(s.left, t) || isSubtree(s.right, t); 
    }
    
    public boolean isSameTree(TreeNode s, TreeNode t){
    	if(s==null && t==null)
    		return true;
    	if(s==null || t==null)
    		return false;
    	return (s.val==t.val) && isSameTree(s.left,t.left) && isSameTree(s.right, t.right); 
    }
}
