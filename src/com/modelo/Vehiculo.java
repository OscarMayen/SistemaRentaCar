
package com.modelo;

import java.sql.Date;

/**
 *Nombre de la clase: Vehiculo
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class Vehiculo 
{
    private int idVehiculo;
    private String marca;
    private String color;
    private String tipoVehiculo;
    private int año;
    private String numMotor;
    private String numChasis;
    private String numPlacas;
    private String tarjetaVencimiento;
    private String paisProcedencia;
    private double precioAlquiler;
    private String estado;
    private int idAgencia;
    private int capacidad;

    public Vehiculo() {
    }

    public Vehiculo(int idVehiculo, String marca, String color, String tipoVehiculo, int año, String numMotor, String numChasis, String numPlacas, String tarjetaVencimiento, String paisProcedencia, double precioAlquiler, String estado, int idAgencia, int capacidad) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.año = año;
        this.numMotor = numMotor;
        this.numChasis = numChasis;
        this.numPlacas = numPlacas;
        this.tarjetaVencimiento = tarjetaVencimiento;
        this.paisProcedencia = paisProcedencia;
        this.precioAlquiler = precioAlquiler;
        this.estado = estado;
        this.idAgencia = idAgencia;
        this.capacidad = capacidad;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public String getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    public String getNumPlacas() {
        return numPlacas;
    }

    public void setNumPlacas(String numPlacas) {
        this.numPlacas = numPlacas;
    }

    public String getTarjetaVencimiento() {
        return tarjetaVencimiento;
    }

    public void setTarjetaVencimiento(String tarjetaVencimiento) {
        this.tarjetaVencimiento = tarjetaVencimiento;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

   
    
}
