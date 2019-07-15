package BlackRock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.leetcode.TreeNode;

public class BinaryTreeTraversals {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}

		return list;
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root!=null){
			stack.push(root);
		}
		
		while(!stack.isEmpty()){
			TreeNode node=stack.pop();
			list.add(node.val);
			
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
			
		}
		
		return list;
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list=new ArrayList<>();
		Queue<TreeNode> queue=new LinkedList<>();
		if(root!=null){
			queue.add(root);
			queue.add(null);
		}
		List<Integer> currLevel=new ArrayList<>();
		while(!queue.isEmpty()){
			TreeNode node =queue.poll();
			if(node!=null){
				currLevel.add(node.val);
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
			}else{
				list.add(currLevel);
				currLevel=new ArrayList<>();
				if(!queue.isEmpty())
					queue.add(null);
				
			}
			
			
		}
		
		
		return list;
    }
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.add(root);
			queue.add(null);
			List<Integer> currLevel=new ArrayList<>();
			boolean flip=false;
			while(!queue.isEmpty()){
				TreeNode node=queue.poll();
				if(node!=null){
					currLevel.add(node.val);
					if(node.left!=null)
						queue.add(node.left);
					if(node.right!=null)
						queue.add(node.right);
				}else{
					if(flip)
						Collections.reverse(currLevel);
					flip=!flip;
					list.add(currLevel);
					currLevel=new ArrayList<>();
				}
			}
		}
		return list;
	}
	
	public String serialize(TreeNode root) {
		ArrayList<Integer> list=new ArrayList<>();
		serHelper(root, list);
		System.out.println(list.toString());
		return list.toString();
	}
	
	public void serHelper(TreeNode root, ArrayList<Integer> list){
		if(root!=null){
			list.add(root.val);
			serHelper(root.left, list);
			serHelper(root.right, list);
		}else{
			list.add(Integer.MIN_VALUE);
		}
	}
	
	public TreeNode deserialize(String data) {
		String[] dataList=data.substring(1,data.length()-1).split(",");
		int[] list=new int[dataList.length];
		for(int i=0;i<dataList.length;i++){
			list[i]=Integer.parseInt(dataList[i].trim());
		}
		
        return deSerHelper(list);
    }
	int index=0;
	public TreeNode deSerHelper(int[] list){
		if(list.length==index || list[index]==Integer.MIN_VALUE){
			index++;
			return null;
		}
		TreeNode root=new TreeNode(list[index]);
		index++;
		root.left=deSerHelper(list);
		root.right=deSerHelper(list);
		
		return root;
	}
	
}
