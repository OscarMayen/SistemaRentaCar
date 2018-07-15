
package com.modelo;

/**
 *Nombre de la clase: Perfil
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class Perfil 
{
    private int idPerfil;
    private String perfil;

    public Perfil() {
    }

    public Perfil(int idPerfil, String perfil) {
        this.idPerfil = idPerfil;
        this.perfil = perfil;
    }
    
    
    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
    
}
