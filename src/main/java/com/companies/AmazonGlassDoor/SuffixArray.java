package com.trgr.AmazonGlassDoor;

import java.util.Arrays;
import java.util.LinkedList;

public class SuffixArray {	
	public static void main(String[] args){
		LinkedList<String> d=new LinkedList<String>();
		String s="Jammy  the jammer";
		String[] x=s.split("");
		StringBuffer k=new StringBuffer();
		int i=0;
		for(String c:x){
			if(c.equals(" ")){
				c="";
				++i;
			}else{
				if(i>=1){
					c=" "+c;
				}
				i=0;
				k.append(c);
			}
		}
		System.out.println(k);
		
		System.out.println(lrs("BANANA"));
	}
	
	public static String lrs(String k){
		int len=k.length();
		
		String[] arr=new String[len];
		for(int i=0;i<len;i++){
			arr[i]=k.substring(i, len);
		}
		
		Arrays.sort(arr);
		String lrs="";
		for(int i=0;i<len-1; i++){
			String x=lcp(arr[i], arr[i+1]);
			if(x.length()>lrs.length())
				lrs=x;
		}
		
		return lrs;
		
	}
	
	public static String lcp(String s, String t){
		int n=Math.min(s.length(), t.length());
		for(int i=0;i<n;i++){
			if(s.charAt(i)!=t.charAt(i))
				return s.substring(0, i);
		}
		return s.substring(0, n);
	}



}
