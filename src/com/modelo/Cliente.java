
package com.modelo;

import java.sql.Date;

/**
 *Nombre de la clase: Cliente
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class Cliente 
{
    private int idCliente;
    private String fechaIngreso;
    private String licencia;
    private String lugarDeTrabajo;
    private String tipoCliente;
    private int idPersona;
    private String estado;

    public Cliente() {
    }

    public Cliente(int idCliente, String fechaIngreso, String licencia, String lugarDeTrabajo, String tipoCliente, int idPersona, String estado) {
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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    
}
