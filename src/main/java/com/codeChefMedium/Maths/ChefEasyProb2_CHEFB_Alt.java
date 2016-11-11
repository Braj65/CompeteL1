package com.codeChefMedium.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class ChefEasyProb2_CHEFB_Alt {
	static Integer[] ai=null;
	public static void main(String[] args) throws Exception {
		int[] primeFact=new int[1000000];
		int j, k, l;
		for(int i=2;i*i<1000000;i++){
			
			if(primeFact[i]==0){
				k=0;
				j=i*i;
				while(j<1000000){
					primeFact[j]=i;
					j=i*i+k*i;
					++k;
				}
			}
		}
		ClassLoader classloader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader input = new InputStreamReader(
				classloader.getSystemResourceAsStream("com/codeChefMedium/CHEFB.txt"));
		BufferedReader br=new BufferedReader(input);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		
		int temp=0;
		HashMap<Integer, Integer> parentMCnt=new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> childMCnt=new HashMap<Integer, Integer>();
		Set<Integer> lcm=null;
		Iterator<Integer> iter=null;
		int f=0;
		int child=0;
		Integer parent=0;
		
		while(t-->0){
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			ai=new Integer[n];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++){
				ai[i]=Integer.parseInt(st.nextToken());
				temp=ai[i];
				while(primeFact[temp]!=0){
					if(childMCnt.get(primeFact[temp])==null){
						childMCnt.put(primeFact[temp], 1);
					}else{
						childMCnt.put(primeFact[temp], childMCnt.get(primeFact[temp])+1);
					}
					temp=temp/primeFact[temp];
				}
				if(temp!=1){
					if(childMCnt.get(temp)==null){
						childMCnt.put(temp, 1);
					}else{
						childMCnt.put(temp, childMCnt.get(temp)+1);
					}
				}
				lcm=childMCnt.keySet();
				iter=lcm.iterator();
				while(iter.hasNext()){
					f=iter.next();
					child=childMCnt.get(f);
					parent=parentMCnt.get(f);
					if(parent!=null){
						parentMCnt.put(f,child>parent?child:parent);
					}else{
						parentMCnt.put(f, child);
					}
				}
				childMCnt.clear();
				
			}
			int cnt=0;
			lcm=parentMCnt.keySet();
			iter=lcm.iterator();
			while(iter.hasNext()){
				f=iter.next();
				cnt=cnt+parentMCnt.get(f);
			}
			System.out.println(cnt);
			parentMCnt.clear();
		}
	}

}
