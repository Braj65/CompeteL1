package com.trgr.careerstack14maxminHeap.maxHeap;

import java.util.ArrayList;
import java.util.List;


public class MaxHeap {
	public static void main(String[] args){
		MaxHeap x=new MaxHeap();
		node trees=x.new node(5);
		trees.insert(3);
		trees.insert(17);
		trees.insert(10);
		trees.insert(84);
		trees.insert(19);
		trees.insert(6);
		trees.insert(22);
		trees.insert(9);
		for(link k: trees.var){
			System.out.println(k.data);
		}
	}
	class link{
		public link aLeft;
		public int data;
		public link right;
		public link aBefore;
		
		public link(int d1){
			this.data=d1;
		}
	}
	
	class node{

//		public link curNode;
//		public int pos=0;
		public List<link> var=new ArrayList<link>();
		
			
		public node(int k){
			link l=new link(k);
//			this.pos=0;
			var.add(l);
		}
		public void insert(int k){
			link l=new link(k);
			int i=var.size();
			int parent=(var.size()-1)/2;
			link cur=var.get(parent);
			if(cur.aLeft==null){
				cur.aLeft=l;
				cur.aLeft.aBefore=cur;
				swapper(cur.aLeft);
			}
			else{
				cur.right=l;
				cur.right.aBefore=cur;
				swapper(cur.right);
			}
			var.add(l);
//			this.pos=this.pos+1;
		}
		
		
		public void swapper(link l){
			link k=l;
			while(k.aBefore!=null && k.data>k.aBefore.data){
				int temp;
				temp=k.data;
				k.data=k.aBefore.data;
				k.aBefore.data=temp;
				k=k.aBefore;
			}
			
		}

	}

}
