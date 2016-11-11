package com.trgr.careerstack9.revDoubleLinkList;

public class ReverseDoubLnkList {
	
	public static void main(String[] args){
		DoubleLinkList obj=new DoubleLinkList(10);
		obj.addData(20);
		obj.addData(30);
		//reverseDoubleLnkList(obj);
		reverseDoubleList(obj);
	}
	
	public static void reverseDoubleLnkList(DoubleLinkList d1){
		DoubleLinkList aprevNode=null;
		DoubleLinkList nextNode=null;
		DoubleLinkList curList=d1;
		while(curList.next!=null){
			nextNode=curList.next;
			curList.next=aprevNode;
			aprevNode=curList;
			curList.aprev=nextNode;
			curList=curList.aprev;
		}
		curList.next=curList.aprev;
		curList.aprev=null;
	}
	
	public static void reverseDoubleList(DoubleLinkList d1){
		DoubleLinkList aprevNode=null;
		DoubleLinkList nextNode=null;
		DoubleLinkList curList=d1;
		while(curList!=null){
			nextNode=curList.next;
			aprevNode=curList.aprev;
			
			curList.next=aprevNode;
			curList.aprev=nextNode;
			
			curList=nextNode;
		}
		d1=aprevNode;
	}

}
