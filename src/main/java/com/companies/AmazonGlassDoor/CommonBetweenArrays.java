package com.trgr.AmazonGlassDoor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CommonBetweenArrays {

	
	public static void main(String[] args){
		int[] arr1 = {4,7,3,9,2};
		int[] arr2 = {3,2,12,9,40,32,4};
		System.out.println("CommonElements : ");
		Integer[] a=findCommon(arr1, arr2);
		for(Integer s: a){
			System.out.println(s);
		}
	}
	
	public static Integer[] findCommon( int[] arr1, int[] arr2 ) {
		 
	     int[ ] arrayToHash;
	     int[ ] arrayToSearch;
	 
	     if( arr1.length < arr2.length ) {
	     arrayToHash = arr1;
	     arrayToSearch = arr2;
	     } else {
	     arrayToHash = arr2;
	     arrayToSearch = arr1;
	     }
	 
	        HashSet<Integer> intersection = new HashSet<Integer>( );
	 
	        HashSet<Integer> hashedArray = new HashSet<Integer>( );
	        for( Integer entry : arrayToHash ) {
	            hashedArray.add( entry );
	        }
	 
	        for( Integer entry : arrayToSearch ) {
	            if( hashedArray.contains( entry ) ) {
	                intersection.add( entry );
	            }
	        }
	        
	        return intersection.toArray( new Integer[ 0 ] );
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
