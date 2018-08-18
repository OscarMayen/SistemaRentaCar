
package com.vistas;

import com.dao.DaoAgencia;
import com.modelo.Agencia;
import static java.awt.Frame.ICONIFIED;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class FrmAgencias extends javax.swing.JInternalFrame {

    
    public FrmAgencias() {
        initComponents();
        tablaAgencia();
    }

    Agencia agen = new Agencia();
    DaoAgencia daoAgen = new DaoAgencia();
    
    
   public void tablaAgencia()
    {
        String [] columnas = {"ID","AGENCIA","TELEFONO","DIRECCION","EMAIL"};
        Object [] obj=new Object[5];
        DefaultTableModel tabla = new DefaultTableModel(null,columnas);
        List ls;
       try
        {
            ls = daoAgen.mostrarAgencia();
            for (int i=0; i<ls.size(); i++)
            {
                agen=(Agencia)ls.get(i);
                obj[0]=agen.getIdAgencia();
                obj[1]=agen.getNombreAgencia();
                obj[2]=agen.getTelefonoAgencia();
                obj[3]=agen.getDireccionAgencia();
                obj[4]=agen.getEmailAgencia();
                tabla.addRow(obj);
            }
            ls=daoAgen.mostrarAgencia();
            this.JtbAgencia.setModel(tabla);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error al mostrar datos" + e.toString());
        }
    }
    
    public void insertar ()throws Exception
    {
        agen.setIdAgencia(ICONIFIED);
        agen.setNombreAgencia(this.txtNombre.getText());
        agen.setTelefonoAgencia(this.txtTelefono.getText());
        agen.setDireccionAgencia(this.txtDireccion.getText());
        agen.setEmailAgencia(this.txtEmail.getText());
        daoAgen.insertarAgencia(agen);
        JOptionPane.showMessageDialog(null, "Datos insertados con exito");
        tablaAgencia();
        limpiar();
    }
     
     public void limpiar()
    {
        this.txtIdAgendia.setText("");
        this.txtNombre.setText("");
        this.txtTelefono.setText("");
        this.txtDireccion.setText("");
        this.txtEmail.setText("");
    }
     
       public void llenarTabla()
    {
        int fila = this.JtbAgencia.getSelectedRow();
        this.txtIdAgendia.setText(String.valueOf(this.JtbAgencia.getValueAt(fila,0)));
        this.txtNombre.setText(String.valueOf(this.JtbAgencia.getValueAt(fila,1)));
        this.txtTelefono.setText(String.valueOf(this.JtbAgencia.getValueAt(fila,2)));
        this.txtDireccion.setText(String.valueOf(this.JtbAgencia.getValueAt(fila,3)));
        this.txtEmail.setText(String.valueOf(this.JtbAgencia.getValueAt(fila,4)));
    }
    
    
    public void modificar ()
    {
        try 
        {
            agen.setIdAgencia(Integer.parseInt(this.txtIdAgendia.getText()));
            agen.setNombreAgencia(this.txtNombre.getText());
            agen.setTelefonoAgencia(this.txtTelefono.getText());
            agen.setDireccionAgencia(this.txtDireccion.getText());
            agen.setEmailAgencia(this.txtEmail.getText());
            
            int SiONo=JOptionPane.showConfirmDialog(this, "Desea modificar la Agencia","Modificar Agencia",JOptionPane.YES_NO_OPTION);
            
             if (SiONo==0)
            {
                daoAgen.modificarAgencia(agen);
                JOptionPane.showMessageDialog(rootPane, "Agencia modificada con exito","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                tablaAgencia();
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
            agen.setIdAgencia(Integer.parseInt(this.txtIdAgendia.getText()));
            int SiONo=JOptionPane.showConfirmDialog(this, "Desea eliminar el Agencia?","Eliminar Agencia",JOptionPane.YES_NO_OPTION);
            
            if (SiONo==0)
            {
                daoAgen.eliminarAgencia(agen);
                JOptionPane.showMessageDialog(rootPane, "Agencia eliminado con exito","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                tablaAgencia();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdAgendia = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtbAgencia = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BtnGuardar = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("DATOS AGENCIA");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("AGENCIA:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("TELEFONO:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("DIRECCION:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("EMAIL:");

        txtIdAgendia.setEnabled(false);

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(503)+####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        JtbAgencia.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        JtbAgencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "AGENCIA", "TELEFONO", "DIRECCION", "EMAIL"
            }
        ));
        JtbAgencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtbAgenciaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JtbAgencia);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        BtnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/GUARDAR1.png"))); // NOI18N
        BtnGuardar.setText("GUARDAR");
        BtnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnGuardarMouseClicked(evt);
            }
        });

        BtnEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/editar1.png"))); // NOI18N
        BtnEditar.setText("EDITAR");
        BtnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEditarMouseClicked(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/eliminar2.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/limpiar1.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
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
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardar)
                    .addComponent(BtnEditar))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel2)
                                .addGap(59, 59, 59)
                                .addComponent(txtIdAgendia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel3)
                                        .addGap(21, 21, 21))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccion)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtIdAgendia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtbAgenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtbAgenciaMouseClicked
        llenarTabla();
    }//GEN-LAST:event_JtbAgenciaMouseClicked

    private void BtnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnGuardarMouseClicked
        try {
            insertar();
        } catch (Exception ex) {
            Logger.getLogger(FrmAgencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnGuardarMouseClicked

    private void BtnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEditarMouseClicked
        modificar();
    }//GEN-LAST:event_BtnEditarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        eliminar();
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JTable JtbAgencia;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdAgendia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
