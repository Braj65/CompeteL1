package com.codeChefMedium.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFANUP {
	
	public static void main(String[] args) throws Exception {
		Class cls=Thread.currentThread().getClass();
		InputStreamReader in=new InputStreamReader(cls.getResourceAsStream("/com/codeChefMedium/CHEFANUP.txt"));
		BufferedReader br=new BufferedReader(in);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(str.nextToken());
		while(t-->0){
			str=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(str.nextToken());
			int k=Integer.parseInt(str.nextToken());
			int l=Integer.parseInt(str.nextToken());
			
			int[] ans=new int[n];
			int pos=ans.length-1;
			l=l-1;
			while(l>0){
				ans[pos]=l%k;
				l/=k;
				--pos;
			}
			for(int i=0;i<ans.length;i++){
				System.out.print(ans[i]+1+" ");
			}
			System.out.println();			
		}
		
	}

}
