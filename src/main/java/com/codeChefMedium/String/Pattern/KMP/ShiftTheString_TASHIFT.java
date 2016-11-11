package com.codeChefMedium.String.Pattern.KMP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ShiftTheString_TASHIFT {
	
	//method to find partial match table
	static int[] failureFunc(String src){
		int m = src.length();
		int[] f = new int[m+1];
		f[0]=0;
		f[1]=0;
		for(int i = 2;i<=m;i++){
			int j = f[i-1];
			for(;;){	
				if(src.charAt(j)==src.charAt(i-1)){
					f[i]=j+1;
					break;
				}
				if(j==0){
					f[i]=0;
					break;
				}
				j=f[j];
			}
		}
		return f;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int len=Integer.parseInt(br.readLine());
		String A= br.readLine();
		String B = br.readLine();
		String BB = B+B;
		int[] f = failureFunc(A);
//Search A in BB
		int i = 0;
		int j = 0;
		int maxLCP = 0;
		int rotationsRequired = Integer.MAX_VALUE;
		int n = BB.length();
		for(;;){
			if(j== ((n/2 )+1))
			{
				break;
			}
			if(A.charAt(i)==BB.charAt(j)){
				i++;
				if(i>maxLCP){
					maxLCP = i;
					int temp = j-i+1;
					rotationsRequired = temp;
				}
				j++;
				if(i==A.length()){
					i=f[i];
				}
			}else{
				if(i>0){
					i=f[i];
				}else{
					j++;
				}
			}
		}
		if(rotationsRequired == Integer.MAX_VALUE){
			rotationsRequired = 0;
		}
		pw.println(rotationsRequired);
		pw.flush();
		pw.close();
	}
}
