package com.trgr.careerstack2.maxMinComparions;

public class MinCompareFindMaxMin {
	public int max;
	public int min;
	public static void main(String[] args){
		int[] arr1={5, 7, 3, 31, 2, 10, 45, 67};
		MinCompareFindMaxMin obj1=new MinCompareFindMaxMin();
		System.out.println(arr1.length);
		if(arr1[0]>arr1[1]){
			obj1.max=arr1[0];
			obj1.min=arr1[1];
		}
		else{
			obj1.min=arr1[0];
			obj1.max=arr1[1];
		}
		System.out.println(obj1.jammer(arr1, 0, 1));
	}
	
	public String jammer(int[] arr, int start, int end){
		if(end+1>=arr.length){			
			this.comp(arr, start, end);
			return max+" "+min;
		}
		else{
			this.comp(arr, start, end);
		}		
		return jammer(arr, start+2, end+2);
		
	}
	
	public void comp(int[] arr, int start, int end){
		if(arr[start]>arr[end]){
			if(arr[start]>max)
				max=arr[start];
			if(arr[end]<min)
				min=arr[end];
		}
		else {
			if(arr[end]>max)
				max=arr[end];
			if(arr[start]<min)
				min=arr[start];
		}
	}

}
