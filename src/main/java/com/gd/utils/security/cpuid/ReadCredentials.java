/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gd.utils.security.cpuid;

import com.gd.utils.security.cpuid.getcomputerserials.windows.DiskUtils;
import com.gd.utils.security.cpuid.getcomputerserials.windows.MiscUtils;

/**
 *
 * @author gigaDatta
 */
public class ReadCredentials extends Credentials {
    
    
    private final static short PIN = 4444;
    
    public ReadCredentials() throws Exception {
        try {
            cpuInfo();
        } catch (Exception ex) {
            throw new Exception("Ocurrió un error al recabar la información: "+ex.getMessage());
        }
    }

    private void cpuInfo() throws Exception {        
        this.setMotherBoardSN(MiscUtils.getMotherboardSN());
        this.setDirUsuario(System.getProperty("user.home"));
        this.sethDiskSN(DiskUtils.getSerialNumber(this.getDirUsuario().substring(0, 1)));
        this.setSistemaOperaivo(System.getProperty("os.name"));
        this.setArquitecturaSO(System.getProperty("os.arch"));
        this.setUsuario(System.getProperty("user.name"));        
        this.setIdcpu(GenAuthCode.genCod(MD5.getMD5String(this.getNombreRegistro()+this.getMotherBoardSN()+this.gethDiskSN()), PIN));
    }

}