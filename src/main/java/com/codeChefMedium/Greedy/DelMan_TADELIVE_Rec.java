package com.codeChefMedium.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DelMan_TADELIVE_Rec {
	public static Integer[] A;
	public static void main(String[] args) throws Exception {
		ClassLoader cl = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader in = new InputStreamReader(cl.getSystemResourceAsStream("com/codeChefMedium/TADELIVE.txt"));
		BufferedReader br = new BufferedReader(in);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		int size=Integer.parseInt(str.nextToken());
		int alimit=Integer.parseInt(str.nextToken());
		int blimit=Integer.parseInt(str.nextToken());
		A=new Integer[size];
		int[] B=new int[size];
		Integer[] obj=new Integer[size];
		str=new StringTokenizer(br.readLine());
		for(int i=0;i<size;i++){
			A[i]=Integer.parseInt(str.nextToken());
			obj[i]=i;
		}
		str=new StringTokenizer(br.readLine());
		for(int j=0;j<size;j++){
			B[j]=Integer.parseInt(str.nextToken());			
		}
		int sum=0;
		int temp=0;
		int subtemp=0;
		
		int[] res=new int[1];
		calc(A, B, alimit, blimit, size-1, temp, res);
		System.out.println(res[0]);
	}
	
	public static int calc(Integer[] A, int[] B, int alimit, int blimit, int size, int temp, int[] res){
		if(alimit<0 || blimit<0){
			if(alimit<0){
				temp=temp-A[size+1];
			}else{
				temp=temp-B[size+1];
			}
			return temp;
		}else if(size<0){
			if(res[0]<temp){
				res[0]=temp;
			}
			return temp;
		}
		else{
			calc(A, B, alimit-1, blimit, size-1, temp+A[size], res);
			calc(A, B, alimit, blimit-1, size-1, temp+B[size], res);			
		}
		return res[0];
	}

}

