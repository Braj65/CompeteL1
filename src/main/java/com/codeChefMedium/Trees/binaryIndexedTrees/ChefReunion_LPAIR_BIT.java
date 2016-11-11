package com.codeChefMedium.Trees.binaryIndexedTrees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
//https://www.youtube.com/watch?v=Z3LWA5lqAnk
public class ChefReunion_LPAIR_BIT {
	static int[] tree;
	static int n;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		n=Integer.parseInt(br.readLine());
		int[] male=new int[n];
		int[] female=new int[n];
		pair[] p=new pair[n];
		int[] ff=new int[n+5];
		tree=new int[n+2];
		for(int i=0;i<n;i++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine());
			male[i]=Integer.parseInt(st.nextToken());
			female[i]=Integer.parseInt(st.nextToken());
			p[i]=new pair(male[i],female[i]);
		}
		Arrays.sort(male);
		Arrays.sort(female);
		Map<Integer,Integer> m=new HashMap<Integer,Integer>();
		Map<Integer,Integer> f=new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++)
		{
			m.put(male[i], i+1);
			f.put(female[i], i+1);
		}
		for(int i=0;i<n;i++)
		{
			ff[m.get(p[i].x)]=f.get(p[i].y);
		}
		long ans=0;
		for(int i=n;i>=1;i--)
		{
			ans+=getsum(ff[i]);
			update(ff[i]);
		}
		pw.println(ans);
		pw.close();
	}
	public static int getsum(int index)
	{
		int sum=0;
//		index=index+1;
		while(index>0)
		{
			sum+=tree[index];
			index-=index&(-index);	//this equation finds parent of the current node by
		}							// flipping the righ most set bit. It will keep on finding parent
		return sum;					//till it reaches its own parent 2^x node. It finds the parent node
	}//by substracting from the original number the number with and after the right most set
	//bit. index&(-index) gives back a number with place value of rght most set bit.
	//For ex-
	//1010100(84) then index&(-index) will give 100 i.e number extracted from original number
	//including and after right most set bit. So next will be (84-100)1010000(80)
	//->(80-10000)1000000(64). Remember, to be substracted from same number
	public static void update(int index)
	{
		index++;
		while(index<=n)
		{
			tree[index]+=1;
			index+=index&(-index);	//this equation finds next node to be updated(not going to be 
									//parent node but next sibling and next branch's parent).
									//it finds the next node by addding one to the right most set bit.
			//It keeps on finding next node till it reaches any next parent node of 2^x level i.e immediate
			//child of root node. It never reaches its own 2^x parent node.
			//Adding one to right most one is nothing but adding place value of right-most ONE to the number
			//index&(-index) gives back a number with place value of rght most set bit. For ex-
			//1010100(84) then index&(-index) will give 100 i.e number extracted from original number
			//including and after right most set bit. So next will be (84+100)1011000(86)
			//->(86+1000)1100000(96)->(96+100000)10000000(128). Remember, to be added to same number
		}
	}
}

	class pair
	{
		int x;
		int y;
		public pair(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
