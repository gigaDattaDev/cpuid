/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.utils.security.cpuid;

/**
 *
 * @author Julio
 */
public abstract class Credentials {
    
    private byte[] idcpu; //identificador único del equipo
    private String nombreRegistro; // nombre de Registro de la licencia
    private String motherBoardSN; // número de serie de la tarjeta madre
    private String hDiskSN; // número de serie del disco duro
    private String sistemaOperaivo; // sistema operativo instalado en el equipo
    private String arquitecturaSO; // arquitectura del sistema operativo
    private String usuario; // nombre usuario en el sistema operativo
    private String dirUsuario; // directorio de usuario usado por sistema operativo

    public byte[] getIdcpu() {
        return idcpu;
    }

    public void setIdcpu(byte[] idcpu) {
        this.idcpu = idcpu;
    }

    public String getNombreRegistro() {
        return nombreRegistro;
    }

    public void setNombreRegistro(String nombreRegistro) {
        this.nombreRegistro = nombreRegistro;
    }

    public String getMotherBoardSN() {
        return motherBoardSN;
    }

    public void setMotherBoardSN(String motherBoardSN) {
        this.motherBoardSN = motherBoardSN;
    }

    public String gethDiskSN() {
        return hDiskSN;
    }

    public void sethDiskSN(String hDiskSN) {
        this.hDiskSN = hDiskSN;
    }

    public String getSistemaOperaivo() {
        return sistemaOperaivo;
    }

    public void setSistemaOperaivo(String sistemaOperaivo) {
        this.sistemaOperaivo = sistemaOperaivo;
    }

    public String getArquitecturaSO() {
        return arquitecturaSO;
    }

    public void setArquitecturaSO(String arquitecturaSO) {
        this.arquitecturaSO = arquitecturaSO;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDirUsuario() {
        return dirUsuario;
    }

    public void setDirUsuario(String dirUsuario) {
        this.dirUsuario = dirUsuario;
    }

    
    
}