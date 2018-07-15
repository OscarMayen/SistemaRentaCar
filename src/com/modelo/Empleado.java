
package com.modelo;

import java.sql.Date;

/**
 *Nombre de la clase: Empleado
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class Empleado 
{
    private int idEmpleado;
    private double salario;
    private Date fechaInicio;
    private String isss;
    private boolean estado;
    private int idPersona;
    private int idDepartamento;

    public Empleado() {
    }

    public Empleado(int idEmpleado, double salario, Date fechaInicio, String isss, boolean estado, int idPersona, int idDepartamento) {
        this.idEmpleado = idEmpleado;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
        this.isss = isss;
        this.estado = estado;
        this.idPersona = idPersona;
        this.idDepartamento = idDepartamento;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getIsss() {
        return isss;
    }

    public void setIsss(String isss) {
        this.isss = isss;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    
    
    
    
}
