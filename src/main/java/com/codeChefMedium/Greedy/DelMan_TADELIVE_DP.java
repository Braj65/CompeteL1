package com.codeChefMedium.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DelMan_TADELIVE_DP {

	public static void main(String[] args) throws Exception {
		ClassLoader cl = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader in = new InputStreamReader(cl.getSystemResourceAsStream("com/codeChefMedium/TADELIVE.txt"));
		BufferedReader br = new BufferedReader(in);
		// BufferedReader br=new BufferedReader(new
		// InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(str.nextToken());
		int alimit = Integer.parseInt(str.nextToken());
		int blimit = Integer.parseInt(str.nextToken());
		int[] A = new int[size];
		int[] B = new int[size];
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			A[i] = Integer.parseInt(str.nextToken());
		}
		str = new StringTokenizer(br.readLine());
		for (int j = 0; j < size; j++) {
			B[j] = Integer.parseInt(str.nextToken());
		}
		int[][] memo=new int[size+1][alimit+1];
		for(int i=0;i<=size;i++){
			for(int j=0;j<=alimit;j++){
				memo[i][j]=-1;
			}
		}
		int res=0;
		for(int i=1;i<=1;i++){
			for(int j=0;j<=i;j++){
				dp(i, j, A, B, res, memo);
			}
		}
		for(int i=2;i<=size;i++){
			for(int j=0;j<=alimit;j++){
				if(0<=i-j && i-j<=blimit){
					res=dp1(i, j, blimit, A, B, res, memo);
				}else{
					memo[i][j]=-1;
				}
			}
		}
		System.out.println(res);

	}

	public static void dp(int tot, int a, int[] A, int[] B, int res, int[][] memo){
		if(a>=1){
			for(int i=0;i<a;i++){
				memo[tot][a]=A[i];
			}
		}if(tot-a>=1){
			memo[tot][a]=B[0];
		}
	}
	
	public static int dp1(int tot, int a, int blimit, int[] A, int[] B, int res, int[][] memo){
		int i=tot-1;
		int temp=res;
		if(a>0){
			memo[tot][a]=Math.max(memo[i][a-1]+A[i], memo[i][a]+B[i]);
			res=res>memo[tot][a]?res:memo[tot][a];
		}else{
			if(tot<=blimit){
				memo[tot][a]=memo[i][a]+B[i];
				res=res>memo[tot][a]?res:memo[tot][a];
			}			
		}
		return res;
		
	}

}
