package com.trgr.careerstack69.linklistMerge;

public class SortedLinkListMerge {
	LinkList a;
	public static void main(String[] args){
		LinkList a=new LinkList(10);
		a.insert(30);
		a.insert(50);
		a.insert(70);
		a.insert(90);
		
		LinkList b=new LinkList(20);
		b.insert(40);
		b.insert(60);
		b.insert(80);
		b.insert(100);
		
		SortedLinkListMerge we=new SortedLinkListMerge();
		we.merger(b, a);
		System.out.println("Jammy");
	}
	
	public void merger(LinkList y, LinkList x){
		LinkList secList=x;
		
		while(y!=null && x!=null){
			if(y.data<x.data){
				LinkList k=y.next;
				y.next=x;
				secList=x.next;
				x.next=k;
				y=k;
				x=secList;
			}else if(y.data>x.data){
				LinkList k=x.next;
				x.next=y;
				secList=y.next;
				y.next=k;
				x=k;
				y=secList;
			}			
		}		
	}
}
