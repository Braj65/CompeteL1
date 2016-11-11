package com.codeChefMedium.Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChefGift_CHGIFT1_DPImproved {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        while(t!=0){
              st=new StringTokenizer(br.readLine());
              int cnt=Integer.parseInt(st.nextToken());
              int[] inArr=new int[cnt];
              
              st=new StringTokenizer(br.readLine());
              for(int i=0;i<cnt;i++){
            	  inArr[i]=Integer.parseInt(st.nextToken());
              }
              long start=inArr[0];
              long max=start;
              long min=start;
              long maxCache=0;
              long minCache=0;
              for(int i=1;i<cnt;i++){
            	  maxCache=max(max(max, inArr[i]), min(max, inArr[i]), max(min, inArr[i]), min(min, inArr[i]));
            	  minCache=min(max(max, inArr[i]), min(max, inArr[i]), max(min, inArr[i]), min(min, inArr[i]));
            	  max=maxCache;
            	  min=minCache;
              }
              pw.print(min);
              pw.flush();
              --t;
        }
	}
	
	static long max(long a, long b) {
	  	  long x=(a+b > a*b)?a+b:a*b;
	  	  return (x > a-b)?x:a-b;
//	  	  return (a > b)? a : b; 
	    }
	static long min(long a, long b) {
	  	  long x=(a+b < a*b)?a+b:a*b;
	  	  return (x<a-b)?x:a-b;
//	  	  return (a > b)? a : b; 
	    }
	static long max(long a, long b, long c, long d){
		long x=a>b?a:b;
		long y=c>d?c:d;
		return x>y?x:y;
	}
	static long min(long a, long b, long c, long d){
		long x=a<b?a:b;
		long y=c<d?c:d;
		return x<y?x:y;
	}
        

}
