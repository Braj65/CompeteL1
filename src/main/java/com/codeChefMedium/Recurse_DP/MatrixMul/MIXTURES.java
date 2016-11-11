package com.codeChefMedium.Recurse_DP.MatrixMul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MIXTURES {

	public static void main(String[] args) throws Exception {
		ClassLoader classloader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader in = new InputStreamReader(
				classloader.getSystemResourceAsStream("com/codeChefMedium/Mixtures.txt"));
		BufferedReader br = new BufferedReader(in);
		// BufferedReader br=new BufferedReader(new
		// InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		Integer nMix = Integer.parseInt(str.nextToken());
		
		int[] mixVals = null;
		int[][] multRes = null;
		int[][] sums = null;
		int[][] split=null;
		
		
		while (nMix != null) {
			mixVals = new int[nMix];
			multRes = new int[nMix][nMix];
			sums = new int[nMix][nMix];
			split=new int[nMix][nMix];
			str = new StringTokenizer(br.readLine());
			for (int i = 0; i < nMix; i++) {
				mixVals[i] = Integer.parseInt(str.nextToken());
				sums[i][i]=mixVals[i];
			}
			matrixMul(mixVals, multRes, sums, split);
			System.out.print(multRes[0][nMix-1]+"\n");
			String s=null;
			if((s=br.readLine())!=null){
				str = new StringTokenizer(s);
				nMix = Integer.parseInt(str.nextToken());
			}else{
				nMix=null;
			}
						
		}

	}

	public static void matrixMul(int[] mixVals, int[][] multRes, int[][] mods, int[][] split){
		int n=mixVals.length;
		int l=0;
		int q=0;
		for(int j=1;j<n;j++){
			l=j;
			
			for(int i=0;i<=(n-j-1);i++){
				multRes[i][l]=Integer.MAX_VALUE;
				for(int k=i;k<l;k++){
					q=multRes[i][k]+multRes[k+1][l]+mods[i][k]*mods[k+1][l];
					mods[i][l]=(mods[i][k]+mods[k+1][l])%100;
					if(q<multRes[i][l]){
						multRes[i][l]=q;
						split[i][l]=k;
					}
				}
				l++;
			}
		}
	}

}
