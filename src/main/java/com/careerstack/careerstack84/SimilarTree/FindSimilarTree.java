package com.trgr.careerstack84.SimilarTree;

public class FindSimilarTree {
	
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
		Node n2=new Node(5);
		n2.insert(10);
		n2.insert(9);
		n2.insert(3);
		n2.insert(14);
		n2.insert(12);
		n2.insert(22);
		n2.insert(56);
		n2.insert(12);
		n2.insert(8);
		System.out.println(comparer(n1.k, n2.k));
	}
	
	public static boolean comparer(Link k1, Link k2){
		if(k1==null && k2==null)
			return true;
		if(k1==null || k2==null)
			return false;
		if(k1.data!=k2.data){
			return false;
		}
		else{
			return (comparer(k1.aLeft, k2.aLeft) && comparer(k1.right, k2.right));
		}
		
	}

}
