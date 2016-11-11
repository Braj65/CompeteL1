package com.codeChefMedium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class OnlineShop_COUPON {
	
	public static void main(String[] args) throws Exception {
		OnlineShop_COUPON oc=new OnlineShop_COUPON();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int i=Integer.parseInt(st.nextToken());
		int j=Integer.parseInt(st.nextToken());
		int[][] cost=new int[i][j];
		int[][] disc=new int[i][j];
		for(int a=0;a<i;a++){
			st=new StringTokenizer(br.readLine());
			for(int b=0;b<j;b++){
				cost[a][b]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int a=0;a<i;a++){
			st=new StringTokenizer(br.readLine());
			for(int b=0;b<j;b++){
				disc[a][b]=Integer.parseInt(st.nextToken());
			}
		}
		
		oc.getMM(cost, disc, 1, 1, 0, 1, -1);
		
	}
	
	/*public int getMin(int[][] cost, int[][] disc, int i, int j, int val){
		if(i<0 || j<0){
			return 0;
		}else if(i==1){
			cost[i][j]+getMin(cost, disc, i, j--, val);
		}
		else {
			cost[i][j]+getMin(cost, disc, i-1, j, val);
		}
		return 0;
	}*/
	
	public int getMM(int[][] cost, int[][] disc, int pi, int pj, int ci, int cj, int val){
		if(ci==0 && cj==0){
			return cost[pi][pj]+cost[ci][cj];
		}
		else{
			val=Math.min(cost[pi][pj]+cost[ci][cj], getMM(cost, disc, pi, pj, ci, cj-1, val));
		}
		return val;
	}
	

}
