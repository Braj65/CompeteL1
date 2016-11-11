package com.trgr.careerstack95.DistinctArray;

public class NonRepeatArrayWeb {
	
	public static void main(String[] args){
		int[] arr={3, 4, 1, 3, 1, 7, 2, 2, 4};
		System.out.println(jam(arr));
	}
	
	public static int jam(int[] arr){
		int rem=0;
		
		for(int i=0;i<=arr.length-1;i++){
			rem=rem^arr[i];
		}
		return rem;
	}

}
