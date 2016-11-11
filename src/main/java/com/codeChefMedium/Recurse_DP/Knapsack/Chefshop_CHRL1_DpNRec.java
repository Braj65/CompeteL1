package com.codeChefMedium.Recurse_DP.Knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chefshop_CHRL1_DpNRec {
	

	//classic knapsack using recursion
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int testcaseCnt = Integer.parseInt(st.nextToken());
			while (testcaseCnt != 0) {
				st = new StringTokenizer(br.readLine());
				int len = Integer.parseInt(st.nextToken());
				int tarWt = Integer.parseInt(st.nextToken());
				int[] wt = new int[len+1];
				int[] cost = new int[len+1];
				for (int i = 1; i < len + 1; i++) {
					st = new StringTokenizer(br.readLine());
					wt[i] = Integer.parseInt(st.nextToken());
					cost[i] = Integer.parseInt(st.nextToken());
				}
				int[][] mem=new int[len+1][tarWt+1];
				System.out.println(maxCostWt(wt, cost, mem, tarWt, len));
				--testcaseCnt;
			}
		}

		public static int maxCostWt(int[] wt, int[] cost, int[][] mem, int tarWt, int pos) {
			if(mem[pos][tarWt]!=0){
				return mem[pos][tarWt];
			}
			if (pos == 0) {
				return 0;
			} else if (tarWt < wt[pos]) {
				mem[pos][tarWt]=maxCostWt(wt, cost, mem, tarWt, pos - 1);
				return mem[pos][tarWt];
			} else {
				mem[pos][tarWt]= max(cost[pos] + maxCostWt(wt, cost, mem, tarWt - wt[pos], pos - 1), 
						maxCostWt(wt, cost, mem, tarWt, pos - 1));
				return mem[pos][tarWt];
			}
		}

		static int max(int a, int b) {
			return (a > b) ? a : b;
		}
		
}

