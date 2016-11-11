package com.trgr.careerstack12.stackUsingLinkList;

import com.trgr.careerstack1.listIntersect.LinkList;

public class StackUsingLinkList {
	
	public static void main(String[] args){
		/*LinkList l1=new LinkList(10);
		l1.add(20);
		l1.add(30);
		l1.add(40);
		l1.add(50);
		l1.add(60);*/
		StackUsingLinkList x=new StackUsingLinkList();
		Stacker l1=x.new Stacker(10);
		l1.push(20);
		l1.push(30);
		l1.push(40);
		l1.push(50);
		l1.push(60);
		System.out.println(l1.pop());
		System.out.println(l1.pop());
		System.out.println(l1.pop());
	}
	
	
	public class Stacker extends LinkList{

		public Stacker(Object o) {
			super(o);
		}
		
		public void push(Object o){
			this.add(o);
		}
		
		public Object pop(){
			Object res=this.data;
			LinkList o=this;
			this.data=this.next.data;
			this.next=this.next.next;			
			return res;
		}
		
	}

}
