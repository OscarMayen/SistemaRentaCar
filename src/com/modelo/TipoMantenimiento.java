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
 * @Author: GRUPO#3
 */
public class TipoMantenimiento 
{
    private int idTipoMantenimiento;
    private int tipoMantenimiento;

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(int idTipoMantenimiento, int tipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public int getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(int idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public int getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(int tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }
    
    
}
