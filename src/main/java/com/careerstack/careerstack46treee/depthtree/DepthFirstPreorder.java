package com.trgr.careerstack46treee.depthtree;

import com.trgr.careerstack46treee.breadthtree.BreadthFirstWebSol;
import com.trgr.careerstack46treee.breadthtree.Link;
import com.trgr.careerstack46treee.breadthtree.Node;

public class DepthFirstPreorder {
	
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
		trees.insert(13);
		trees.insert(114);
		trees.insert(112);
		trees.insert(122);
		trees.insert(156);
		trees.insert(112);
		trees.insert(18);
		BreadthFirstWebSol bread=new BreadthFirstWebSol();
		bread.printLevelOrder(trees);
		preOrder(trees.k);
	}
	
	public static void preOrder(Link k){
		if(k==null)
			return;
		if(k.aLeft==null && k.right==null){
			System.out.println(k.data);
			return;
		}
		else{
			System.out.println(k.data);
			preOrder(k.aLeft);
			preOrder(k.right);
		}
	}

}
