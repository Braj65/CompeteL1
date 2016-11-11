package com.careerstack.careerstack46treee.BinSearchTree;

import java.util.Arrays;



//http://stackoverflow.com/questions/16028070/binary-search-tree-bst

public class AnotherBinSearchTree {
	public static void main(String[] args){
		int[] arr1={12, 3, 23, 56, 22, 67, 31, 55, 90};
		Arrays.sort(arr1);
		Link root=balanceTree(arr1, 0, arr1.length-1);
		System.out.println(root.data);
		inOrder(root);
	}
	
	public static Link balanceTree(int[] arr, int begin, int end){
		if(begin>end)
			return null;
		int mid=(begin+end)/2;
		Link n=new Link(arr[mid]);
		n.aLeft=balanceTree(arr, begin, mid-1);
		n.right=balanceTree(arr, mid+1, end);
		return n;		
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
