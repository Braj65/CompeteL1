package com.trgr.careerstack91.RotatedSortArray;

public class RotatedBinarySearch {
	
	public static void main(String[] args){
		
		int[] arr={3,4,5,6,7,8,9,1,2};
		System.out.println(rotBinarySearch(arr, arr.length, 9));
		
	}
	
	public static int rotBinarySearch(int[] arr, int n, int key){
		int L=0;
		int R=n-1;
		
		while(L<=R){
			int M=L+((R-L)/2);
			if(arr[M]==key) return M;
			
			if(arr[L]<=arr[M]){
				if(arr[L]<=key && key<arr[M])
					R=M-1;
				else
					L=M+1;
			}
			else{
				if(arr[M]<key && key<=arr[R])
					L=M+1;
				else
					R=M-1;
			}
		}
		return -1;
	}

}
