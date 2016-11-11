package com.trgr.careerstack1.listIntersect;

public class LListIntersect {
	public static void main(String[] args){
		LinkList l1=new LinkList(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		l1.add(7);
		
		LinkList l2=new LinkList(10);
		l2.add(12);
		l2.add(14);
		l2.add(5);
		l2.add(6);
		l2.add(7);
		
		int len1=l1.getLength();
		int len2=l2.getLength();
		
		int diff=0;
		if(len1>len2){
			diff=len1-len2;
			l1=jammer(l1, diff);
		}
		else if(len1<len2){
			diff=len2-len1;
			l2=jammer(l2, diff);
		}
		
		Object datum=0;
		while(l1.next!=null && l2.next!=null){
			if(l1.data==l2.data){
				System.out.println("Datum found");
				datum=l1.data;
				System.out.println(datum);
				break;
			}
			l1=l1.next;
			l2=l2.next;
		}
		
		
	}
	
	public static LinkList jammer(LinkList x, int diff){
		while(diff>0){
			x=x.next;
			--diff;
		}
		return x;
	}
}
