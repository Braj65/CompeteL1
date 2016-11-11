package com.trgr.careerstack91.RotatedSortArray;

public class RotBinSearchSelf {
	
	public static void main(String[] args){	
		int[] arr={9,10,3,4,5,6,7,8};
		System.out.println(getKey(arr, arr.length, 9));		
	}
	
	public static int getKey(int[] arr, int len, int key){
		int start=0;
		int end=len-1;		
		
		while(start<=end){
			int mid=start+(end-start)/2;
			if(arr[mid]==key)
				return mid;
			
			if(arr[start]<arr[mid]){
				if(key>=arr[start] && key<arr[mid]){
					end=mid-1;
				}else{
					start=mid+1;
				}
			}else{
				if(key>arr[mid] && key<=arr[end]){
					start=mid+1;
				}else{
					end=mid-1;
				}
			}
		}
		
		return -1;
				
	}
}
