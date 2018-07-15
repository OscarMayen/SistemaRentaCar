
package com.modelo;

/**
 *Nombre de la clase: Agencia
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class Agencia 
{
    private int idAgencia;
    private String nombreAgencia;
    private String telefonoAgencia;
    private String direccionAgencia;
    private String emailAgencia;

    public Agencia() {
    }

    public Agencia(int idAgencia, String nombreAgencia, String telefonoAgencia, String direccionAgencia, String emailAgencia) {
        this.idAgencia = idAgencia;
        this.nombreAgencia = nombreAgencia;
        this.telefonoAgencia = telefonoAgencia;
        this.direccionAgencia = direccionAgencia;
        this.emailAgencia = emailAgencia;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getTelefonoAgencia() {
        return telefonoAgencia;
    }

    public void setTelefonoAgencia(String telefonoAgencia) {
        this.telefonoAgencia = telefonoAgencia;
    }

    public String getDireccionAgencia() {
        return direccionAgencia;
    }

    public void setDireccionAgencia(String direccionAgencia) {
        this.direccionAgencia = direccionAgencia;
    }

    public String getEmailAgencia() {
        return emailAgencia;
    }

    public void setEmailAgencia(String emailAgencia) {
        this.emailAgencia = emailAgencia;
    }

    
    
    
    
}
