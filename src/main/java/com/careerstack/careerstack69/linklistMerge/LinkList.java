package com.trgr.careerstack69.linklistMerge;

public class LinkList {
	
	public LinkList next;
	public Integer data;
	
	public LinkList(Integer o){
		this.data=o;
	}
	
	public void insert(Integer o){
		LinkList y=new LinkList(o);
		LinkList x=this;
		while(x.next!=null){
			x=x.next;
		}
		x.next=y;
	}

}
