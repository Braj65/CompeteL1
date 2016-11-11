package com.trgr.careerstack47.listrev2node;

import com.trgr.careerstack1.listIntersect.LinkList;

public class RevLinkList2Node {
	public static void main(String[] args){
		LinkList l=new LinkList(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		l.add(70);
		l.add(80);
		l.add(90);
		RevLinkList2Node obj=new RevLinkList2Node();
		l=obj.arrange(l);
		while(l.next!=null){
			System.out.print(l.data+" ");
			l=l.next;
		}
		System.out.print(l.data);
		
	}
	
	public LinkList arrange(LinkList k){
		LinkList vol=k;
		LinkList temp=null;
		LinkList temp1=null;
		LinkList temp2=null;
		LinkList temp3=null;
		int x=0;
		while(vol.next!=null){
			temp1=vol.next.next;
			temp2=vol.getNode(4);
			temp3=vol.next;
			
			vol.next=temp2;
			temp3.next=vol;
			vol=temp3;
			if(x==0){
				temp=vol;
				++x;
			}
			
			vol=temp1;			
		}
		return temp;
	}
	
	
}
