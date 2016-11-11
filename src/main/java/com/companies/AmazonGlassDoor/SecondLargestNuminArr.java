package com.trgr.AmazonGlassDoor;

public class SecondLargestNuminArr {
	
	public static void main(String[] args){
		int[] arr={1, 23, 47, 81, 92, 88, 52, 48, 56, 66, 65, 76, 71, 85,
                49, 53, 56, 61, 65, 84};
		int largest=0;
		int secondLargest=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>largest){
				largest=arr[i];
			}
			if(arr[i]>secondLargest && arr[i]<largest){
				secondLargest=arr[i];
			}
		}		
		System.out.println(largest+" "+secondLargest);
	}
	
	public static void webSol(int[] arr){
		int largest=arr[0];
		int secondLargest=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>largest){
				secondLargest=largest;
				largest=arr[i];
			}
			else if(arr[i]>secondLargest){
				secondLargest=arr[i];				
			}
		}
	}

}
