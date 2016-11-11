package com.codeChefMedium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CascSS_CSS2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer stat = Integer.parseInt(st.nextToken());
		Integer queCnt = Integer.parseInt(st.nextToken());
		map[] x=new map[1000000];
		
		Integer id=0;
		Integer prior=0;
		Integer attr=0;
		Integer val=0;		
		for (int i = 0; i < stat; i++) {
				st=new StringTokenizer(br.readLine());
				id=Integer.parseInt(st.nextToken());
				attr=Integer.parseInt(st.nextToken());
				val=Integer.parseInt(st.nextToken());
				prior=Integer.parseInt(st.nextToken());;
				Integer[] priorVal=new Integer[2];
				priorVal[0]=prior;
				priorVal[1]=val;
				if(x[id]==null){
					x[id]=new CascSS_CSS2().new map(attr, priorVal);
				}else if(x[id].getAttr(attr)==false){
					x[id].setPrior(attr, priorVal);
				}else if(prior>=x[id].getPrior(attr)[0]){
					x[id].setPrior(attr, priorVal);
				}				
		}
		for(int j=0;j<queCnt;j++){
			st=new StringTokenizer(br.readLine());
			id=Integer.parseInt(st.nextToken());
			attr=Integer.parseInt(st.nextToken());
			System.out.println(x[id].getPrior(attr)[1]);
		}
	}
	
	class map{
		Integer attr=0;
		Integer[] priorVal=new Integer[2];
		HashMap<Integer, Integer[]> attrPrior=new HashMap<Integer, Integer[]>();
		
		map(Integer attr, Integer[] priorVal){
			attrPrior.put(attr, priorVal);
		}
		public Integer[] getPrior(Integer attr){
			return attrPrior.get(attr);
		}
		
		public void setPrior(Integer attr, Integer[] priorVal){
			attrPrior.put(attr, priorVal);
		}
		
		public boolean getAttr(Integer attr){
			return attrPrior.containsKey(attr);
		}
	}

}
