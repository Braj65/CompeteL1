package com.trgr.careerstack14maxminHeap.minHeap;

import java.util.ArrayList;
import java.util.List;

public class MinHeapUsingArray {
	
	public static void main(String[] args){
		node trees=new node(0, 12);
		trees.insert(22);
		trees.insert(34);
		trees.insert(65);
		trees.insert(12);
		trees.insert(33);
		trees.insert(86);
		trees.insert(2);
		trees.insert(90);
		trees.insert(3);
		trees.insert(14);
		trees.insert(55);
		for(link k: trees.var){
			System.out.println(k.data);
		}
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
//	public link curNode;
	public int pos=0;
//	public List<link> var=new ArrayList<link>();
	public link[] var;
		
	public node(int k, int size){
		link l=new link(k);
//		this.pos=0;
		var=new link[size+1];
		var[pos]=l;
	}
	
	public void insert(int k){
		link l=new link(k);
		int i=pos+1;
		int parent=(i-1)/2;
		link cur=var[parent];
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
		var[++pos]=l;
//		this.pos=this.pos+1;
	}
	
	
	public void swapper(link l){
		link k=l;
		while(k.data<k.aBefore.data){
			int temp;
			temp=k.data;
			k.data=k.aBefore.data;
			k.aBefore.data=temp;
			k=k.aBefore;
		}
		
	}
}
