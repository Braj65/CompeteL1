package com.trgr.careerstack46treee.depthtree;

import com.trgr.careerstack46treee.breadthtree.BreadthFirstWebSol;
import com.trgr.careerstack46treee.breadthtree.Link;
import com.trgr.careerstack46treee.breadthtree.Node;

public class DepthFirstPostorder {
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
		postOrder(trees.k);
	}
	
	public static void postOrder(Link k){
		if(k==null)
			return;
		if(k.aLeft==null && k.right==null){
			System.out.println(k.data);
			return;
		}
		else{
			postOrder(k.aLeft);
			postOrder(k.right);
			System.out.println(k.data);
		}
	}
}
