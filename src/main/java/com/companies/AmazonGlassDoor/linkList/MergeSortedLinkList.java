package com.trgr.AmazonGlassDoor.linkList;

public class MergeSortedLinkList {
	
	public static void main(String[] args){
		Node n1=new Node(4);
		n1.insert(16);n1.insert(8);
		n1.insert(12);n1.insert(54);n1.insert(28);
		
		Node n2=new Node(34);
		n2.insert(2);n2.insert(65);n2.insert(12);
		n2.insert(8);n2.insert(44);
		
		Node x=merger(n1, n2);
		while(x.next!=null){
			System.out.println(x.data);
			x=x.next;			
		}
	}
	
	public static Node merger(Node n1, Node n2){
		Node q1=n1;
		Node q2=n2;
		
		Node fake=new Node(0);
		Node f=fake;
		
		while(q1!=null && q2!=null){
			if(q1.data<q2.data){
				fake.next=q1;
				q1=q1.next;
			}
			else{
				fake.next=q2;
				q2=q2.next;
			}
			fake=fake.next;
		}
		
		if(q1!=null)
			fake.next=q1;
		if(q2!=null)
			fake.next=q2;
		
		return f.next;		
	}

}
