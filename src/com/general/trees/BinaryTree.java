package com.general.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private BinaryTreeNode root;
	

	/**
	 * @return the root
	 */
	public BinaryTreeNode getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode insert(int data) {
		BinaryTreeNode node = new BinaryTreeNode(data);
		BinaryTreeNode searchNode = root;
		// BinaryTreeNode cmpNode=root;
		if (root == null) {
			root = node;
		}
		while (searchNode != null) {
			if (searchNode.getData() > data) {
				if (searchNode.getLeft() != null)
					searchNode = searchNode.getLeft();
				else
					searchNode.setLeft(node);
			} else if (searchNode.getData() < data) {
				if (searchNode.getRight() != null)
					searchNode = searchNode.getRight();
				else
					searchNode.setRight(node);
			} else
				break;
		}
		return root;

	}

	public BinaryTreeNode insert(BinaryTreeNode root,int data){
		if(root==null)
        {
        root=new BinaryTreeNode(data);
//        root.data=value;
//        root.left=null;
//        root.right=null;
        this.root=root;
        return root;
    }
    else if(root.getData()==data)
        return root;
   else if(root.getData()>data){
	   root.setLeft(insert(root.getLeft(),data));
	   this.root=root;
       return root;
   }
    else
    	root.setRight(insert(root.getRight(),data));
		this.root=root;
		return root;
	}
	public boolean search(int data) {
		BinaryTreeNode searchNode = root;
		boolean found = false;
		if (root == null) {
			return found;
		}
		while (searchNode != null) {
			if (searchNode.getData() > data) {
				if (searchNode.getLeft() != null)
					searchNode = searchNode.getLeft();
				else {
					found = false;
					break;
				}

			} else if (searchNode.getData() < data) {
				if (searchNode.getRight() != null)
					searchNode = searchNode.getRight();
				else {
					found = false;
					break;
				}

			} else {
				found = true;
				break;
			}
		}
		return found;
	}

	public BinaryTreeNode delete(int data) {
		return root;
	}

	public void preOrder(BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root.getData());
			preOrder(root.getLeft());
			
			preOrder(root.getRight());
		}

	}

	public void LevelOrderTraversal() {
		ArrayList<Integer> elements = new ArrayList<Integer>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		// elements.add(root.getData());
		
		// BinaryTreeNode countNode=root;
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			elements.add(temp.getData());
			if (temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if (temp.getRight() != null)
				queue.offer(temp.getRight());
		}
		for (int data : elements) {
			System.out.println(data);
		}
		Object[] ar=elements.toArray();
	}

	public int heightRecursive(BinaryTreeNode root){
		int h=0;
		if(root!=null){
			if(root.getLeft()==null && root.getRight()==null)
                return 0;
			int hl=1+heightRecursive(root.getLeft());
			int hr=1+heightRecursive(root.getRight());
			h=hl>hr?hl:hr;
		}
		return h;
		
	}
	public void heightIterative() {
		ArrayList<Integer> elements = new ArrayList<Integer>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		// elements.add(root.getData());
		// BinaryTreeNode countNode=root;
		int h = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			elements.add(temp.getData());
			if (temp != null) {
				if (temp.getLeft() == null && temp.getRight() == null) {
					continue;
				} else if (temp.getLeft() != null && temp.getRight() != null) {
					queue.offer(temp.getLeft());
					queue.offer(temp.getRight());
					h++;
				} else if (temp.getLeft() != null && temp.getRight() == null) {
					queue.offer(temp.getLeft());
					h++;
				} else if (temp.getLeft() == null && temp.getRight() != null) {
					queue.offer(temp.getRight());
					h++;
				}
			}
		}
		System.out.println("height is " + h);
	}
	
	public int countNodes(BinaryTreeNode root){
		if(root==null)
			return 0;
		return 1+countNodes(root.getLeft())+countNodes(root.getRight());
		
	}
	
	public List<List<Integer>> levelOrderBottom(BinaryTreeNode root) {
        Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
        Stack<List<Integer>> stk= new Stack<>();
        q.offer(root);
        q.offer(null);
        List<Integer> elm=new ArrayList<Integer>();
        while(!q.isEmpty()){
        	BinaryTreeNode temp =q.poll();
        	if(temp!=null){
        		elm.add(temp.getData());
        		if(temp.getLeft()!=null);
        			q.offer(temp.getLeft());
        		if(temp.getRight()!=null)
        			q.offer(temp.getRight());
        	}
        	else{
        		if(!q.isEmpty()){
        			List<Integer> tmp=new ArrayList<Integer>(elm);
        			q.offer(null);
        			stk.add(tmp);
        			elm.clear();
        			
        		}
        	}
        }
        /*for(Integer i : elm){
        	if(i!=null)
        		//stk.push(arg0)
        }*/
        Collections.reverse(stk);
        return stk;
        
    }
}
