package com.trgr.AmazonGlassDoor;

public class KSizeSubsetsOfArray {
	
	public static void main(String[] args){
		int A[] = { 1, 2, 3, 4, 5 };
		boolean[] B = new boolean[A.length];
		KSizeSubsetsOfArray i = new KSizeSubsetsOfArray();
		i.subset(A, 3, 0, 0, B);
	}
	
	public void subset(int[] arr, int k, int start, int currLen, boolean[] used){
		if (currLen == k) {
			for (int i = 0; i < arr.length; i++) {
				if (used[i] == true) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		if (start == arr.length) {
			return;
		}
		// For every index we have two options,
		// 1.. Either we select it, means put true in used[] and make currLen+1
		used[start] = true;
		subset(arr, k, start + 1, currLen + 1, used);
		// 2.. OR we dont select it, means put false in used[] and dont increase
		// currLen
		used[start] = false;
		subset(arr, k, start + 1, currLen, used);
	}

}
