package com.general.trees;

public class BSTDemo {
public static void main(String[] args)
{
	
	BinaryTree btree=new BinaryTree();
	btree.insert(50);
	System.out.println("Verifying whether 50 is present"+btree.search(50));
	System.out.println("Verifying whether 0 is present"+btree.search(0));
	btree.insert(12);
	btree.insert(120);
	btree.insert(70);
	btree.insert(25);
	btree.insert(28);
	btree.insert(145);
	btree.insert(26);
	btree.insert(80);
	btree.LevelOrderTraversal();
	//btree.heightIterative();
	System.out.println("Preorder");
	btree.preOrder(btree.getRoot());
	System.out.println(btree.heightRecursive(btree.getRoot()));
	
	BinaryTree btree2=new BinaryTree();
	btree2.insert(btree2.getRoot(), 4);
	btree2.insert(btree2.getRoot(), 2);
	btree2.insert(btree2.getRoot(), 7);
	btree2.insert(btree2.getRoot(), 1);	
	System.out.println("Preorder");
	btree2.preOrder(btree2.getRoot());
	System.out.println("Verifying whether 4 is present"+btree2.search(4));
	/*System.out.println("Verifying whether 50 is present"+btree.search(50));
	System.out.println("Verifying whether 120 is present"+btree.search(120));
	System.out.println("Verifying whether 12 is present"+btree.search(12));
	System.out.println("Verifying whether 70 is present"+btree.search(70));
	System.out.println("Verifying whether 40 is present"+btree.search(40));
	System.out.println("Verifying whether 6 is present"+btree.search(6));*/
}
}
