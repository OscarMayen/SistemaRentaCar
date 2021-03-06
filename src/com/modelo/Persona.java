
package com.modelo;

import java.sql.Date;

/**
 *Nombre de la clase: Persona
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class Persona 
{
    private int idPersona;
    private String nombre;
    private String apellido;
    private String dui;
    private String nit;
    private String sexo;
    private String fechaNac;
    private String direccion;
    private String email;
    private String telefono;
    private int idTipoPersona;

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String apellido, String dui, String nit, String sexo, String fechaNac, String direccion, String email, String telefono, int idTipoPersona) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
        this.nit = nit;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.idTipoPersona = idTipoPersona;
    }

    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }
    
    
    

   
}
