
package com.vistas;

/**
 *Nombre de la clase: ComboItemDepartamento
 *Fecha:09-08-2018
 *Version: 1.0
 *CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */

//
public class ComboItemDepartamento 
{
    
    private int value;
    private String label;

    public ComboItemDepartamento() {
    }

    public ComboItemDepartamento(int value, String label) {
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
