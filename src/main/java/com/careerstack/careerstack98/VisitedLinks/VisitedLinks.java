package com.trgr.careerstack98.VisitedLinks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class VisitedLinks {
	
	public static void main(String[] args) throws Exception{
		Set<String> x=new HashSet<String>();
		x.add(CheckSumAString.checkSum("Jammy"));
		x.add(CheckSumAString.checkSum("Jammer"));
		
		System.out.println(x.contains(CheckSumAString.checkSum("Jammy")));
		
	}

}
