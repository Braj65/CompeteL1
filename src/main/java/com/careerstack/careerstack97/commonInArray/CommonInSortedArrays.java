package com.trgr.careerstack97.commonInArray;

import java.util.Arrays;

public class CommonInSortedArrays {
	
	public static void main(String[] args){
//		int[] arr1={2, 4, 5, 8, 16, 11, 19, 18, 21, 22, 24};
		int[] arr1={2, 2, 2, 8, 16};
		Arrays.sort(arr1);
//		int[] arr2={3, 5, 6, 9, 12, 10, 18, 15};
//		int[] arr2={3, 5, 6, 9, 12, 10, 14, 16};
		int[] arr2={2, 2, 5, 16};
		Arrays.sort(arr2);
		
		int len1=arr1.length;
		int len2=arr2.length;
		
		int len=len1>len2?len2:len1;
		int temp=0;
		boolean stat=true;
		if(arr1[0]>arr2[0]){
			temp=arr1[0];
			stat=true;
		}else{
			temp=arr2[0];
			stat=false;
		}
		for(int i=1, j=1;i<len && j<len;){
			if(stat){
				if(temp<arr2[j]){
					temp=arr2[j];
					stat=false;
					j++;
				}
				else if(temp==arr2[j]){
					System.out.println("Match "+temp);
					stat=false;
					j++;
				}
				if(stat==true){
					++j;
					continue;					
				}
					
				if(temp<arr1[i]){
					temp=arr1[i];
					stat=true;
					i++;
				}
				else if(temp==arr1[i]){
					System.out.println("Match "+temp);
					stat=true;
					i++;
				}
			}
			else{
				if(temp<arr1[i]){
					temp=arr1[i];
					stat=true;
					i++;
				}
				else if(temp==arr1[i]){
					System.out.println("Match "+temp);
					stat=true;
					i++;
				}
				if(stat==false){
					i++;
					continue;
				}
					
				if(temp<arr2[j]){
					temp=arr2[j];
					stat=false;
					j++;
				}
				else if(temp==arr2[j]){
					System.out.println("Match "+temp);
					stat=false;
					j++;
				}
			}
		}
		
		
		
	}

}
