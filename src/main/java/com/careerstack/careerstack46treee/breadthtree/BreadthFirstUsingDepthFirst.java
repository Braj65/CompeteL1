package com.careerstack.careerstack46treee.breadthtree;

import java.util.Arrays;


public class BreadthFirstUsingDepthFirst {
	
	public static void main(String[] args){
		int[] arr1={12, 3, 23, 56, 22, 67, 31, 55, 90};
		Arrays.sort(arr1);
		Link root=balanceTree(arr1, 0, arr1.length-1);
		System.out.println(root.data+" Next");
		printLevelOrder(root);
		
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
	
	public static void printLevel(Link k, int level){
		if(k==null)
			return;
		if(level==1)
			System.out.println(k.data+" ");
		else{
			printLevel(k.aLeft, level--);
			printLevel(k.right, level--);
		}
	}
	
	public static void printLevelOrder(Link k){
		int height=maxDepth(k);
		System.out.println("Height "+height);
		for(int level=1;level<=height;level++){
			printLevel(k, level);
			System.out.println("Next Level");
		}
	}
	
	
	public static int maxDepth(Link root){
		if(root==null)
			return 0;
		else{
			return(1+Math.max(maxDepth(root.aLeft), maxDepth(root.right)));
		}
	}

}
