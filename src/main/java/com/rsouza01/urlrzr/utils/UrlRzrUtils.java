package com.rsouza01.urlrzr.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlRzrUtils {

    public static boolean isUrlValid(String url) {
        boolean valid = true;
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            valid = false;
        }
        return valid;
    }

    
    public static String url2MD5(String url, int size) {

	   try {
		   
		   if(url == null || "".equals(url)) return "";
		   
		   java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        
			byte[] array = md.digest(url.getBytes());
			
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			}
			
			return sb.toString().substring(0, size);
			
	   } catch (java.security.NoSuchAlgorithmException e) { }
	   
	   return null;
    }
}
