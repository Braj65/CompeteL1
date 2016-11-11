package com.trgr.careerstack20.revLinkList;

import com.trgr.careerstack1.listIntersect.LinkList;

public class RevLinkList {
	
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
		LinkList curNode=x;
		LinkList aprevNode=null;
		LinkList nextNode=x;
		while(curNode!=null){
			nextNode=curNode.next;
			curNode.next=aprevNode;
			aprevNode=curNode;
			curNode=nextNode;
		}
		
		return aprevNode;
	}

}
