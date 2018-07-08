
package com.modelo;

/**
 *Nombre de la clase: Usuario
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEDEPADE
 * @Author: GRUPO#3
 */
public class Usuario 
{
    private int idUsuario;
    private String usuario;
    private String password;
    private int idPersona;
    private int idPerfil;

    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String password, int idPersona, int idPerfil) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.idPersona = idPersona;
        this.idPerfil = idPerfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    
    

    
}
