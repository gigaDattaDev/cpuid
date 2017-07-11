/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gd.utils.security.cpuid.getcomputerserials.windows;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiskUtils {

    private static final int sizeOfIntInHalfBytes = 8;
    private static final int numberOfBitsInAHalfByte = 4;
    private static final int halfByte = 0x0F;
    private static final char[] hexDigits = { 
        '0', '1', '2', '3', '4', '5', '6', '7', 
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    
    public static String[] getAllSerialNumber() {        
        File[] roots = File.listRoots();
        String [] resp = new String[roots.length];
        
        for (int i = 0; i < roots.length; i++) {
            
            resp[i] = roots[i] + " " + getSerialNumber(roots[i].toString());
        }
            
        return resp;
    }
    
    public static void listarDirectorio(File f, String separador){
        File[] ficheros = f.listFiles();		
        if (ficheros!=null) {
            for (int x=0;x<ficheros.length;x++){			
                System.out.println(separador + ficheros[x].getName());
                if (ficheros[x].isDirectory()) {
                    String nuevo_separador;
                    nuevo_separador = separador + " ";
                    listarDirectorio(ficheros[x],nuevo_separador);
                }
            }
        }
    }
  

  public static String getSerialNumber(String drive) {
  String result = "";
    try {
      File file = File.createTempFile("realhowto",".vbs");
      file.deleteOnExit();
      FileWriter fw = new java.io.FileWriter(file);

      String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                  +"Set colDrives = objFSO.Drives\n"
                  +"Set objDrive = colDrives.item(\"" + drive + "\")\n"
                  +"Wscript.Echo objDrive.SerialNumber";  // see note
      fw.write(vbs);
      fw.close();
      Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
      
      BufferedReader input =
        new BufferedReader
          (new InputStreamReader(p.getInputStream()));
      String line;
      while ((line = input.readLine()) != null) {
         result += line;
      }
      input.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    String resp = "";
    if (!result.trim().equals("")) {
        int dec = Integer.valueOf(result.trim());
        resp = decToHex(dec);
    }
    return resp;
  }
  
  private static String decToHex(int dec) {
    StringBuilder hexBuilder = new StringBuilder(sizeOfIntInHalfBytes);
    hexBuilder.setLength(sizeOfIntInHalfBytes);
    for (int i = sizeOfIntInHalfBytes - 1; i >= 0; --i)
    {
      int j = dec & halfByte;
      hexBuilder.setCharAt(i, hexDigits[j]);
      dec >>= numberOfBitsInAHalfByte;
    }
    return hexBuilder.toString(); 
  }

}