package com.trgr.AmazonGlassDoor.binTree;

import java.util.Arrays;

public class MaximumPathProb {
	
	public static void main(String[] args){
		int[] arr1={12, 3, 23, 56, 22, 67, 31, 55, 90};
		Arrays.sort(arr1);
		Node root=balanceTree(arr1, 0, arr1.length-1);
		System.out.println(root.data);
		System.out.println(calculateSum(root, 0));
	}
	
	public static Node balanceTree(int[] arr, int begin, int end){
		if(begin>end)
			return null;
		int mid=(begin+end)/2;
		Node n=new Node(arr[mid]);
		n.aLeft=balanceTree(arr, begin, mid-1);
		n.right=balanceTree(arr, mid+1, end);
		return n;		
	}
	
	public static int calculateSum(Node root, int max) {
		if (root == null)
			return 0;
	 
		int left = calculateSum(root.aLeft, max);
		int right = calculateSum(root.right, max);
	 
		int current = Math.max(root.data, Math.max(root.data + left, root.data + right));
	 
//		max = Math.max(max, Math.max(current, left + root.data + right));
	 
		return current;
	}

}
class Node{
	public Node aLeft;
	public int data;
	public Node right;
	public Node aBefore;
	
	public Node(int d1) {
		this.data=d1;
	}
}
