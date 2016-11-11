package com.codeChefMedium.Maths;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MagicTrick_MTRICK_Brute {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        Integer[] inArr=null;
        int[] abc=new int[3];
        String[] arm=null;
        while(t!=0){
        	st=new StringTokenizer(br.readLine());
        	int cnt=Integer.parseInt(st.nextToken());
        	inArr=new Integer[cnt];
        	st=new StringTokenizer(br.readLine());
        	for(int i=0;i<cnt;i++){
        		inArr[i]=Integer.parseInt(st.nextToken());
        	}
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<3;j++){
        		abc[j]=Integer.parseInt(st.nextToken());
        	}
        	st=new StringTokenizer(br.readLine());
        	arm=st.nextToken().split("");
        	int temp=0;
        	
        	for(int k=0;k<cnt;k++){
        		if(arm[k].equals("R")){        			
        			/*List<Integer> x=Arrays.asList(inArr);
        			Collections.reverse(x);
        			x.toArray(inArr);*/
        			for(int j=0;j<cnt/2;j++){
        				temp=inArr[j];
        				inArr[j]=inArr[cnt-1-j]%abc[2];
        				inArr[cnt-1-j]=temp%abc[2];
        			}
        		}else if(arm[k].equals("A")){
        			for(int j=0;j<cnt;j++){
        				inArr[j]=(inArr[j]+abc[0])%abc[2];
        			}
        		}else{
        			for(int j=0;j<cnt;j++){
        				inArr[j]=(inArr[j]*abc[1])%abc[2];
        			}
        		}
        		System.out.print(inArr[k]+" ");
        	}
        	System.out.println();
        	--t;
        }
	}

}
