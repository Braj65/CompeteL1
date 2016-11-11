package com.codeChefMedium.Trees.binaryIndexedTrees.Inversions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DynaInversion_DYNAINV {
	static Long[] inArr=null;
	public static void main(String[] args) throws Exception {
		DynaInversion_DYNAINV x=new DynaInversion_DYNAINV();
		ClassLoader classloader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader input = new InputStreamReader(
				classloader.getSystemResourceAsStream("com/codeChefMedium/DYNAINV.txt"));
		BufferedReader br=new BufferedReader(input);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int arrSize=Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		inArr=new Long[arrSize];
		for(int i=0;i<arrSize;i++){
			inArr[i]=Long.parseLong(st.nextToken());
		}
		Long[] obj=new Long[arrSize];
		for(long j=0;j<arrSize;j++){
			obj[(int) j]=j;
		}
		Arrays.sort(obj, x.new valComparator());
		
		long ans=0;
		while(t-->0){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			long temp=0;
			temp=obj[a-1];
			obj[a-1]=obj[b-1];
			obj[b-1]=temp;
			
			long[] biTree=new long[arrSize];
			int n=biTree.length;
			for(int k=n-1;k>0;k--){
				ans+=x.getSum(biTree, obj[k]);
				x.update(biTree, obj[k]);
			}
			System.out.println(ans%2);
			ans=0;
		}
		
	}
	
	public long getSum(long[] bitree, long index){
		long sum=0;
		while(index>0){
			sum+=bitree[(int) index];
			index-=index&(-index);
		}
		return sum;
	}
	
	public void update(long[] bitree, long index){
		index++;
		while(index<=bitree.length-1){
			bitree[(int) index]+=1;
			index+=index&(-index);
		}
	}
	
	class valComparator implements Comparator<Long>{
		public int compare(Long a, Long b){
			return inArr[a.intValue()].compareTo(inArr[b.intValue()]);
		}
	}

}
