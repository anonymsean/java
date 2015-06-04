package com.sean.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CheckUtil {
	static final String token="sean";
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		String[] arrs=new String[]{token,timestamp,nonce};
		Arrays.sort(arrs);		
		StringBuffer content=new StringBuffer();
		for(int i=0;i<arrs.length;i++){
			content.append(arrs[i]);
		}
		String temp=SHA(content.toString());
		return temp!=null?temp.equals(signature):false;
	}
	public static String SHA(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
