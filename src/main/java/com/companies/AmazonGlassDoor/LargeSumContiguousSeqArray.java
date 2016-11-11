package com.trgr.AmazonGlassDoor;

public class LargeSumContiguousSeqArray {
	
	public static void main(String[] args){
		int[] x={4, -9, 3, -2, 4, -12};
		System.out.println(maxSum(x));
	}
	
	public static int maxSum(int[] arr){
		int maxsum=0;
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
			if(maxsum<sum){
				maxsum=sum;
			}
			else if(sum<0){
				sum=0;
			}
		}
		return maxsum;
	}

}
