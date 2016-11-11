package com.trgr.careerstack46treee.maxDepth;


public class DepthOfTree {
	
	public static  Node root;
    public DepthOfTree(){
          this.root = null;
    }
	
	public static void main(String[] args){
		DepthOfTree b = new DepthOfTree();
        b.insert(3);b.insert(8);
         b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
        b.insert(20);b.insert(25);b.insert(15);b.insert(16);
        System.out.println(b.maxDepth(root));
        System.out.println(b.maxHeight(root));
        
        
	}
	
	public void insert(int id){
        Node newOriNode = new Node(id);
        if(root==null){
               root = newOriNode;
               return;
        }
        Node current = root;
        Node parent = null;
        while(true){
               parent = current;
               if(id<current.data){                          
                      current = current.left;
                      if(current==null){
                            parent.left = newOriNode;
                            return;
                      }
               }else{
                      current = current.right;
                      if(current==null){
                            parent.right = newOriNode;
                            return;
                      }
               }
        }
	}
	
	public static int maxDepth(Node root){
		if(root==null)
			return 0;
		else{
			return(1+Math.max(maxDepth(root.left), maxDepth(root.right)));
		}
	}
	
	//leetcode method
	public static int maxHeight(Node root){
		if(root==null)
			return 0;
		int left_height=maxHeight(root.left);
		int right_height=maxHeight(root.right);
		return(left_height>right_height)?left_height+1:right_height+1;		
	}
	

}

class Node{
    int data;
    Node left;
    Node right; 
    public Node(int data){
          this.data = data;
          left = null;
          right = null;
    }
}