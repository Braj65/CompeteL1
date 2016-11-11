package com.trgr.careerstack98.VisitedLinks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CheckSumProg {
	
	public static void main(String[] args) throws Exception{
		
		String dataFile=System.getProperty("user.dir")+"/src/main/java/"+CheckSumProg.class.getName();
		dataFile=dataFile.replaceAll("\\.", "/");
		int t=dataFile.lastIndexOf("/");
		dataFile=dataFile.substring(0, t+1);
		String inDataFile=dataFile+"data.txt";
		
		MessageDigest md =MessageDigest.getInstance("SHA1");
		FileInputStream fis=new FileInputStream(new File(inDataFile));
		
		byte[] dataBytes=new byte[1024];
		
		int nread=0;
		
		while((nread=fis.read(dataBytes))!=-1){
			md.update(dataBytes, 0, nread);
		}
		fis.close();
		
		byte[] mdbytes=md.digest();
		
		File outFile=new File(dataFile+"outData.txt");
		FileOutputStream fo=new FileOutputStream(outFile);
		fo.write(mdbytes);
		fo.flush();
		fo.close();
		
		//convert the byte[] to hex
		StringBuffer buff=new StringBuffer("");
		for(int i=0;i<mdbytes.length;i++){
			buff.append(Integer.toString((mdbytes[i]&0xff)+0x100,16).substring(1));
		}
		
		System.out.println("Digest in hex format "+buff.toString());
	}

}
