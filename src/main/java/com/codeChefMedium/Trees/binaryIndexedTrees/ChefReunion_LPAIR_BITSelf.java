package com.codeChefMedium.Trees.binaryIndexedTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//Inspired from https://www.youtube.com/watch?v=Z3LWA5lqAnk
public class ChefReunion_LPAIR_BITSelf {
	static Integer[] fem=null;
	static int n=0;
	static int[] traverseTree=null;
	public static void main(String[] args) throws Exception {
		BufferedReader inRead=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		n=Integer.parseInt(inRead.readLine());
		traverseTree=new int[n+2];
		fem=new Integer[n];
		
		for(int i=0;i<n;i++){
			StringTokenizer st=new StringTokenizer(inRead.readLine());
			st.nextToken();
			fem[i]=Integer.parseInt(st.nextToken());
		}
		
		Integer[] order=new Integer[n];
		Integer[] postSortOrder=new Integer[n];
		for(int j=0;j<n;j++){
			order[j]=j;
		}
		Arrays.sort(order, new valComparator());
		for(int k=0;k<n;k++){
			postSortOrder[order[k]]=k;
		}
		Integer ans=0;
		for(int o=n-1;o>=0;o--){
			ans+=read(postSortOrder[0]);
			update(postSortOrder[0]);
		}
		System.out.println(ans);
	}
	
	public static Integer read(Integer index){
		int sum=0;
		index=index+1;
		while(index>0){
			sum+=traverseTree[index];
			index-=index & (-index);
		}
		return sum;
	}
	
	public static void update(Integer index){
		index++;
		while(index<=n){
			traverseTree[index]+=1;
			index+=index & (-index);
		}	
	}
	
	
	static class valComparator implements Comparator<Integer>{
		public int compare(Integer a, Integer b){
			return fem[a].compareTo(fem[b]);
		}
	}

}
