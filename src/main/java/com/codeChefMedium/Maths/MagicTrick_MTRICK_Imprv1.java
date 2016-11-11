package com.codeChefMedium.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class MagicTrick_MTRICK_Imprv1 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        BigInteger[] inArr=null;
        BigInteger[] abc=new BigInteger[3];
        String arm=null;
        String[] armArr=null;
        while(t!=0){
        	st=new StringTokenizer(br.readLine());
        	int cnt=Integer.parseInt(st.nextToken());
        	inArr=new BigInteger[cnt];
        	st=new StringTokenizer(br.readLine());
        	for(int i=0;i<cnt;i++){
        		inArr[i]=BigInteger.valueOf(Long.parseLong((st.nextToken())));
        	}
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<3;j++){
        		abc[j]=BigInteger.valueOf(Long.parseLong((st.nextToken())));
        	}
        	st=new StringTokenizer(br.readLine());
        	armArr=st.nextToken().split("");
        	BigInteger add=new BigInteger("0");
        	BigInteger mul=new BigInteger("1");   	
        	int dir=0;
        	
        		for(int k=0;k<cnt;k++){
            		if(armArr[k].equals("R")){
            			if(dir==1){
            				System.out.print(inArr[k].multiply(mul).add(add)+" ");
            			}else{
            				System.out.print(inArr[cnt-k-1].multiply(mul).add(add)+" ");
            			}            			
            			dir=dir^1;
            		}else if(armArr[k].equals("A")){
            			add=add.add(abc[0]);
            			if(dir==1){
            				System.out.print(inArr[cnt-k-1].multiply(mul).add(add).mod(abc[2])+" ");
            			}else{
            				System.out.print(inArr[k].multiply(mul).add(add).mod(abc[2])+" ");
            			}
            		}else if(armArr[k].equals("M")){
            			mul=mul.multiply(abc[1]);
            			add=add.multiply(abc[1]);
            			if(dir==1){
            				System.out.print(inArr[cnt-k-1].multiply(mul).add(add).mod(abc[2])+" ");
            			}else{
            				System.out.print(inArr[k].multiply(mul).add(add).mod(abc[2])+" ");
            			}
            		}
            	}
        	System.out.println();
        	--t;
        }        	
	}
}
