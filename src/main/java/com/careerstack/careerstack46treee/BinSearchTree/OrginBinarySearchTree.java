package com.careerstack.careerstack46treee.BinSearchTree;

public class OrginBinarySearchTree {

    public static  OriNode root;
    public OrginBinarySearchTree(){
          this.root = null;
    }
   
    public boolean find(int id){
          OriNode current = root;
          while(current!=null){
                 if(current.data==id){
                        return true;
                 }else if(current.data>id){
                        current = current.left;
                 }else{
                        current = current.right;
                 }
          }
          return false;
    }
    public boolean delete(int id){
          OriNode parent = root;
          OriNode current = root;
          boolean isLeftChild = false;
          while(current.data!=id){
                 parent = current;
                 if(current.data>id){
                        isLeftChild = true;
                        current = current.left;
                 }else{
                        isLeftChild = false;
                        current = current.right;
                 }
                 if(current ==null){
                        return false;
                 }
          }
          //if i am here that means we have found the OriNode
          //Case 1: if OriNode to be deleted has no children
          if(current.left==null && current.right==null){
                 if(current==root){
                        root = null;
                 }
                 if(isLeftChild ==true){
                        parent.left = null;
                 }else{
                        parent.right = null;
                 }
          }
          //Case 2 : if OriNode to be deleted has only one child
          else if(current.right==null){
                 if(current==root){
                        root = current.left;
                 }else if(isLeftChild){
                        parent.left = current.left;
                 }else{
                        parent.right = current.left;
                 }
          }
          else if(current.left==null){
                 if(current==root){
                        root = current.right;
                 }else if(isLeftChild){
                        parent.left = current.right;
                 }else{
                        parent.right = current.right;
                 }
          }else if(current.left!=null && current.right!=null){
                
                 //now we have found the minimum element in the right sub tree
                 OriNode successor      = getSuccessor(current);
                 if(current==root){
                        root = successor;
                 }else if(isLeftChild){
                        parent.left = successor;
                 }else{
                        parent.right = successor;
                 }                  
                 successor.left = current.left;
          }           
          return true;       
    }
   
    public OriNode getSuccessor(OriNode deleleOriNode){
          OriNode successsor =null;
          OriNode successsorParent =null;
          OriNode current = deleleOriNode.right;
          while(current!=null){
                 successsorParent = successsor;
                 successsor = current;
                 current = current.left;
          }
          //check if successor has the right child, it cannot have left child for sure
          // if it does have the right child, add it to the left of successorParent.
//        successsorParent
          if(successsor!=deleleOriNode.right){
                 successsorParent.left = successsor.right;
                 successsor.right = deleleOriNode.right;
          }
          return successsor;
    }
    public void insert(int id){
          OriNode newOriNode = new OriNode(id);
          if(root==null){
                 root = newOriNode;
                 return;
          }
          OriNode current = root;
          OriNode parent = null;
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
    public void display(OriNode root){
          if(root!=null){
                 display(root.left);
                 System.out.print(" " + root.data);
                 display(root.right);
          }
    }
    public static void main(String arg[]){
    	  OrginBinarySearchTree b = new OrginBinarySearchTree();
          b.insert(3);b.insert(8);
           b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
          b.insert(20);b.insert(25);b.insert(15);b.insert(16);
          System.out.println("Original Tree : ");
          b.display(root);          
          System.out.println("");
          System.out.println("Check whether OriNode with value 4 exists : " + b.find(4));
          System.out.println("Delete OriNode with no children (2) : " + b.delete(2));      
          b.display(root);
          System.out.println("\n Delete OriNode with one child (4) : " + b.delete(4));      
          b.display(root);
          System.out.println("\n Delete OriNode with Two children (10) : " + b.delete(10));            
          b.display(root);
    }

}
class OriNode{
    int data;
    OriNode left;
    OriNode right; 
    public OriNode(int data){
          this.data = data;
          left = null;
          right = null;
    }
}
