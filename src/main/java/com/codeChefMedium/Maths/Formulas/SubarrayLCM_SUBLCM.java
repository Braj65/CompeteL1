package com.codeChefMedium.Maths.Formulas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubarrayLCM_SUBLCM {
	
	public static void main(String[] args) throws Exception{
		SubarrayLCM_SUBLCM obj=new SubarrayLCM_SUBLCM();
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.valueOf(in.readLine());
		while(t-->0){
			String n=in.readLine();
			String[] strInArr=in.readLine().split(" ");
			int[] inArr=new int[Integer.parseInt(n)];
			for(int p=0;p<strInArr.length;p++){
				inArr[p]=Integer.parseInt(strInArr[p]);
			}
			int[] dp=new int[inArr.length];
			for(int i=0;i<inArr.length;i++){
				if(i>0)
					dp[i]=Math.min(inArr[i-1]+1, i-obj.lastCoPrime(inArr, i));
				else
					dp[0]=Math.min(inArr[0]+1, obj.lastCoPrime(inArr, i));
			}
			Arrays.sort(dp);
			System.out.println(dp[dp.length-1]);
		}
		
	}
	
	public int lastCoPrime(int[] inArr, int pos){
		int gc=0;
		for(int j=pos-1;j>=0;j--){
			if(inArr[j]>inArr[pos])
				gc=gcd(inArr[j], inArr[pos]);
			else
				gc=gcd(inArr[pos], inArr[j]);
			
			if(gc>1){
				return j+1;
			}
		}
		
		return 0;
	}
	
	public int gcd(int a, int b){
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
	

}
