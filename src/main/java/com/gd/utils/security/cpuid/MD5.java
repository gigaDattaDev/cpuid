package com.gd.utils.security.cpuid;

import java.math.BigInteger;
import java.security.MessageDigest;



public class MD5 {
    
    public static String getMD5String (String plaintext) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return hashtext.toUpperCase();
    }
    
    public static byte[] getMD5String (byte[] data) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(data);
        return m.digest();
    }
    
}