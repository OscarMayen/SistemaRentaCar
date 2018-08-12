/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.dao.DaoTipoPersona;
import com.modelo.TipoPersona;
import static java.awt.Frame.ICONIFIED;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *Nombre de la clase: FrmTipoPersona
 * Version: 1.0
 * Fecha: 14-07-2018
 * CopyRight:ITCA-FEPADE
 * @Author: GRUPO#3 
 */
public class FrmTipoPersona extends javax.swing.JInternalFrame {

    
    public FrmTipoPersona() 
    {
        initComponents();
        tablaTipoPersona();
    }
    
    TipoPersona tipoP=new TipoPersona();
    DaoTipoPersona daotp=new DaoTipoPersona();
    
    public void tablaTipoPersona()
    {
        String [] columnas = {"id","Tipo"};
        Object [] obj=new Object[2];
        DefaultTableModel tabla = new DefaultTableModel(null,columnas);
        List ls;
       try
        {
            ls = daotp.mostrarTipoPersona();
            for (int i=0; i<ls.size(); i++)
            {
                tipoP=(TipoPersona)ls.get(i);
                obj[0]=tipoP.getIdTipoPersona();
                obj[1]=tipoP.getTipo();
                
                tabla.addRow(obj);
            }
            ls=daotp.mostrarTipoPersona();
            this.JTbTipoPersonas.setModel(tabla);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error al mostrar datos" + e.toString());
        }
    }
    
    public void insertar ()throws Exception
    {
        tipoP.setIdTipoPersona(ICONIFIED);
        tipoP.setTipo(this.txtTipo.getText());
        daotp.insertarTipoPersona(tipoP);
        JOptionPane.showMessageDialog(null, "Datos insertados con exito");
        limpiar();
   }
    
    
     public void limpiar()
     {
        this.txtIdTipoPersona.setText("");
        this.txtTipo.setText("");
     }
     
    public void llenarTabla()
    {
        int fila = this.JTbTipoPersonas.getSelectedRow();
        this.txtIdTipoPersona.setText(String.valueOf(this.JTbTipoPersonas.getValueAt(fila,0)));
        this.txtTipo.setText(String.valueOf(this.JTbTipoPersonas.getValueAt(fila,1)));
    }
     
     public void modificar ()
     {
         try 
         {
            tipoP.setIdTipoPersona(Integer.parseInt(this.txtIdTipoPersona.getText()));
            tipoP.setTipo(this.txtTipo.getText());
            int SiONo=JOptionPane.showConfirmDialog(this, "Desea modificar el Tipo de Persona","Modificar Tipo de Persona",JOptionPane.YES_NO_OPTION);
            
             if (SiONo==0)
            {
                daotp.modificarTipoPersona(tipoP);
                JOptionPane.showMessageDialog(rootPane, "Tipo de Persona modificado con exito","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                tablaTipoPersona();
                limpiar();
            }
             
             else
             {
                 limpiar();
             }
         } 
        
         catch (Exception ex) 
         {
           ex.printStackTrace();
         }
     
     }
     
     public void eliminar()
     {
          try 
         {
            tipoP.setIdTipoPersona(Integer.parseInt(this.txtIdTipoPersona.getText()));
            int SiONo=JOptionPane.showConfirmDialog(this, "Desea eliminar el Tipo Persona?","Eliminar Tipo Persona",JOptionPane.YES_NO_OPTION);
            
             if (SiONo==0)
            {
                daotp.eliminarTipoPersona(tipoP);
                JOptionPane.showMessageDialog(rootPane, "Tipo Persona eliminado con exito","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                tablaTipoPersona();
                limpiar();
            }
             
             else
             {
                 limpiar();
             }
         } 
        
         
         catch (Exception ex) 
         {
           JOptionPane.showMessageDialog(rootPane, ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
                   
         }
     }
     
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdTipoPersona = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTbTipoPersonas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("TIPOS DE PERSONAS");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("TIPO:");

        txtIdTipoPersona.setEnabled(false);

        JTbTipoPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "TIPO"
            }
        ));
        JTbTipoPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTbTipoPersonasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTbTipoPersonas);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/GUARDAR1.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/editar1.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/eliminar2.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/limpiar1.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        try {
            insertar();
        } catch (Exception ex) {
            Logger.getLogger(FrmTipoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablaTipoPersona();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void JTbTipoPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTbTipoPersonasMouseClicked
        llenarTabla();
    }//GEN-LAST:event_JTbTipoPersonasMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        modificar();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
       limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        eliminar();
    }//GEN-LAST:event_btnEliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTbTipoPersonas;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtIdTipoPersona;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
