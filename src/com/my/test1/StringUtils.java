package com.my.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {

	public static void main(String[] args) throws IOException {
		
		InputStreamReader r=new InputStreamReader(System.in);    
	    BufferedReader br=new BufferedReader(r); 
	    
	    int i = 0;
	    while(i<20) {
	    	i++;
	    	String name=br.readLine();  
	    	System.out.println(name);    
	    }
	}
	
	public static String hash(String str, String algo) throws NoSuchAlgorithmException {

		MessageDigest digest = MessageDigest.getInstance(algo);

		byte[] encodedhash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
		
		return bytesToHex(encodedhash);

	}

	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

}
