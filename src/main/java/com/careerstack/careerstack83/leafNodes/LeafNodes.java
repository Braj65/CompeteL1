package com.trgr.careerstack83.leafNodes;

import java.util.ArrayList;
import java.util.List;


public class LeafNodes {
	
	public static void main(String[] args){
		Node n1=new Node(5);
		n1.insert(10);
		n1.insert(9);
		n1.insert(3);
		n1.insert(14);
		n1.insert(12);
		n1.insert(22);
		n1.insert(56);
		n1.insert(12);
		n1.insert(8);
		checkLeaf(n1);
	}
	
	public static void checkLeaf(Node n){
		List<Link> queue=new ArrayList<Link>();
		List<Link> next=new ArrayList<Link>();
		queue.add(n.k);
		int i=0;
		while(queue.size()>0){
//			System.out.println("Level-------------"+i+" queue size-"+queue.size());
			for(Link q:queue){
//				System.out.println(q.data);
				if(q.aLeft!=null)
					next.add(q.aLeft);
				if(q.right!=null)
					next.add(q.right);
			}
			if(next.size()==0){
				break;
			}
			queue.clear();
			queue.addAll(next);
			next.clear();
			++i;
		}
		for(Link q:queue)	System.out.println(q.data);
	}
	

}
