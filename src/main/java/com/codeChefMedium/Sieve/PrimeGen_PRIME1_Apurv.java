package com.codeChefMedium.Sieve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeGen_PRIME1_Apurv {
	public static void main(String[] args) throws Exception {
		ClassLoader classLoader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader in = new InputStreamReader(
				classLoader.getSystemResourceAsStream("com/codeChefMedium/PRIME1.txt"));
		BufferedReader br=new BufferedReader(in);
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] prime=new int[32000];
		int[] p=new int[32000];
		int count=0;
		for(int i=2;i*i<32000;i++){
			if(prime[i]==0){
				int j=i*2;
				while(j<32000){
					prime[j]=1;
					j=j+i;
				}
			}
		}
		for(int j=2;j<32000;j++){
			if(prime[j]==0){
				p[count]=j;
				count++;
			}
		}
		int t=Integer.parseInt(st.nextToken());
		for(int k=1;k<=t;k++){
			st=new StringTokenizer(br.readLine());
			int m=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			if(m==1)
				m++;
			for(int j=m;j<=n;j++){
				int flag=0;
				int temp=(int)Math.sqrt(j);
				for(int u=0;p[u]<=temp;u++){
					if(j%p[u]==0){
						flag=1;
						break;
					}
				}
				if(flag==0)
					System.out.println(j);
			}
			System.out.println();
		}
	}

}
