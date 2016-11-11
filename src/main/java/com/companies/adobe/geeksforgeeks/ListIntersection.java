package com.trgr.adobe.geeksforgeeks;

import com.trgr.careerstack1.listIntersect.LinkList;

public class ListIntersection {
	
	public static void main(String[] args){
		LinkList l1=new LinkList(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		l1.add(7);
		l1.add(8);
		
		LinkList l2=new LinkList(12);
		l2.add(14);
		
		joiner(l1, l2);
		lengthEqualiser(l1, l2);
		
		while(l1!=null && l2!=null){
			if(((Integer)l1.data^(Integer)l2.data)==0){
				System.out.println("this is it"+l1.data);
				break;
			}
			l1=l1.next;
			l2=l2.next;
		}
		System.out.println("Jammy");
		
	}
	
	public static void joiner(LinkList l1, LinkList l2){
		LinkList p1head=l1;
		LinkList p2head=l2;
		
		int i=0;
		while(i<4){
			l1=l1.next;
			i++;
		}
		
		while(l2.next!=null){
			l2=l2.next;
		}
		l2.next=l1;
	}
	
	public static void lengthEqualiser(LinkList l1, LinkList l2){
		int len1=0;
		int len2=0;
		
		LinkList h1=l1;
		LinkList h2=l2;
		
		while(l1!=null){
			++len1;
			l1=l1.next;
		}
		while(l2!=null){
			++len2;
			l2=l2.next;
		}
		
		l1=h1;
		l2=h2;
		
		int diff=0;
		if(len1>len2){
			diff=len1-len2;
			while(diff!=0){
				l1=l1.next;
				--diff;
			}
		}
		else{
			diff=len2-len1;
			while(diff!=0){
				l2=l2.next;
				--diff;
			}
		}
		h1.data=l1.data;
		h1.next=l1.next;
		h2.data=l2.data;
		h2.next=l2.next;		
	}
	
	public static String oneComplementor(String x){
		char[] c=x.toCharArray();
		StringBuffer sb=new StringBuffer();
		for(char w: c){
			sb.append(flipper(w));
		}
		
		return sb.toString();
	}
	
	public static char flipper(char c){
		return c=='0'?'1':'0';
	}
	
	public static int twoComplementor(String x){
		int oneComplementedNum=binStringToint(x);
		
		int m=1;
		while((oneComplementedNum & m)==0){
			oneComplementedNum=oneComplementedNum^m;
			m<<=1;
		}
		int twoComplementedNum=oneComplementedNum;
		return twoComplementedNum;
	}
	
	public static int binStringToint(String x){
		char[] c=x.toCharArray();
		int res=0;
		for(int i=c.length-1;i>=0;i--){
			res+=c[i]*Math.pow(2, c.length-1-i);
		}
		
		return res;
	}

}
