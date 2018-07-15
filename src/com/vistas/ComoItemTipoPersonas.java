package com.vistas;

/**
*  Nombre de la clase: ComoItemTipoPersonas
 * Fecha:14-07-2018
 * Versión: 1.0
 * CopyRight:ITCA-FEPADE
 * @author: GRUPO#3
 */

public class ComoItemTipoPersonas 
{
    
    private int value;
    private String label;

    public ComoItemTipoPersonas() {
    }

    public ComoItemTipoPersonas(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
    
    
    
    
}
