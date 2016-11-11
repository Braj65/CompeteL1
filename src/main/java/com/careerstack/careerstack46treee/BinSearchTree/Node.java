package com.trgr.careerstack46treee.BinSearchTree;

import java.util.ArrayList;
import java.util.List;


public class Node {
	
	public List<Link> var=new ArrayList<Link>();
	public Link k;
	
	public Node(int k){
		this.k=new Link(k);
//		this.pos=0;
		var.add(this.k);
	}
	public void insert(int k){
		Link l=new Link(k);
		int i=var.size();
		int parent=(var.size()-1)/2;
		Link cur=var.get(parent);
		if(cur.aLeft==null){
			cur.aLeft=l;
			cur.aLeft.aBefore=cur;
			swapperLeft(cur.aLeft);
		}
		else{
			cur.right=l;
			cur.right.aBefore=cur;
			swapperRight(cur.right);
		}
		var.add(l);
//		this.pos=this.pos+1;
	}
		
	
	public void swapperLeft(Link l){
		Link k=l;
		while(k.aBefore!=null && k.data>k.aBefore.data){
			int temp;
			temp=k.data;
			k.data=k.aBefore.data;
			k.aBefore.data=temp;
			k=k.aBefore;
		}
	}
	public void swapperRight(Link l){
		Link k=l;
		while(k.aBefore!=null && k.data<k.aBefore.data){
			int temp;
			temp=k.data;
			k.data=k.aBefore.data;
			k.aBefore.data=temp;
			k=k.aBefore;
		}
	}
	
	public void checker(){
		
	}

}
