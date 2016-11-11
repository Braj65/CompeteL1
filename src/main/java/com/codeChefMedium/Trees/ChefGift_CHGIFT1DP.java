package com.codeChefMedium.Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChefGift_CHGIFT1DP {
	
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
              long[][] ans=new long[cnt][1<<cnt-1];
              ans[0][0]=inArr[0];
              for(int i=1;i<cnt-1;i++){
            	  for(int j=0;j<1<<i;j+=2){
            		  ans[i][j]=max(ans[i-1][(j+1)/2], inArr[i]);
            		  ans[i][j+1]=min(ans[i-1][(j+1)/2], inArr[i]);
            	  }
              }
              if(cnt>1){
            	  long minAns=max(ans[cnt-2][0], inArr[cnt-1]);
                  for(int k=0;k<1<<cnt-1;k+=2){
                	  minAns=Math.min(minAns, max(ans[cnt-2][(k+1)/2], inArr[cnt-1]));
                	  minAns=Math.min(minAns, min(ans[cnt-2][(k+1)/2], inArr[cnt-1]));
                  }
                  pw.print(minAns);
              }
              else{
            	  pw.print(ans[0][0]);
              }
              pw.flush();
              t--;
        }
	}
	
	static long max(long a, long b) {
  	  long x=(a+b > a*b)?a+b:a*b;
  	  return (x > a-b)?x:a-b;
//  	  return (a > b)? a : b; 
    }
    static long min(long a, long b) {
  	  long x=(a+b < a*b)?a+b:a*b;
  	  return (x<a-b)?x:a-b;
//  	  return (a > b)? a : b; 
    }

}
