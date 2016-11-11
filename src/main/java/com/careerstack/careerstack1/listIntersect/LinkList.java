package com.trgr.careerstack1.listIntersect;

public class LinkList {
	public Object data;
	public LinkList next=null;
	
	public LinkList(Object o){
		this.data=o;
	}
	
	public void add(Object a){
		LinkList q=new LinkList(a);
		LinkList w=this;
		while(w.next!=null){
			w=w.next;
		}
		if(w.data==null && w.next==null)
			w.data=q.data;
		else
			w.next=q;
	}
	
	public int getLength(){
		int i=1;
		LinkList x=this;
		while(x.next!=null){
			i++;
			x=x.next;
		}
		return i;
	}
	
	public LinkList getNode(int x){
		LinkList temp=this;
		while(x>1){
			temp=temp.next;
			x--;
		}
		return temp;
	}
}
