package com.trgr.AmazonGlassDoor.binTree;

import java.util.Arrays;

public class TargetSumInPaths {
	
	public static void main(String[] args){
		int[] arr1={12, 3, 23, 56, 22, 67, 31, 55, 90};
		Arrays.sort(arr1);
		Node root=balanceTree(arr1, 0, arr1.length-1);
		System.out.println(root.data);
		
		if (haspathSum(root, 26)) {
            System.out.println("There is a root to leaf path with sum " + 26);
        } else {
            System.out.println("There is no root to leaf path with sum " + 26);
        }
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
	
	public static boolean haspathSum(Node node, int sum) {
        if (node == null) {
            return (sum == 0);
        } else {
            boolean ans = false;
 
            /* otherwise check both subtrees */
            int subsum = sum - node.data;
            if (subsum == 0 && node.aLeft == null && node.right == null) {
                return true;
            }
            if (node.aLeft != null) {
                ans = ans || haspathSum(node.aLeft, subsum);
            }
            if (node.right != null) {
                ans = ans || haspathSum(node.right, subsum);
            }
            return ans;
        }
    }	


}
