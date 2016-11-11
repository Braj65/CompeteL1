package com.careerstack.careerstack46treee.LCA;

public class LCA_Nodes {
	public static void main(String[] args) {
		int[] inArr={0,9,11,5,6,2,3,8,13,7};
		node root=constructTree(inArr, 1);
		
		System.out.println(match(root, new node(8), new node(33)).data);
		System.out.println(match(root, new node(2), new node(5)).data);
		System.out.println(match(root, new node(9), new node(5)).data);
		System.out.println(match(root, new node(8), new node(7)).data);
		System.out.println(match(root, new node(9), new node(3)).data);
		System.out.println(match(root, new node(13), new node(2)).data);
		System.out.println(match(root, new node(3), new node(8)).data);
		System.out.println(match(root, new node(5), new node(8)).data);
	}
	
	public static node constructTree(int[] inArr, int i){
		if(2*i>inArr.length-1){
			if(i<=inArr.length-1){
				return new node(inArr[i]);
			}
		}
		node root=new node(inArr[i]);
		root.aLeft=constructTree(inArr, 2*i);		
		root.right=constructTree(inArr, 2*i+1);		
		return root;
	}
	
	public static node match(node root, node a, node b){
		if(root==null){
			return null;
		}
		if(root.data==a.data || root.data==b.data){
			return root;
		}else{
			node left=match(root.aLeft, a, b);
			node right=match(root.right, a, b);
			if(left!=null && right!=null){
				return root;
			}
			if(left==null && right==null){
				return null;
			}
			return left!=null?left:right;
		}
		
		
	}


	


}
class node{
	int data;
	node aLeft;
	node right;
	public node(int data){
		this.data=data;
		aLeft=null;
		right=null;
	}
}
