package com.trgr.careerstack20.revLinkList;

import com.trgr.careerstack1.listIntersect.LinkList;

public class RevLinkListRecurs {
	public static LinkList curNode;
	public static LinkList aprevNode=null;
	public static LinkList nextNode;
	public static void main(String[] args){
		LinkList x=new LinkList(10);
		x.add(20);
		x.add(30);
		x.add(40);
		x=rev(x);
		while(x!=null){
			System.out.println(x.data);
			x=x.next;
		}
	}
	
	public static LinkList rev(LinkList x){
		if(x==null){
			return x;
		}
		else{
			curNode=x;
			nextNode=curNode.next;
			curNode.next=aprevNode;
			aprevNode=curNode;
			curNode=nextNode;
			rev(curNode);
		}
		
		return aprevNode;
	}
}
