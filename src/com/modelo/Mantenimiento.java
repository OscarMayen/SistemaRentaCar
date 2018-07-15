
package com.modelo;

import java.sql.Date;

/**
 *Nombre de la clase: Mantenimiento
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class Mantenimiento 
{
    private int idMantenimiento;
    private double precioMante;
    private Date fechaMante;
    private String descripcion;
    private String observaciones;
    private int idVehiculo;
    private int idTipoMantenimiento;

    public Mantenimiento() {
    }

    public Mantenimiento(int idMantenimiento, double precioMante, Date fechaMante, String descripcion, String observaciones, int idVehiculo, int idTipoMantenimiento) {
        this.idMantenimiento = idMantenimiento;
        this.precioMante = precioMante;
        this.fechaMante = fechaMante;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.idVehiculo = idVehiculo;
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public double getPrecioMante() {
        return precioMante;
    }

    public void setPrecioMante(double precioMante) {
        this.precioMante = precioMante;
    }

    public Date getFechaMante() {
        return fechaMante;
    }

    public void setFechaMante(Date fechaMante) {
        this.fechaMante = fechaMante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(int idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }
    
    
    
}
