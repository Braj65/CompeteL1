package com.trgr.careerstack97.commonInArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonInArraysWebSol {
	public static void main(String[] args){
		int[] arr1={2, 4, 5, 8, 16, 11, 19, 18, 21, 22, 24};
		Arrays.sort(arr1);
//		int[] arr2={3, 5, 6, 9, 12, 10, 18, 15};
		int[] arr2={3, 5, 6, 9, 12, 10, 14, 16};
		Arrays.sort(arr2);
		int len1=arr1.length;
		int len2=arr2.length;
		int i=0, j=0;
		int len=len1>len2?len2:len1;
		while(i<len && j<len){
			if(arr1[i]>arr2[j]){
				i++;
			}else if(arr1[i]==arr2[j]){
				System.out.println(arr1[i]);
				++i;
			}
			else{
				j++;
			}
		}
		
	}
	
	public static void findInSortedArray(int[] arr1, int[] arr2){
		List<Integer> intersection=new ArrayList<Integer>();
		int n1=arr1.length;
		int n2=arr2.length;
		int i=0, j=0;
		while(i<n1 && j<n2){
			if(arr1[i]>arr2[j]){
				j++;
			}
			else if(arr2[j]>arr1[i]){
				i++;
			}
			else{
				intersection.add(arr1[i]);
				i++;
				j++;
			}
		}
	}
}
