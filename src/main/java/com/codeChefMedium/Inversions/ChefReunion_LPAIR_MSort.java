package com.codeChefMedium.Inversions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ChefReunion_LPAIR_MSort {

	int count=0;
	public static void main(String[] args) throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(in.readLine());
		int i=0;
		int[] inarr=new int[t];
		while(t-->0){
			inarr[i]=Integer.parseInt(in.readLine().split(" ")[1]);
			i++;
		}
		ChefReunion_LPAIR_MSort x=new ChefReunion_LPAIR_MSort();
		x.sort(inarr);
		for(int f:inarr){
			System.out.print(f+" ");
		}
		System.out.print("\n");
		System.out.println(x.count);
		
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
				count=count+nl-i;
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
