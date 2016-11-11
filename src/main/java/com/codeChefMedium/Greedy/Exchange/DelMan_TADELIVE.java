package com.codeChefMedium.Greedy.Exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DelMan_TADELIVE {
	static Integer diff[]=null;
	public static void main(String[] args) throws Exception {
		ClassLoader cl=Thread.currentThread().getContextClassLoader();
		InputStreamReader in=new InputStreamReader(cl.getSystemResourceAsStream("com/codeChefMedium/TADELIVE.txt"));
		BufferedReader br=new BufferedReader(in);
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		int size=Integer.parseInt(str.nextToken());
		int alimit=Integer.parseInt(str.nextToken());
		int blimit=Integer.parseInt(str.nextToken());
		int[] A=new int[size];
		int[] B=new int[size];
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			A[i] = Integer.parseInt(str.nextToken());
		}
		str = new StringTokenizer(br.readLine());
		for (int j = 0; j < size; j++) {
			B[j] = Integer.parseInt(str.nextToken());
		}
		diff=new Integer[size];
		Integer[] obj=new Integer[size];
		for(int i=0;i<size;i++){
			diff[i]=Math.abs(A[i]-B[i]);
			obj[i]=i;
		}
		Arrays.sort(obj, new ValComparator());
		int aorders=0;
		int borders=0;
		int tots=0;
		for(int k=size-1;k>=0;k--){
			if(A[obj[k]]>B[obj[k]]){
				if(aorders+1<=alimit){
					++aorders;
					tots=tots+A[obj[k]];
				}else{
					++borders;
					tots=tots+B[obj[k]];
				}
			}else{
				if(borders+1<=blimit){
					++borders;
					tots=tots+B[obj[k]];
				}else{
					++aorders;
					tots=tots+A[obj[k]];
				}
			}
		}		
		System.out.println(tots);		
	}
	
	static class ValComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return diff[o1].compareTo(diff[o2]);
		}
		
	}

}
