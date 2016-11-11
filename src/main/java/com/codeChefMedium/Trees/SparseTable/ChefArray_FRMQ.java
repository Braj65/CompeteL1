package com.codeChefMedium.Trees.SparseTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChefArray_FRMQ {
	
	public static void main(String[] args) throws Exception {
		Class cls=Thread.currentThread().getClass();
		InputStreamReader in=new InputStreamReader(cls.getResourceAsStream("/com/codeChefMedium/FRMQ.txt"));	
		BufferedReader br=new BufferedReader(in);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		int size = Integer.parseInt(str.nextToken());
		long[] input = new long[size];
		str = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < size; i++) {
			input[i] = Long.parseLong(str.nextToken());
		}
		int m=logFunc(input.length)+1;
		str = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(str.nextToken());
		int x1 = Integer.parseInt(str.nextToken());
		int y1 = Integer.parseInt(str.nextToken());
		
		
		
		int[][] sparse=construct(input, m, size);
		int ans=0;
		if(y1<x1){
			ans=ans+rangeMaxQuery(input, sparse, y1, x1);
		}else{
			ans=ans+rangeMaxQuery(input, sparse, x1, y1);
		}
		for(int i=2;i<=M;i++){
			x1=(x1+7)%(size-1);
			y1=(y1+11)%size;
			if(y1<x1){
				ans=ans+rangeMaxQuery(input, sparse, y1, x1);
			}else{
				ans=ans+rangeMaxQuery(input, sparse, x1, y1);
			}			
		}
		System.out.println(ans);		
	}
	
	public static int[][] construct(long[] input, int m, int n){
		int[][] sparse=new int[m][n];
		for(int i=0;i<n;i++){
			sparse[0][i]=i;
		}
		long a=0, b=0;
		//switching the rows to columns compared to a conventional sparse table
		for(int i=1;(1<<i)<=n;i++){
			for(int j=0;(j+(1<<i)-1)<n;j++){
				a=sparse[i-1][j];
				b=sparse[i-1][j+(1<<(i-1))];
				if(input[(int) a]>input[(int) b]){
					sparse[i][j]=(int)a;
				}else{
					sparse[i][j]=(int)b;
				}
			}
		}
		return sparse;
	}
	
	public static int rangeMaxQuery(long[] input, int[][] sparse, int low, int high){
		int len=high-low+1;
		int k=logFunc(len);
		long break1=input[sparse[k][low]];
		long break2=input[sparse[k][low+len-(1<<k)]];
		return Math.max((int)break1, (int)break2);		
	}
	
	public static int logFunc(int N){
		return 31-Integer.numberOfLeadingZeros(N);
	}

}
