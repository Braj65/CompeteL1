package com.trgr.careerstack46treee.BinSearchTree;


public class MyBinSearchTree {
	
	public static void main(String[] args){
		Node trees=new Node(5);
		trees.insert(10);
		trees.insert(9);
		trees.insert(3);
		trees.insert(14);
		trees.insert(12);
		trees.insert(22);
		trees.insert(56);
		trees.insert(12);
		trees.insert(8);
		
		inOrder(trees.k);		
		
	}
	
	
	
	public static void inOrder(Link k){
		if(k==null)
			return;
		if(k.aLeft==null && k.right==null){
			System.out.println(k.data);
			return;
		}
		else{
			inOrder(k.aLeft);
			System.out.println(k.data);
			inOrder(k.right);
		}
	}

}
