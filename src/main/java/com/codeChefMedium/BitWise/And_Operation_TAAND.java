package com.codeChefMedium.BitWise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class And_Operation_TAAND {
	
	
	/*1) a=1, b=1, result=0
	2) each number will be anded with 1<<i where i range is 0 to 32
	3) if the result of step2 anding>result?result=result of step2 anding
	4) if b<number used in step1?a=b, b=number used in step1; else if a<number used in step1?a=number used in step1	//here we are finding the 1st and 2nd highest no.
	5) result=a&b*/
	
	
	 public int solve(int[] a){
		 int n = a.length;
		 boolean[] bad = new boolean[n];
		 Arrays.sort(a);
		 long ans = 0;
		 for(int i=31;i>=0;i--){	//from 31 and noy  to first find the highest 2^n
			 int cnt = 0;
			 for(int j=0;j<n;j++){
				 if(bad[j]) continue;
				 if((a[j]&(1L*1<<i))>0){
					 cnt+=1;
				 }
			 }
			 if(cnt >= 2){
				 ans += (1L*1<<i);
				 for(int j=0;j<n;j++){
					 if(bad[j]) continue;
					 if((a[j]&(1L*1<<i))==0){	//eliminate input no.s which don't have the 
						 bad[j] = true;	//highest 2^n in them
					 }
				 }
			 }else{
			 }
		 }
		 	return (int)ans;
	}
		 public static void main(String[] args) throws IOException {
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		 //System.out.println((1L*1<<31));
			 int n = Integer.parseInt(br.readLine());
			 int[] a = new int[n];
			 for(int i=0;i<n;i++){
				 a[i] = Integer.parseInt(br.readLine());
			 }
			 int val = new And_Operation_TAAND().solve(a);
			 bw.append(val+"\n");
			 bw.close();
		 }

}
