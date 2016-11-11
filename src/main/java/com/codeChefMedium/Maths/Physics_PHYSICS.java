package com.codeChefMedium.Maths;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Physics_PHYSICS {
	
	public static void main(String[] args) throws Exception {
		ClassLoader classloader=Thread.currentThread().getClass().getClassLoader();
		InputStreamReader input=new InputStreamReader(ClassLoader.getSystemResourceAsStream("com/codeChefMedium/Physics_PHYSICS.txt"));
		BufferedReader br=new BufferedReader(input);
		PrintWriter pw=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		
		while(t!=0){
			StringTokenizer st=new StringTokenizer(br.readLine());
			BigInteger[] studH=new BigInteger[Integer.parseInt(st.nextToken())];
			BigInteger F=BigInteger.valueOf(Long.parseLong(st.nextToken()));
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<studH.length;i++){
				studH[i]=BigInteger.valueOf(Long.parseLong(st.nextToken()));
			}
//			Arrays.sort(studH);
			HashMap<BigInteger, BigInteger> hCnt=new HashMap<BigInteger, BigInteger>();
			BigInteger one=new BigInteger("1");
			for(BigInteger x: studH){
				if(hCnt.get(x)==null){
					hCnt.put(x, BigInteger.valueOf(1));
				}else{
					hCnt.put(x, hCnt.get(x).add(one));
				}
			}
			Set<BigInteger> s=hCnt.keySet();
			Iterator<BigInteger> i=s.iterator();
			BigInteger comb=new BigInteger("0");
			BigInteger factor=F;
			BigInteger jam=new BigInteger("0");;
			while(i.hasNext()){
				BigInteger k=i.next();
				BigInteger val=hCnt.get(k);
				if(hCnt.get(k.divide(BigInteger.valueOf(1)))!=null){
					BigInteger oner=hCnt.get(k.divide(one));
					comb=comb.add(((oner.multiply((oner.subtract(one)))).divide(BigInteger.valueOf(2))));
				}
				
//				while(factor<=k){
				while(k.mod(factor).equals(jam)){
					k=k.divide(factor);					
					if(hCnt.get(k)!=null){
						comb=comb.add(val.multiply(hCnt.get(k)));
					}
				}
			}
			System.out.println(comb);
			t--;
		}
		
	}

}
