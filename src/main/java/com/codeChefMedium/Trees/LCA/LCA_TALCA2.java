package com.codeChefMedium.Trees.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCA_TALCA2 {
	public static void main(String[] args) throws Exception {
		Class cls=Thread.currentThread().getClass();
		InputStreamReader is=new InputStreamReader(cls.getResourceAsStream("/com/codeChefMedium/TALCA.txt"));
		BufferedReader br=new BufferedReader(is);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		int size=Integer.parseInt(str.nextToken());
		node[] inArr=new node[size+1];
		int a=0;
		int b=0;
		for(int i=0;i<size-1;i++){
			str=new StringTokenizer(br.readLine());
			a=Integer.parseInt(str.nextToken());
			b=Integer.parseInt(str.nextToken());
			if(inArr[a]==null){
				node x=new node(a);
				inArr[a]=x;
			}
			
			if(inArr[b]==null){
				node y=new node(b);
				inArr[b]=y;
			}
			construct(inArr[a], inArr[b]);
		}
		str=new StringTokenizer(br.readLine());
		int set=Integer.parseInt(str.nextToken());
		int temp=0;
		while(set-->0){
			str=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(str.nextToken());
			int y=Integer.parseInt(str.nextToken());
			int z=Integer.parseInt(str.nextToken());
			node q=match(inArr[x], inArr[y], inArr[z], temp);
			System.out.println(q.data+" "+q.temp);
			q.temp=0;
		}
	}
	
	public static void construct(node a, node b){		
		if(a.aLeft==null)
			a.aLeft=b;
		else if(a.Right==null)
			a.Right=b;
		
		/*if(b.aLeft==null)
			b.aLeft=a;
		else if(b.Right==null)
			b.Right=a;*/
	}
	
	public static node match(node root, node a ,node b, int temp){
		if(root==null)
			return null;
		if(root.data==a.data || root.data==b.data)
			return root;
		else{
			node left=match(root.aLeft, a ,b, temp);
			node right=match(root.Right, a ,b, temp);
			if(left!=null && right!=null){
				root.temp=-1;
				return root;
			}
			if(left==null && right==null){
				return null;
			}else{
				return left!=null?left:right;
			}
		}
			
	}	
}

/*class node{
	node aLeft;
	node Right;
	int data;
	public node(int data){
		this.data=data;
		aLeft=null;
		Right=null;
	}
}*/
