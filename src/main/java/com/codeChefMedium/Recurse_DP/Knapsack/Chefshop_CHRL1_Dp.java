package com.codeChefMedium.Recurse_DP.Knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chefshop_CHRL1_Dp {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testcaseCnt = Integer.parseInt(st.nextToken());
		while (testcaseCnt != 0) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int tarWt = Integer.parseInt(st.nextToken());
			int[] wt = new int[len + 1];
			int[] cost = new int[len + 1];
			for (int i = 1; i < len + 1; i++) {
				st = new StringTokenizer(br.readLine());
				wt[i] = Integer.parseInt(st.nextToken());
				cost[i] = Integer.parseInt(st.nextToken());
			}
			// System.out.println(maxCostWt(wt, cost, tarWt, len));
			int[][] maxCosPertWt = new int[len + 1][tarWt + 1];
			for (int i = 0; i < len + 1; i++) {
				maxCosPertWt[0][i] = 0;
			}

			for (int i = 1; i < len + 1; i++) {
				for (int j = 0; j < tarWt + 1; j++) {
					if(j<wt[i]){
						maxCosPertWt[i][j]=maxCosPertWt[i-1][j];
					}else{
						maxCosPertWt[i][j] = max(cost[i] + maxCosPertWt[i - 1][j - wt[i]], 
								maxCosPertWt[i - 1][j]);
					}					
				}
			}
			System.out.println(maxCosPertWt[len][tarWt]);
			--testcaseCnt;
		}

	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
