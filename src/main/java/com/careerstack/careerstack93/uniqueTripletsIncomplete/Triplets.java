package com.trgr.careerstack93.uniqueTripletsIncomplete;

import java.util.Arrays;

public class Triplets {
	
	public static void main(String[] args){
		int[] arr1={-1, 0, 1, 2, -1, -4};
		Arrays.sort(arr1);
		for(int i=0;i<arr1.length;i++){
			triple(arr1, arr1[i], i+1, arr1.length-1);
		}
	}
	
	public static void triple(int[] arr, int cons, int start, int end){
		if(start-end==0 || start>end)
			return;
		else if(cons+arr[start]+arr[end]<0){
				triple(arr, cons, start+1, end);
			}
		else if(cons+arr[start]+arr[end]>0){
				triple(arr, cons, start, end-1);
			}
		else if(cons+arr[start]+arr[end]==0){
			System.out.println("Found "+cons+" "+arr[start]+" "+arr[end]);
			triple(arr, cons, start+1, end-1);
			return;
		}
				
	}

}
