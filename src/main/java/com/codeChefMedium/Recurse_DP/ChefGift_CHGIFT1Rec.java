
package com.codeChefMedium.Recurse_DP;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class ChefGift_CHGIFT1Rec {
     
      public static void main(String[] args) throws Exception {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw=new PrintWriter(System.out);
            StringTokenizer st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            while(t!=0){
                  st=new StringTokenizer(br.readLine());
                  int cnt=Integer.parseInt(st.nextToken());
                  int[] inArr=new int[cnt];
                  
                  st=new StringTokenizer(br.readLine());
                  for(int i=0;i<cnt;i++){
                	  inArr[i]=Integer.parseInt(st.nextToken());
                  }
                  long[] ans=new long[1];
                  ans[0]=inArr[0];
                  findMaxMin(inArr, 0, inArr[0], ans);
                  System.out.println(ans[0]);                  
                  --t;
            }
      }
      
      public static void findMaxMin(int[] arr, int pos, long maxmin, long[] ans){
    	  if(pos>=arr.length-1){
    		  if(maxmin<ans[0]){
    			  ans[0]=maxmin;
    		  }
    		  return;
    	  }
    	  else{
    		 findMaxMin(arr, pos+1, max(maxmin, arr[pos+1]), ans);
    		 findMaxMin(arr, pos+1, min(maxmin, arr[pos+1]), ans);    		  
    	  }
    	  
      }
      
      static long max(long a, long b) {
    	  long x=(a+b > a*b)?a+b:a*b;
    	  return (x > a-b)?x:a-b;
      }
      static long min(long a, long b) {
    	  long x=(a+b < a*b)?a+b:a*b;
    	  return (x<a-b)?x:a-b;
      }
 
}
