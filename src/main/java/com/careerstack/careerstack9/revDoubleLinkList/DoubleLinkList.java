package com.trgr.careerstack9.revDoubleLinkList;

public class DoubleLinkList {
	
	public DoubleLinkList aprev=null;
	public Object data=null;
	public DoubleLinkList next=null;
	
	public DoubleLinkList(Object o){
		this.data=o;
	}
	
	public void addData(Object o){
		DoubleLinkList newNode=new DoubleLinkList(o);
		DoubleLinkList curList=this;
		
		while(curList.next!=null){
			curList=curList.next;
		}
		curList.next=newNode;
		curList.next.aprev=curList;	
	}
	
	public static void main(String[] args){
		DoubleLinkList obj=new DoubleLinkList(10);
		obj.addData(20);
		obj.addData(30);
	}

}
