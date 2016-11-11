package com.codeChefMedium.Maths.Subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivSubsets_DIVSUBS {

	public static void main(String[] args) throws Exception {
		ClassLoader cls = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader in = new InputStreamReader(cls.getSystemResourceAsStream("com/codeChefMedium/DIVSUBS.txt"));
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(in);
		StringTokenizer str=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(str.nextToken());
		while(t-->0){
			str=new StringTokenizer(br.readLine());
			int size=Integer.parseInt(str.nextToken());
			int[] input=new int[size+1];
			str=new StringTokenizer(br.readLine());
			for(int i=1;i<size+1;i++){
				input[i]=Integer.parseInt(str.nextToken());
			}
			int[] mods=new int[size+1];
			for(int j=0;j<size+1;j++){
				mods[j]=-1;
			}
			int val=0;
			int mod=0;
			for(int j=0;j<size+1;j++){
				val=(val+input[j])%size;
				if(mods[val]==-1)
					mods[val]=j;
				else{
					System.out.print(j-mods[val]);
					System.out.println();
					for(int i=mods[val]+1;i<=j;i++){
						System.out.print(i+" ");
					}
					System.out.println();
					break;
				}
			}
		}
	}

}
