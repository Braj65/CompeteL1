package com.trgr.AmazonGlassDoor;

//the concept with this is same as with "Commonbetweenarrays.java" program except that the
//length of array A is big enough to accomodate B array as well
public class MergeSortedArrays {
	public static void main(String[] args){
		int[] B={4, 16, 8, 12, 54, 28,};
		int[] A=new int[]{34, 2, 65, 12, 8, 44, 0, 0, 0, 0, 0, 0};
		
		merge(A, A.length, B, B.length);
		
	}
	
	public static void merge(int[] a, int m, int[] b, int n){
		while(m>0 && n>0){
			if(a[m-1]>b[n-1]){
				a[m+n-1]=a[m-1];
				m--;
			}
			else{
				a[m+n-1]=b[n-1];
				n--;
			}
		}
		
		while(n>0){
			a[m+n-1]=b[n-1];
			n--;
		}
	}
}
