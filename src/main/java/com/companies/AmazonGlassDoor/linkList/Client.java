package com.trgr.AmazonGlassDoor.linkList;
public class Client {
	
	public static void main(String[] args){
		Node x=new Node(1);
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.insert(5);
		x.insert(6);
		x.insert(7);
		x.insert(8);
		x.insert(9);
		x.insert(10);
		System.out.println(x.getLength());
		get(x, x.getLength());
		
	}
	
	public static void get(Node x, int len){
		int half=len/2;
		int i=1;
		Node temp=null;
		Node curNode=null;
		Node prevNode=null;
		Node nextNode=null;
		while(x!=null && i<half){
			temp=x;
			x=x.next;
			++i;
		}
		curNode=x;
		while(curNode!=null){
			nextNode=curNode.next;
			curNode.next=prevNode;
			prevNode=curNode;
			curNode=nextNode;
		}
		temp.next=prevNode;
	}

}

