package com.trgr.careerstack80.IncompletepreToInorderTree;

import com.trgr.careerstack46treee.breadthtree.BreadthFirstWebSol;
import com.trgr.careerstack46treee.breadthtree.Link;
import com.trgr.careerstack46treee.breadthtree.Node;

//https://www.youtube.com/watch?v=9RHO6jU--GU
public class DepthFirstInorder {
	
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
		BreadthFirstWebSol bread=new BreadthFirstWebSol();
		bread.printLevelOrder(trees);
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
