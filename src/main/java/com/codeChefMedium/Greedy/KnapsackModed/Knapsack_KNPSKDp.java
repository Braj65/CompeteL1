package com.codeChefMedium.Greedy.KnapsackModed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Knapsack_KNPSKDp {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		StringTokenizer st=new StringTokenizer(br.readLine());
		int len=Integer.parseInt(st.nextToken());
		int[] wt=new int[len+1];
		int[] val=new int[len+1];
		int W=0;
		for(int i=1;i<=len;i++){
			st=new StringTokenizer(br.readLine());
			wt[i]=Integer.parseInt(st.nextToken());
			W=W+wt[i];
			val[i]=Integer.parseInt(st.nextToken());
		}
		int[] x=knapSack(W, wt, val, val.length);
		for(int i=1;i<x.length;i++){
			pw.print(x[i]+" ");
		}
//		pw.print(knapSack(W, wt, val, val.length));
		pw.flush();
	}
	
	static int[] knapSack(int W, int wt[], int val[], int n)
	{
		int[][] posWt=new int[val.length][W+1];
		for(int i=0;i<posWt[0].length;i++){
			posWt[0][i]=0;
		}
		
		for(int i=1;i<val.length;i++){
			for(int j=0;j<W+1;j++){
				if(j<wt[i]){
					posWt[i][j]=posWt[i-1][j];
				}else{
					posWt[i][j]=max(val[i]+posWt[i-1][j-wt[i]], posWt[i-1][j]);
				}
			}
		}
		
		return posWt[val.length-1];
	}
	
	static int max(int a, int b) { return (a > b)? a : b; }

}
