package com.codeChefMedium.Recurse_DP.Knapsack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chefshop_CHRL1_Rec {
//variation of knapsack using recursion
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
			System.out.println(maxCostWt(wt, cost, tarWt, len));
			--testcaseCnt;
		}
	}

	public static int maxCostWt(int[] wt, int[] cost, int tarWt, int pos) {
		if (pos == 0) {
			return 0;
		} else if (tarWt < wt[pos]) {
			return maxCostWt(wt, cost, tarWt, pos - 1);
		} else {
			return max(cost[pos] + maxCostWt(wt, cost, tarWt - wt[pos], pos - 1), 
					maxCostWt(wt, cost, tarWt, pos - 1));
		}
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
