package com.trgr.AmazonGlassDoor.binTree;

public class CousinsInBinTree {
	
	public static void main(String[] args){
		int[] arr={4, 5, 8, 2, 9, 12, 14, 18, 22, 56, 78};
		Node root=balancer(arr, 0, arr.length-1);
		System.out.println(root.data);
		printLeafs(root);
	}
	
	public static Node balancer(int[] arr, int start, int end){
		if(start>end)
			return null;
		else{
			int mid=(start+end)/2;
			Node n=new Node(arr[mid]);
			n.aLeft=balancer(arr, start, mid-1);
			n.right=balancer(arr, mid+1, end);
			return n;
		}
	}
	
	public static void printLeafs(Node root){
		if(root==null)
			return;
		else if(root.aLeft==null && root.right==null){
			System.out.println(root.data);
			return;
		}
		else{
			printLeafs(root.aLeft);
			printLeafs(root.right);
		}
	}
	
	public static void printLevels(Node aLeft, Node right){
		if(aLeft==null && right==null)
			return;
		else{
			
		}
	}

}