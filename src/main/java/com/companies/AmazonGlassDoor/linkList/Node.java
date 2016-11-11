package com.trgr.AmazonGlassDoor.linkList;

public class Node {
	
	public Node next;
	public int data;
	
	public Node(int x){
		data=x;
	}
	
	public void insert(int x){
		Node a=new Node(x);
		Node now=this;
		while(now.next!=null){
			now=now.next;
		}
		now.next=a;
	}
	
	
	public int getLength(){
		int i=1;
		Node now=this;
		while(now.next!=null){
			now=now.next;
			++i;
		}
		
		return i;
	}

}

