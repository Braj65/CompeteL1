package com.trgr.careerstack43.altmergeLList;

import com.trgr.careerstack1.listIntersect.LinkList;

public class AlternateMergeLinkList {
	
	public static void main(String[] args){
		LinkList l1=new LinkList(10);
		l1.add(30);
		l1.add(50);
		l1.add(70);
		l1.add(90);
		l1.add(110);
		
		LinkList l2=new LinkList(20);
		l2.add(40);
		l2.add(60);
		l2.add(80);
		l2.add(100);
		
		merge(l1, l2);
		
	}
	
	public static void merge(LinkList l1, LinkList l2){
		int len1=l1.getLength();
		int len2=l2.getLength();
		LinkList temp1;
		LinkList temp2;
		
		if(len1>len2){
			while(l2.next!=null){
				temp1=l1.next;
				l1.next=l2;
				temp2=l2.next;
				l2.next=temp1;
				l2=temp2;
				l1=temp1;
			}
		}
	}

}
