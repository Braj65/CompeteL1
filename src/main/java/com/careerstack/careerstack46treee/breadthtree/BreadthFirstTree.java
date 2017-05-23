package com.careerstack.careerstack46treee.breadthtree;


public class BreadthFirstTree {

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
		for(Link k:trees.var){
			System.out.println(k.data);
		}
	}

}
