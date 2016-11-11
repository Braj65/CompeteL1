package com.codeChefMedium.Trees.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCA_TALCA {
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
		int w=0;
		while(set-->0){
			str=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(str.nextToken());
			w=x;
			int y=Integer.parseInt(str.nextToken());
			int z=Integer.parseInt(str.nextToken());
			System.out.println(match(inArr[x], inArr[y], inArr[z]).data);
			if(inArr[x].aBefore==null){
				continue;
			}else{
				while(inArr[w].aBefore!=null){
					w=inArr[w].aBefore.data;					
				}
				System.out.println(matchers(inArr[x], inArr[w], inArr[y], inArr[z]).data);
			}
		}
	}
	
	public static void construct(node a, node b){		
		if(a.aLeft==null)
			a.aLeft=b;
		else if(a.Right==null)
			a.Right=b;
		else if(a.aBefore==null)
			a.aBefore=b;
		
		if(b.aBefore==null)
			b.aBefore=a;
		else if(b.aLeft==null)
			b.aLeft=a;
		else if(b.Right==null)
			b.Right=a;
	}
	
	public static node match(node root, node a, node b){
		if(root==null){
			return null;
		}
		if(root.data==a.data || root.data==b.data){
			return root;
		}else{
			node left=match(root.aLeft, a, b);
			node right=match(root.Right, a, b);
//			node before=match(root.aBefore, a, b);
			if(left!=null && right!=null){
				return root;
			}
			/*if(left!=null){
				if(right!=null){
					return root;
				}else if(before!=null){
					return root;
				}
			}else if(right!=null && before!=null){
				return root;
			}*/
			if(left==null && right==null){
				return null;
			}
			return left!=null?left:right;
			/*if(left!=null){
				return left;
			}else if(right!=null)
				return right;
			else
				return before;*/
		}
	}
	
	public static node matchers(node x, node root, node a, node b){
		if(root==null || root.data==x.data){
			return null;
		}
		if(root.data==a.data || root.data==b.data){
			return root;
		}else{
			node left=match(root.aLeft, a, b);
			node right=match(root.Right, a, b);
//			node before=match(root.aBefore, a, b);
			if(left!=null && right!=null){
				return root;
			}
			/*if(left!=null){
				if(right!=null){
					return root;
				}else if(before!=null){
					return root;
				}
			}else if(right!=null && before!=null){
				return root;
			}*/
			if(left==null && right==null){
				return null;
			}
			return left!=null?left:right;
			/*if(left!=null){
				return left;
			}else if(right!=null)
				return right;
			else
				return before;*/
		}
	}
}

class node{
	node aBefore;
	node aLeft;
	node Right;
	int temp=0;
	int data;
	public node(int data){
		this.data=data;
		aBefore=null;
		aLeft=null;
		Right=null;
	}
}
