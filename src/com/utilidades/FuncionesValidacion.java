package com.utilidades;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 * Nombre de la clase: FuncionesValidacion
 * Fecha:14-07-2018
 * Versión: 1.0
 * CopyRight:ITCA-FEPADE
 * @author: Grupo#3
 */
public final class FuncionesValidacion {

    //<editor-fold defaultstate="list" desc="metodos y funciones">

    /**
     * validar solo numeros
     *
     * @param evt
     */
    public void numbersOnly(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    /**
     * validar solo palabras
     *
     * @param evt
     */
    public void wordsOnly(KeyEvent evt) {
        if (!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }

    public boolean IsNullOrEmpty(String val) {

        if (val.equals("")) {
            return true;
        }
        if (val.length() == 0) {
            return true;
        }
        if (val == null) {
            return true;
        }
        return false;
    }

//</editor-fold>
}
