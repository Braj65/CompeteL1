package com.trgr.careerstack23.unorderArray;

public class UnorderArrayRelate {
	
	public static void main(String[] args){
		int[] arr1={1, 5, 7, 6, 3, 16, 29, 2, 7};
		int[] arr2=new int[arr1.length];
		
		for(int i=0;i<arr1.length;i++){
			int j=i+1;
			while(j<arr1.length){
				
				if(arr1[i]>arr1[j]){
					arr2[i]=arr1[j];
					break;
				}
				++j;
			}
		}
		for(int i:arr2)
			System.out.println(i);
		
	}

}
