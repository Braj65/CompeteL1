package com.trgr.careerstack80.IncompletepreToInorderTree;

import java.util.ArrayList;
import java.util.List;



public class PreorderToInorderBinTree {
	
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
		/*BreadthFirstWebSol bread=new BreadthFirstWebSol();
		bread.printLevelOrder(trees);*/
		List<Integer> coll=new ArrayList<Integer>();
		preOrder(trees.k, coll);
		System.out.println(coll.size()+"--");
		convert(coll);
		
	}
	
	public static void preOrder(Link k, List<Integer> coll){
		if(k==null)
			return;
		if(k.aLeft==null && k.right==null){
			System.out.println(k.data);
			coll.add(k.data);
			return;
		}
		else{
			System.out.println(k.data);
			coll.add(k.data);
			preOrder(k.aLeft, coll);
			preOrder(k.right, coll);
		}
	}
	
	public static void convert(List<Integer> coll){
		int size=coll.size();
		int i=0;
		while(size/2!=1){
			size=size/2;
			++i;
		}
		System.out.println(i);
		List<Integer> coll1=new ArrayList<Integer>();
	}



}
