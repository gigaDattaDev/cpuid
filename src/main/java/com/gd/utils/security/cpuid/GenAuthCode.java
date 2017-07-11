/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gd.utils.security.cpuid;

/**
 *
 * @author gigaDatta
 */
public class GenAuthCode {
    
    public static byte[] genCod(String hexValue, int PIN) throws Exception {
        String cod1 = hexValue.substring(0, 8);
        String cod2 = hexValue.substring(8, 16);
        String cod3 = hexValue.substring(16, 24);
        String cod4 = hexValue.substring(24, 32);
        cod1 = generateAuthCode(cod1);
        cod2 = generateAuthCode(cod2);
        cod3 = generateAuthCode(cod3);
        cod4 = generateAuthCode(cod4);
        String res = trim(cod1,getNPin(PIN,0))+""+trim(cod2,getNPin(PIN,1))+""+trim(cod3,getNPin(PIN,2))+""+trim(cod4,getNPin(PIN,3));
        return res.getBytes();
    }

    
    private static String generateAuthCode(String hexValue) throws Exception {
        long decimalNumber = 0;
        try {
            decimalNumber= Long.parseLong(hexValue, 16);
        }
        catch (java.lang.Exception e) {
            throw new Exception("Fuera de rango");
        }        
        String strBaseDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String strTempVal = "";
        int mod = 0;
        while(decimalNumber!= 0){
            mod=(int) (decimalNumber % strBaseDigits.length());
            strTempVal=strBaseDigits.substring(mod,mod+1)+strTempVal;
            decimalNumber=decimalNumber/strBaseDigits.length();
        }
        return strTempVal; 
    }
    
    private static int getNPin(int PIN, int pos) {
        String pin = String.valueOf(PIN);
        pin = pin.substring(pos, pos+1);
        return Integer.valueOf(pin);
    }
    
    private static String trim (String cod, int r) {
        while(cod.length()>r){
            cod=cod.substring(1);
        }
        return cod;
    }
       
}