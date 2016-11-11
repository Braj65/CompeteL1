package com.trgr.HashTableImplementation;

import java.io.IOException;

public class Client {
	public static void main(String[] args) throws IOException
    {
        HashMap map = new HashMap();
        map.put("Wasif", 36100);
        map.put("Stephen Hughes", 22100);
        map.put("Z", 3356);
        map.put("z", 3359);
        map.put("Zafar", 220);
        map.put("Wasif", 1187);
        System.out.println(map.get("Stephen Hughes"));
        System.out.println(map.get("Z"));
        System.out.println(map.get("z"));
		/*System.out.println(toAscii("A"));
		System.out.println(toAscii("Z"));
		System.out.println(toAscii("a"));
		System.out.println(toAscii("z"));
		System.out.println(toAscii("Wasif"));
		System.out.println(toAscii("Wasif"));*/
    }
	
	public static String toAscii(String s){
        StringBuilder sb = new StringBuilder();
        long asciiInt;
        // loop through all values in the string, including blanks
        for (int i = 0; i < s.length(); i++){
            //getting Ascii value of character and adding it to the string.
            char c = s.charAt(i);
            asciiInt = (int)c; 
            sb.append(asciiInt);
        }
        return String.valueOf(sb);
    }
}
