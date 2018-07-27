/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *Nombre de la clase: TipoMantenimiento
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3.
 */
public class TipoMantenimiento 
{
    private int idTipoMantenimiento;
    private String tipoManteniento;

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(int idTipoMantenimiento, String tipoManteniento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
        this.tipoManteniento = tipoManteniento;
    }

    public int getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(int idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public String getTipoManteniento() {
        return tipoManteniento;
    }

    public void setTipoManteniento(String tipoManteniento) {
        this.tipoManteniento = tipoManteniento;
    }

    
    
}
