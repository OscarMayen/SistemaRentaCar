
package com.vistas;

import com.dao.DaoCliente;
import com.modelo.Cliente;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *Nombre de la clase: FrmDatosPersonalesClientes
 * Version: 1.0
 * Fecha: 06-08-2018
 * CopyRight:ITCA-FEPADE
 * @Author: GRUPO#3 
 */
public class FrmDatosPersonalesClientes extends javax.swing.JInternalFrame {

    
    public FrmDatosPersonalesClientes() {
        initComponents();
        tablaClientes();
    }

    Cliente cli = new Cliente();
    DaoCliente daoCli = new DaoCliente();
    
    public void tablaClientes()
    {
        String [] columnas = {"idCliente","fechaIngreso","licencia","lugarDeTrabado","tipoCliente",
        "idPersona","estado"};
        Object [] obj=new Object[7];
        DefaultTableModel tabla = new DefaultTableModel(null,columnas);
        List ls;
       try
        {
            ls = daoCli.mostrarCliente();
            for (int i=0; i<ls.size(); i++)
            {
                cli=(Cliente)ls.get(i);
                obj[0]=cli.getIdCliente();
                obj[1]=cli.getFechaIngreso();
                obj[2]=cli.getLicencia();
                obj[3]=cli.getLugarDeTrabajo();
                obj[4]=cli.getTipoCliente();
                obj[5]=cli.getIdPersona();
                obj[6]=cli.getEstado();
                tabla.addRow(obj);
            }
            ls=daoCli.mostrarCliente();
            this.JtbDatosCliente.setModel(tabla);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error al mostrar datos" + e.toString());
        }
    }
    
    public void llenarTabla()
    {
        int fila = this.JtbDatosCliente.getSelectedRow();
        this.txtIdCliente.setText(String.valueOf(this.JtbDatosCliente.getValueAt(fila,0)));
        String fecha = String.valueOf(this.JtbDatosCliente.getValueAt(fila, 1));
        //this.txtCalendario.setDateFormatString(fecha);
        this.txtNumLicencia.setText(String.valueOf(this.JtbDatosCliente.getValueAt(fila,2)));
        this.txtLugarTrabajo.setText(String.valueOf(this.JtbDatosCliente.getValueAt(fila,3)));
        String tipoCliente = String.valueOf(this.JtbDatosCliente.getValueAt(fila, 4));
        if (tipoCliente.equals("Comun")) {
                this.cmbTipoCliente.setSelectedIndex(0);
            } 
        else if(tipoCliente.equals("Frecuente"))
        {
            this.cmbTipoCliente.setSelectedIndex(1);
        }
        else{
               this.cmbTipoCliente.setSelectedIndex(2);
            }
        
        this.txtAsignacion.setText(String.valueOf(this.JtbDatosCliente.getValueAt(fila,5)));
        String estado = String.valueOf(this.JtbDatosCliente.getValueAt(fila, 6));
        if (estado.toUpperCase().equals("ACTIVO")) {
                RbActivo.setSelected(true);
            } else {
                RbInactivo.setSelected(true);
            }
        
    }
    
    public void limpiar()
     {
        this.txtIdCliente.setText("");
        this.txtNumLicencia.setText("");
        this.txtLugarTrabajo.setText("");
        this.buttonGroup1.clearSelection();
        this.txtAsignacion.setText("");
        this.cmbTipoCliente.setSelectedIndex(0);
     }
    
    public void modificarCliente()
     {
         
         try 
         {
             String dia = Integer.toString(txtCalendario.getCalendar().get(Calendar.DAY_OF_MONTH));
             String mes = Integer.toString(txtCalendario.getCalendar().get(Calendar.MONTH) + 1);
             String anio = Integer.toString(txtCalendario.getCalendar().get(Calendar.YEAR));
             String fecha = (anio + "/" + mes + "/" + dia);
             
            cli.setIdCliente(Integer.parseInt(this.txtIdCliente.getText()));
            cli.setFechaIngreso(fecha);
            cli.setLicencia(this.txtNumLicencia.getText());
            cli.setLugarDeTrabajo(this.txtLugarTrabajo.getText());
            cli.setTipoCliente(this.cmbTipoCliente.getSelectedItem().toString());
             if (this.RbActivo.isSelected()) {
                 cli.setEstado("Activo");
             } else {
                 cli.setEstado("Inactivo");
             }
            cli.setIdPersona(Integer.parseInt(this.txtAsignacion.getText()));
            int SiONo=JOptionPane.showConfirmDialog(this, "Desea modificar el cliente","Modificar Empleado",JOptionPane.YES_NO_OPTION);
            
             if (SiONo==0)
            {
                daoCli.modificarCliente(cli);
                JOptionPane.showMessageDialog(rootPane, "Cliente modificado con exito","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                tablaClientes();
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
     
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtCalendario = new com.toedter.calendar.JDateChooser();
        txtNumLicencia = new javax.swing.JFormattedTextField();
        txtLugarTrabajo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbTipoCliente = new javax.swing.JComboBox<>();
        RbActivo = new javax.swing.JRadioButton();
        RbInactivo = new javax.swing.JRadioButton();
        txtAsignacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtbDatosCliente = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("DATOS PERSONALES DE CLIENTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("FECHA DE INGRESO:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("NO. LICENCIA:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("LUGAR DE TRABAJO:");

        txtIdCliente.setEnabled(false);

        txtCalendario.setDateFormatString("dd-MM-yyyy");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("TIPO DE CLIENTE:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("ESTADO:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("ASIGNACION:");

        cmbTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comun", "Frecuente", "VIP" }));

        buttonGroup1.add(RbActivo);
        RbActivo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        RbActivo.setText("ACTIVO");

        buttonGroup1.add(RbInactivo);
        RbInactivo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        RbInactivo.setText("INACTIVO");

        txtAsignacion.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(txtCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(RbInactivo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RbActivo)
                                    .addComponent(txtAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLugarTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RbActivo)
                        .addComponent(RbInactivo)
                        .addComponent(jLabel7)))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLugarTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        JtbDatosCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Fecha de ingreso", "No. de licencia", "lugar de trabajo", "tipo de cliente", "estado", "asignacion"
            }
        ));
        JtbDatosCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtbDatosClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JtbDatosCliente);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/editar1.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/limpiar1.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/buscar1.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(27, 27, 27)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnLimpiar)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtbDatosClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtbDatosClienteMouseClicked
        llenarTabla();
    }//GEN-LAST:event_JtbDatosClienteMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        modificarCliente();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
       
    }//GEN-LAST:event_btnBuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtbDatosCliente;
    private javax.swing.JRadioButton RbActivo;
    private javax.swing.JRadioButton RbInactivo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbTipoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAsignacion;
    private com.toedter.calendar.JDateChooser txtCalendario;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtLugarTrabajo;
    private javax.swing.JFormattedTextField txtNumLicencia;
    // End of variables declaration//GEN-END:variables
}
