package com.trgr.careerstack61.loopInList;

public class SingleList {
	
	public SingleList next;
	public Object data;
	
	public SingleList(Object o){
		this.data=o;
	}
	
	public void insert(Object o){
		SingleList re=new SingleList(o);
		SingleList x=this;
		while(x.next!=null){
			x=x.next;
		}
		x.next=re;
	}
	
	public void loopIt(){
		SingleList x=this;
		SingleList y=this;
		while(x.next!=null){
			x=x.next;
		}
		y=y.next.next.next.next.next;
		x.next=y;
	}

}
