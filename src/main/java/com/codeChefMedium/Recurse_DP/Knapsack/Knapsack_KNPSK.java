package com.codeChefMedium.Recurse_DP.Knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Knapsack_KNPSK {
	
	static ArrayList<Integer> one=null;
	static ArrayList<Long> two=null;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int l=Integer.parseInt(br.readLine());
		one=new ArrayList<Integer>();
		two=new ArrayList<Long>();
		int stepTotal=0;
		for(int i=0;i<l;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==1){
				one.add(Integer.parseInt(st.nextToken()));
				stepTotal=stepTotal+1;
			}else{
				two.add(Long.parseLong(st.nextToken()));
				stepTotal=stepTotal+2;
			}			
		}

		Integer[] first=one.toArray(new Integer[one.size()]);
		one=null;
		Long[] second=two.toArray(new Long[two.size()]);
		two=null;
		
		Arrays.sort(first);
		Arrays.sort(second);
		for(int i=1;i<=stepTotal;i++){
			System.out.println(packer(first, second, first.length-1, second.length-1, i));
			Runtime runtime = Runtime.getRuntime();
			System.out.println("free memory: " + (runtime.totalMemory()-runtime.freeMemory()) / 1024);
		}
		int a=first.length-1;
		int b=second.length-1;
		Long high=0L;
		int var=0;
		for(int i=1;i<=stepTotal;i++){
			var=i;
			while(var>0){
				if(var%2==0){
					var=var-2;
					if(b<0 || a>=0 && first[a]>=second[b]){
						high=high+first[a];
						--a;
						var=var+1;
					}
					else if(a>0 && first[a]+first[a-1]>=second[b]){
						high=high+first[a]+first[a-1];
						a=a-2;
					}
					else{
						high=high+second[b];
						--b;					
					}
				}
				else{
					var=var-1;
					if(a<0){
						high=0+high;
					}else{
						high=high+first[a];
						--a;
					}				
				}
			}
			System.out.println(high);
			high=0L;
			a=first.length-1;
			b=second.length-1;
			Runtime runtime = Runtime.getRuntime();
			System.out.println("free memory: " + (runtime.totalMemory()-runtime.freeMemory()) / 1024);
			/*pw.print(high);
			pw.flush();*/
		}		
		
	}
	
	public static Long packer(Integer[] first, Long[] second, int a, int b, int tots){
		if(tots<=0)
			return (long) 0;
		else{
			if(tots%2==0){
				tots=tots-2;
				if(b<0 || a>=0 && first[a]>=second[b]){
					return first[a]+packer(first, second, a-1, b, tots+1);
				}
				else if(a>0 && first[a]+first[a-1]>=second[b]){
					return first[a]+first[a-1]+packer(first, second, a-2, b, tots);
				}
				else{
					return second[b]+packer(first, second, a, b-1, tots);
				}				
			}else{
				tots=tots-1;
				if(a<0){
					return 0+packer(first, second, a, b, tots);
				}else{
					return first[a]+packer(first, second, a-1, b, tots);
				}
			}
		}
	}

}
