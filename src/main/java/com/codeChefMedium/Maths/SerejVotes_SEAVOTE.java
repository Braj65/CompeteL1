package com.codeChefMedium.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SerejVotes_SEAVOTE {
	public static void main(String[] args) throws Exception {
		ClassLoader classloader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader in = new InputStreamReader(
				classloader.getSystemResourceAsStream("com/codeChefMedium/SEAVOTE.txt"));
		BufferedReader br=new BufferedReader(in);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(str.nextToken());
		while(t-->0){
			str=new StringTokenizer(br.readLine());
			int size=Integer.parseInt(str.nextToken());
			str=new StringTokenizer(br.readLine());
			int sum=0;
			int j=0;
			int zeros=0;
			for(int i=0;i<size;i++){
				j=Integer.parseInt(str.nextToken());
				sum=sum+j;
				if(j<=0)
					++zeros;		
			}
			size=size-zeros;
			int diff=sum-100;
			if(diff>=0 && diff<size){
				System.out.println("YES");
			}else
				System.out.println("NO");
		}

	}

}
