package com.codeChefMedium.Sieve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.*;

public class PrimeGen_PRIME1 {

	public static void main(String[] args) throws Exception {
		//int max=(int)Math.sqrt(1000000000)+1;
		int max=32000;
		boolean[] primes=new boolean[max];
		int[] primeFact=new int[max];
		for(int i=2;i*i<max;i++){
			if(primes[i]==false){
				int t=i*i;
				int k=1;
				while(t<max){
					primes[t]=true;
					t=t+i;
					++k;
				}
			}			
		}
		
		int count=0;
		for(int i=2;i<max;i++){
			if(primes[i]==false){
				primeFact[count]=i;
				++count;
			}
		}
		ClassLoader classLoader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader in = new InputStreamReader(
				classLoader.getSystemResourceAsStream("com/codeChefMedium/PRIME1.txt"));
		BufferedReader br=new BufferedReader(in);
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(str.nextToken());
		int[] start=new int[t];
		int[] end=new int[t];
		for(int e=0;e<t;e++){
			str=new StringTokenizer(br.readLine());
			start[e]=Integer.parseInt(str.nextToken());
			end[e]=Integer.parseInt(str.nextToken());
		}
		int m=0;
		int n=0;
		for(int w=0;w<t;w++){
			m=start[w];
			n=end[w];
			if(m==1)
				m++;
			for(int p=m;p<=n;p++){
				int flag=0;
				for(int k=0;primeFact[k]<=(int)Math.sqrt(p);k++){
					if(p%primeFact[k]==0){
						flag=1;
						break;
					}
				}
				if(flag==0){
					System.out.println(p);
				}
			}
			System.out.println();			
		}
		
	}

}
