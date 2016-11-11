package com.trgr.careerstack83.leafNodes;

public class LeafNodesRecurse {
	
	public static void main(String[] args){
		Node n1=new Node(5);
		n1.insert(10);
		n1.insert(9);
		n1.insert(3);
		n1.insert(14);
		n1.insert(12);
		n1.insert(22);
		n1.insert(56);
		n1.insert(12);
		n1.insert(8);
		checkLeaf(n1.k);
	}
	
	public static void checkLeaf(Link n){
		if(n==null){
			return;
		}
		if(n.aLeft==null && n.right==null){
			System.out.println(n.data);
			return;
		}
		else{
			checkLeaf(n.aLeft);
			checkLeaf(n.right);
			
		}
	}

}
