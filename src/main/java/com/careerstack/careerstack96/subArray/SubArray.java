package com.trgr.careerstack96.subArray;

public class SubArray {
	
	public static void main(String[] args){
		int[] arr1={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		/*int start=2;
		int length=3;
		int dest=6;
		
		for(int i=start;i<start+length;i++){
			arr1[dest++]=arr1[i];
		}*/
		
		//start from behind
		/*int start=3;
		int length=5;
		int dest=4;
		
		for(int i=start+length-1;i>=start;i--){
			arr1[i+dest-start]=arr1[i];
		}*/
		
		//start from begining
		int start=4;
		int length=5;
		int dest=2;
		
		for(int i=start;i<start+length;i++){
			arr1[dest++]=arr1[i];
		}
		
		for(int x:arr1){
			System.out.println(x);
		}
		
	}

}
