package com.codeChefMedium.Maths.Median;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ChefHome_CHEFHOME {
	public static void main(String[] args) throws Exception {
		Class cls = Thread.currentThread().getClass();
		InputStreamReader in = new InputStreamReader(cls.getResourceAsStream("/com/codeChefMedium/CHEFHOME.txt"));
		BufferedReader br=new BufferedReader(in);
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(str.nextToken());
		while(t-->0){
			str=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(str.nextToken());
			long[] A=new long[n];
			long[] B=new long[n];
			int i=0;
			while(i<n){
				str=new StringTokenizer(br.readLine());
				A[i]=Long.parseLong(str.nextToken());
				B[i]=Long.parseLong(str.nextToken());
				++i;
			}
			Arrays.sort(A);
			Arrays.sort(B);
			
			if(n%2!=0){
				System.out.println(1);
			}else{
				int x=n/2-1;
				long aBoundary1=A[x];
				long aBoundary2=A[x+1];
				long cnt1=aBoundary2-aBoundary1-1;
				cnt1=cnt1+2;
				
				long bBoundary1=B[x];
				long bBoundary2=B[x+1];
				long cnt2=bBoundary2-bBoundary1-1;
				cnt2=cnt2+2;
				System.out.println(cnt1*cnt2);
			}
		}		
		System.out.println(gcd(68, 12));		
	}
	
	public static int gcd(int a, int b){
		if(b==0) return a;
	 	return gcd(b, a%b);
	}

}
