package com.trgr.careerstack46treee.numberOfNodes;

public class Number_of_Nodes {
	
	public static void main(String[] args){
		Node x=new Node(2);
		System.out.println("The size of binary tree is : "
                + Number_of_Nodes.size(x));
	}
	
	public static int size(Node node){
		if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
	}

}

class Node{
	Node left;
	Node right;
	int data;
	
	public Node(int d){
		data=d;
	}
	
}
