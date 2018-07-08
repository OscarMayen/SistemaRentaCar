
package com.modelo;

/**
 *Nombre de la clase: TipoPersona
 * Fecha:07-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEDEPADE
 * @Author: GRUPO#3
 */
public class TipoPersona 
{
    private int idTipoPersona;
    private String tipo;

    public TipoPersona() {
    }

    public TipoPersona(int idTipoPersona, String tipo) {
        this.idTipoPersona = idTipoPersona;
        this.tipo = tipo;
    }

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
}
