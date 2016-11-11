package com.codeChefMedium.Trees.binaryIndexedTrees.Inversions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynaInversion_DYNAINVVishves {
	
	public static void main(String[] args) throws Exception {
		ClassLoader classloader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader input = new InputStreamReader(
				classloader.getSystemResourceAsStream("com/codeChefMedium/DYNAINV.txt"));
		BufferedReader br=new BufferedReader(input);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int arrSize=Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int inArr[]=new int[arrSize+1];
		for(int i=1;i<=arrSize;i++){
			inArr[i]=Integer.parseInt(st.nextToken());
		}
		int temp=0;
		int count=0;
		for(int j=1;j<=arrSize;j++){
			if(inArr[j]!=j){
				temp=inArr[j];
				inArr[j]=inArr[temp];
				inArr[temp]=temp;
				j--;
				++count;
			}
		}
		count=count%2;
		for(int k=0;k<t;k++){
			if(count==1){
				count=0;
				System.out.println(count);
			}else{
				count=1;
				System.out.println(count);
			}
		}
	}

}
