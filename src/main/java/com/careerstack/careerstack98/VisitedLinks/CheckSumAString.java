package com.trgr.careerstack98.VisitedLinks;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CheckSumAString {
	
	public static void main(String[] args) throws Exception{
		checkSum("Jammy");
	}
	
	public static String checkSum(String s) throws Exception{
		MessageDigest md =MessageDigest.getInstance("SHA1");
		byte[] databytes=new byte[1024];
		databytes=s.getBytes();
		
		md.update(databytes);
		
		byte[] mdbytes=md.digest();
		
		StringBuffer buff=new StringBuffer("");
		for(int i=0;i<mdbytes.length;i++){
			buff.append(Integer.toString((mdbytes[i]&0xff)+0x100,16).substring(1));
		}
		
		System.out.println("Digest in hex format "+buff.toString());
		return buff.toString();
		
	}

}
