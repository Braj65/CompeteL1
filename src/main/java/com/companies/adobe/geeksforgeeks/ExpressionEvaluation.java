package com.companies.adobe.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

import com.DS.Stack;
 
public class ExpressionEvaluation {
      
 static Map<Character, Integer> map=new HashMap<Character, Integer>();
 public static void main(String[] args){
      Stack ops=new Stack();
      Stack nums=new Stack();
      String in="4-8+4/4+6*4-6/3+5+2*1/6";
      int a=4-8+4/4+6*4-6/3+5+2*1/6;
      int b=4-8+1;
      System.out.println(b);
          
      char[] arr=in.toCharArray();
      nums.push(arr[0]);
      ops.push(arr[1]);
          
      for(int i=2;i<arr.length-1;i=i+2){
          nums.push(arr[i]);
          if(!ops.isEmpty()){
            if(opPrecedence(arr[i+1], (Character)ops.peek())){
                while(!ops.isEmpty()){
                  nums.push(operation(nums.pop(), nums.pop(), ops.pop()));
                }
                ops.push(arr[i+1]);
            }
            else{
                ops.push(arr[i+1]);
            }
          }
          else{
            ops.push(arr[i+1]);
          }             
      }
      nums.push(arr[arr.length-1]);
      while(!ops.isEmpty()){
          nums.push(operation(nums.pop(), nums.pop(), ops.pop()));
      }
          
      while(!nums.isEmpty()){
          System.out.println(nums.pop());
      }
    }
      
      
    public static boolean opPrecedence(char op1, char op2){
      map.put('/', 4);
      map.put('*', 3);
      map.put('+', 2);
      map.put('-', 1);
          
      if(map.get(op1)<map.get(op2)){
          return true;
      }
      else
          return false;
    }
      
    public static int operation(Object a, Object b, Object op){
      Integer i=Integer.valueOf(a.toString());
      Integer j=Integer.valueOf(b.toString());
          
      int res=0;
          
      switch(map.get(op)){
      case 1:
          res=j-i;
          break;
      case 2:
          res=j+i;
          break;
      case 3:
          res=j*i;
          break;
      case 4:
          res=j/i;
          break;
      default:
          res=0;
      }
          
      return res;
    }
 
}