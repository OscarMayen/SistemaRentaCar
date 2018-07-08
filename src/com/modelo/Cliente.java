
package com.modelo;

import java.sql.Date;

/**
 *Nombre de la clase: Cliente
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEDEPADE
 * @Author: GRUPO#3
 */
public class Cliente 
{
    private int idCliente;
    private Date fechaIngreso;
    private String licencia;
    private String lugarDeTrabajo;
    private String tipoCliente;
    private int idPersona;
    private boolean estado;

    public Cliente() {
    }

    public Cliente(int idCliente, Date fechaIngreso, String licencia, String lugarDeTrabajo, String tipoCliente, int idPersona, boolean estado) {
        this.idCliente = idCliente;
        this.fechaIngreso = fechaIngreso;
        this.licencia = licencia;
        this.lugarDeTrabajo = lugarDeTrabajo;
        this.tipoCliente = tipoCliente;
        this.idPersona = idPersona;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getLugarDeTrabajo() {
        return lugarDeTrabajo;
    }

    public void setLugarDeTrabajo(String lugarDeTrabajo) {
        this.lugarDeTrabajo = lugarDeTrabajo;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
