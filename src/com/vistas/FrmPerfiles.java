
package com.vistas;

import com.dao.DaoPerfil;
import com.modelo.Perfil;
import static java.awt.Frame.ICONIFIED;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *Nombre de la clase: FrmPerfiles
 * Version: 1.0
 * Fecha: 14-07-2018
 * CopyRight:ITCA-FEPADE
 * @Author: GRUPO#3 
 */
public class FrmPerfiles extends javax.swing.JInternalFrame {

  
    public FrmPerfiles() {
        initComponents();
        tablaPerfil();
    }
    
    Perfil perfil=new Perfil();
    DaoPerfil daoperfil=new DaoPerfil();
    
    public void tablaPerfil()
    {
        String [] columnas = {"id","perfil"};
        Object [] obj=new Object[2];
        DefaultTableModel tabla = new DefaultTableModel(null,columnas);
        List ls;
       try
        {
            ls = daoperfil.mostrarPerfil();
            for (int i=0; i<ls.size(); i++)
            {
                perfil=(Perfil)ls.get(i);
                obj[0]=perfil.getIdPerfil();
                obj[1]=perfil.getPerfil();
                
                tabla.addRow(obj);
            }
            ls=daoperfil.mostrarPerfil();
            this.JTbPerfil.setModel(tabla);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error al mostrar datos" + e.toString());
        }
    }
    
    public void insertar ()throws Exception
    {
        perfil.setIdPerfil(ICONIFIED);
        perfil.setPerfil(this.txtPerfil.getText());
        daoperfil.insertarPerfil(perfil);
        JOptionPane.showMessageDialog(null, "Datos insertados con exito");
        tablaPerfil();
        limpiar();
    }
     
     public void limpiar()
    {
        this.txtIdPerfil.setText("");
        this.txtPerfil.setText("");
    }
     
       public void llenarTabla()
    {
        int fila = this.JTbPerfil.getSelectedRow();
        this.txtIdPerfil.setText(String.valueOf(this.JTbPerfil.getValueAt(fila,0)));
        this.txtPerfil.setText(String.valueOf(this.JTbPerfil.getValueAt(fila,1)));
    }
    
    
    public void modificar ()
    {
        try 
        {
            perfil.setIdPerfil(Integer.parseInt(this.txtIdPerfil.getText()));
            perfil.setPerfil(this.txtPerfil.getText());
            int SiONo=JOptionPane.showConfirmDialog(this, "Desea modificar el Perfil","Modificar Perfil",JOptionPane.YES_NO_OPTION);
            
             if (SiONo==0)
            {
                daoperfil.modificarPerfil(perfil);
                JOptionPane.showMessageDialog(rootPane, "Perfil modificado con exito","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                tablaPerfil();
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
            perfil.setIdPerfil(Integer.parseInt(this.txtIdPerfil.getText()));
            int SiONo=JOptionPane.showConfirmDialog(this, "Desea eliminar el Perfil?","Eliminar Perfil",JOptionPane.YES_NO_OPTION);
            
            if (SiONo==0)
            {
                daoperfil.eliminarPerfil(perfil);
                JOptionPane.showMessageDialog(rootPane, "Perfil eliminado con exito","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                tablaPerfil();
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
        txtIdPerfil = new javax.swing.JTextField();
        txtPerfil = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTbPerfil = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("DATOS PERFIL DE USUARIOS");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("PERFIL:");

        txtIdPerfil.setEnabled(false);

        txtPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerfilActionPerformed(evt);
            }
        });

        JTbPerfil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "PERFIL"
            }
        ));
        JTbPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTbPerfilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTbPerfil);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar)
                    .addComponent(btnLimpiar))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIdPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel1)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPerfilActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        try {
            insertar();
        } catch (Exception ex) {
            Logger.getLogger(FrmTipoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablaPerfil();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void JTbPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTbPerfilMouseClicked
        llenarTabla();
    }//GEN-LAST:event_JTbPerfilMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        modificar();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        eliminar();
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTbPerfil;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtIdPerfil;
    private javax.swing.JTextField txtPerfil;
    // End of variables declaration//GEN-END:variables
}
