package com.trgr.careerstack15.quickSort;

public class QuickSort {
	public static int pIndex;
	public static void main(String[] args){
		int[] arr={5, 14, 18, 12, 7, 3, 1, 2, 16, 4};
		quicker(arr, 0, arr.length-1);
		for(int x: arr){
			System.out.println(x);
		}
	}
	
	public static void quicker(int[] arr, int start, int end){
		if(start<end){
			pIndex=partition(arr, start, end);
			quicker(arr, start, pIndex-1);
			quicker(arr, pIndex+1, end);
		}
	}
	
	public static int partition(int[] arr, int start, int end){
		int pivot=arr[end];
		int pindex=start;
		for(int i=start; i<end-1;i++){
			if(arr[i]<=pivot){
				swap(arr, i, pindex);
				++pindex;
			}
		}
		swap(arr, pindex, end);
		return pindex;
	}
	
	public static void swap(int[] arr, int pos1, int pos2){
		int temp=arr[pos1];
		arr[pos1]=arr[pos2];
		arr[pos2]=temp;
	}
}
