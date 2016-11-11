package com.careerstack.careerstack15.quickSort;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] inarr={8, 4, 7, 6, 2, 5, 3, 1};
		MergeSort x=new MergeSort();
		x.sort(inarr);
		for(int f:inarr){
			System.out.print(f+" ");
		}
		System.out.print("\n");
		
	}
	
	public void sort(int[] inarr){
		if(inarr.length<2){
			return;
		}
		else{
			int mid=inarr.length/2;
			int[] left=new int[mid];
			int[] right=new int[inarr.length-mid];
			for(int i=0;i<=mid-1;i++){
				left[i]=inarr[i];
			}
			for(int j=mid;j<inarr.length;j++){
				right[j-mid]=inarr[j];
			}
			sort(left);
			sort(right);
			merge(left, right, inarr);
		}
	}
	
	public void merge(int[] left, int[] right, int[] inarr){
		int nl=left.length;
		int nr=right.length;
		int i = 0, j =0,k=0;
		while(i<nl && j<nr){
			if (left[i]<=right[j]){
				inarr[k]=left[i];
				i++;
			}
			else{
				inarr[k]=right[j];
				j++;
				
			}
			k++;
		}
		while(i<nl){
			inarr[k]=left[i];
			k++;
			i++;
		}
		while(j<nr){
			inarr[k]=right[j];
			k++;
			j++;
		}
	}

}
