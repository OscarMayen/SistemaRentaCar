
package com.vistas;

import com.dao.DaoAgencia;
import com.dao.DaoVehiculo;
import com.modelo.Agencia;
import com.modelo.Vehiculo;
import com.utilidades.FuncionesValidacion;
import static java.awt.Frame.ICONIFIED;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class FrmVehiculo extends javax.swing.JInternalFrame {

    
    public FrmVehiculo() throws Exception {
        initComponents();
        tablaVehiculo();
        cargarComboAgencia(cmbAgencia, daoAgen.mostrarAgencia());
    }

    Vehiculo vehi = new Vehiculo();
    Agencia agen = new Agencia();
    DaoVehiculo daoVe = new DaoVehiculo();
    DaoAgencia daoAgen = new DaoAgencia();
    
    FuncionesValidacion validacion = new FuncionesValidacion();
    
    private void cargarComboAgencia(JComboBox combo, ArrayList<Agencia> list) throws Exception {

        for (Agencia item : list) {
            combo.addItem(new ComboItemAgencia(item.getIdAgencia(), item.getNombreAgencia()));
        }
    }
    
    public void tablaVehiculo()
    {
        String [] columnas = {"ID","MARCA","COLOR","TIPO","AÑO","CAPACIDAD","NO. MOTOR","NO. CHASIS",
        "PLACA","TARJETA VENC","PAIS","AGENCIA","PRECIO ALQUILER","ESTADO"};
        Object [] obj=new Object[14];
        DefaultTableModel tabla = new DefaultTableModel(null,columnas);
        List ls;
       try
        {
            ls = daoVe.mostrarVehiculo();
            for (int i=0; i<ls.size(); i++)
            {   
                vehi=(Vehiculo)ls.get(i);
                obj[0]=vehi.getIdVehiculo();
                obj[1]=vehi.getMarca();
                obj[2]=vehi.getColor();
                obj[3]=vehi.getTipoVehiculo();
                obj[4]=vehi.getAño();
                obj[5]=vehi.getCapacidad();
                obj[6]=vehi.getNumMotor();
                obj[7]=vehi.getNumChasis();
                obj[8]=vehi.getNumPlacas();
                obj[9]=vehi.getTarjetaVencimiento();
                obj[10]=vehi.getPaisProcedencia();
                obj[11] = daoAgen.getAgencia(vehi.getIdAgencia()).getNombreAgencia();
                obj[12]=vehi.getPrecioAlquiler();
                obj[13]=vehi.getEstado();
                tabla.addRow(obj);
            }
            ls=daoVe.mostrarVehiculo();
            this.JtbVehiculos.setModel(tabla);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error al mostrar datos" + e.toString());
        }
    }
    
    
    
   public void insertarVehiculo ()throws Exception
    {
        
        String dia=Integer.toString(txtVencimientoTar.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes=Integer.toString(txtVencimientoTar.getCalendar().get(Calendar.MONTH)+1);
        String anio=Integer.toString(txtVencimientoTar.getCalendar().get(Calendar.YEAR));
        String fecha= (anio + "/" + mes + "/" + dia);
        
        vehi.setIdVehiculo(ICONIFIED);
        vehi.setMarca(this.txtMarca.getText());
        vehi.setColor(this.txtColor.getText());
        vehi.setTipoVehiculo(this.txtTipoVehiculo.getText());
        vehi.setAño(Integer.parseInt(this.spAnio.getValue().toString()));
        vehi.setCapacidad(Integer.parseInt(this.spCapacidad.getValue().toString()));
        vehi.setNumMotor(this.txtNumMotor.getText());
        vehi.setNumChasis(this.txtNumChasis.getText());
        vehi.setNumPlacas(this.txtNumPlacas.getText());
        vehi.setTarjetaVencimiento(fecha);
        vehi.setPaisProcedencia(this.txtPais.getText());
        vehi.setPrecioAlquiler(Double.parseDouble(this.txtPrecioAlquiler.getText()));
        if(this.RbDisponible.isSelected())
        {
            vehi.setEstado("DISPONIBLE");
        }
        else
        {
            vehi.setEstado("ALQUILADO");
        }
        ComboItemAgencia vh = (ComboItemAgencia)cmbAgencia.getSelectedItem();
        int codigo = vh.getValue();
        String nombre = vh.getLabel();
        
        vehi.setIdAgencia(codigo);
        daoVe.insertarVehiculo(vehi);
        JOptionPane.showMessageDialog(null, "Datos insertados con exito");
        tablaVehiculo();
        limpiar();
   }
    
   public void limpiar()
    {
        this.txtIdVechiculo.setText("");
        this.txtMarca.setText("");
        this.txtColor.setText("");
        this.txtTipoVehiculo.setText("");
        this.spAnio.setValue(1900);
        this.spCapacidad.setValue(0);
        this.txtNumMotor.setText("");
        this.txtNumChasis.setText("");
        this.txtNumPlacas.setText("");
        this.txtVencimientoTar.setDate(null);
        this.txtPais.setText("");
        this.txtPrecioAlquiler.setText("");
        this.buttonGroup1.clearSelection();
        cmbAgencia.setSelectedIndex(0);
    }
     
       public void llenarTabla()
    {
        int fila = this.JtbVehiculos.getSelectedRow();
        
        this.txtIdVechiculo.setText(String.valueOf(this.JtbVehiculos.getValueAt(fila,0)));
        this.txtMarca.setText(String.valueOf(this.JtbVehiculos.getValueAt(fila,1)));
        this.txtColor.setText(String.valueOf(this.JtbVehiculos.getValueAt(fila,2)));
        this.txtTipoVehiculo.setText(String.valueOf(this.JtbVehiculos.getValueAt(fila,3)));
        int anioVehiculo = Integer.parseInt(this.JtbVehiculos.getValueAt(fila, 4).toString());
        spAnio.setValue(anioVehiculo);
        int capacidad = Integer.parseInt(this.JtbVehiculos.getValueAt(fila, 5).toString());
        spCapacidad.setValue(capacidad);
        this.txtNumMotor.setText(String.valueOf(this.JtbVehiculos.getValueAt(fila,6)));
        this.txtNumChasis.setText(String.valueOf(this.JtbVehiculos.getValueAt(fila,7)));
        this.txtNumPlacas.setText(String.valueOf(this.JtbVehiculos.getValueAt(fila,8)));
        this.txtPais.setText(String.valueOf(this.JtbVehiculos.getValueAt(fila,10)));
        this.txtPrecioAlquiler.setText(String.valueOf(this.JtbVehiculos.getValueAt(fila,12)));
        String estado = String.valueOf(this.JtbVehiculos.getValueAt(fila, 13));
        if (estado.toUpperCase().equals("DISPONIBLE")) {
                RbDisponible.setSelected(true);
            } else {
                RbAlquilado.setSelected(true);
            }
        String agencia = String.valueOf(this.JtbVehiculos.getValueAt(fila, 11));
        cmbAgencia.getModel().setSelectedItem(agencia);
        
    }
       
       
    public void modificar ()
    {
        try 
        {
             String dia = Integer.toString(txtVencimientoTar.getCalendar().get(Calendar.DAY_OF_MONTH));
             String mes = Integer.toString(txtVencimientoTar.getCalendar().get(Calendar.MONTH) + 1);
             String anio = Integer.toString(txtVencimientoTar.getCalendar().get(Calendar.YEAR));
             String fecha = (anio + "/" + mes + "/" + dia);
             
            vehi.setIdVehiculo(Integer.parseInt(this.txtIdVechiculo.getText()));
            vehi.setMarca(this.txtMarca.getText());
            vehi.setColor(this.txtColor.getText());
            vehi.setTipoVehiculo(this.txtTipoVehiculo.getText());
            vehi.setAño(Integer.parseInt(this.spAnio.getValue().toString()));
            vehi.setCapacidad(Integer.parseInt(this.spCapacidad.getValue().toString()));
            vehi.setNumMotor(this.txtNumMotor.getText());
            vehi.setNumChasis(this.txtNumChasis.getText());
            vehi.setNumPlacas(this.txtNumPlacas.getText());
            vehi.setTarjetaVencimiento(fecha);
            vehi.setPaisProcedencia(this.txtPais.getText());
            vehi.setPrecioAlquiler(Double.parseDouble(this.txtPrecioAlquiler.getText()));
            if (this.RbDisponible.isSelected()) {
                vehi.setEstado("DISPONIBLE");
            } else {
                vehi.setEstado("ALQUILADO");
            }
            ComboItemAgencia veh = (ComboItemAgencia) cmbAgencia.getSelectedItem();
            int codigo = veh.getValue();
            String nombre = veh.getLabel();
            
            vehi.setIdAgencia(codigo);
            int SiONo = JOptionPane.showConfirmDialog(this, "Desea modificar el Vehiculo", "Modificar Vehiculo", JOptionPane.YES_NO_OPTION);
            
            if (SiONo == 0) {
                daoVe.modificarVehiculo(vehi);
                JOptionPane.showMessageDialog(rootPane, "Vehiculo modificado con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                tablaVehiculo();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdVechiculo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtTipoVehiculo = new javax.swing.JTextField();
        spAnio = new javax.swing.JSpinner();
        spCapacidad = new javax.swing.JSpinner();
        txtNumMotor = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNumChasis = new javax.swing.JFormattedTextField();
        txtNumPlacas = new javax.swing.JFormattedTextField();
        txtVencimientoTar = new com.toedter.calendar.JDateChooser();
        txtPais = new javax.swing.JTextField();
        txtPrecioAlquiler = new javax.swing.JTextField();
        RbDisponible = new javax.swing.JRadioButton();
        RbAlquilado = new javax.swing.JRadioButton();
        cmbAgencia = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtbVehiculos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("DATOS DE VEHICULO");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("MARCA:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("COLOR:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("TIPO:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("AÑO:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel8.setText("CAPACIDAD:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel9.setText("NO. MOTOR:");

        txtIdVechiculo.setEnabled(false);

        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaKeyTyped(evt);
            }
        });

        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorKeyTyped(evt);
            }
        });

        txtTipoVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoVehiculoKeyTyped(evt);
            }
        });

        spAnio.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2018, 1));

        spCapacidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel10.setText("NO. CHASIS:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel11.setText("NO. PLACAS:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel12.setText("VENCIMIENTO TARJETA:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel13.setText("PAIS:");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel14.setText("PRECIO DE ALQUILER:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel15.setText("ESTADO:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel16.setText("AGENCIA:");

        txtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaisKeyTyped(evt);
            }
        });

        txtPrecioAlquiler.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioAlquilerKeyTyped(evt);
            }
        });

        buttonGroup1.add(RbDisponible);
        RbDisponible.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        RbDisponible.setText("DISPONIBLE");

        buttonGroup1.add(RbAlquilado);
        RbAlquilado.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        RbAlquilado.setText("ALQUILADO");

        cmbAgencia.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        JtbVehiculos.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        JtbVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MARCA", "COLOR", "TIPO", "AÑO", "CAPACIDAD", "NO. MOTOR", "NO. CHASIS", "NO. PLACAS", "VENCIMINIENTO TARJETA", "PAIS", "PRECIO DE ALQUILER", "ESTADO", "AGENCIA"
            }
        ));
        JtbVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtbVehiculosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JtbVehiculos);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/GUARDAR1.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/editar1.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/buscar1.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("LISTADO DE VEHICULOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(59, 59, 59)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIdVechiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                            .addComponent(txtColor)
                                            .addComponent(txtTipoVehiculo)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNumMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNumChasis)
                                            .addComponent(txtNumPlacas)
                                            .addComponent(txtVencimientoTar, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(txtPais)
                                            .addComponent(txtPrecioAlquiler)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addGap(115, 115, 115)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(RbDisponible)
                                                .addGap(18, 18, 18)
                                                .addComponent(RbAlquilado)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdVechiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtNumChasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtNumPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addComponent(txtVencimientoTar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtPrecioAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(RbDisponible)
                                    .addComponent(RbAlquilado))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(cmbAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(spAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(spCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtNumMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(76, 76, 76)
                .addComponent(jLabel6)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(306, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        try {
            insertarVehiculo();
        } catch (Exception ex) {
            Logger.getLogger(FrmVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyTyped
        validacion.wordsOnly(evt);
    }//GEN-LAST:event_txtMarcaKeyTyped

    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
        validacion.wordsOnly(evt);
    }//GEN-LAST:event_txtColorKeyTyped

    private void txtTipoVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoVehiculoKeyTyped
        validacion.wordsOnly(evt);
    }//GEN-LAST:event_txtTipoVehiculoKeyTyped

    private void txtPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaisKeyTyped
        validacion.wordsOnly(evt);
    }//GEN-LAST:event_txtPaisKeyTyped

    private void txtPrecioAlquilerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioAlquilerKeyTyped
        validacion.numbersOnly(evt);
    }//GEN-LAST:event_txtPrecioAlquilerKeyTyped

    private void JtbVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtbVehiculosMouseClicked
        llenarTabla();
    }//GEN-LAST:event_JtbVehiculosMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        modificar();
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        ComboItemAgencia veh = (ComboItemAgencia) cmbAgencia.getSelectedItem();
            int codigo = veh.getValue();
            String nombre = veh.getLabel();
            
            JOptionPane.showMessageDialog(null, codigo);
    }//GEN-LAST:event_btnBuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtbVehiculos;
    private javax.swing.JRadioButton RbAlquilado;
    private javax.swing.JRadioButton RbDisponible;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbAgencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spAnio;
    private javax.swing.JSpinner spCapacidad;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtIdVechiculo;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JFormattedTextField txtNumChasis;
    private javax.swing.JFormattedTextField txtNumMotor;
    private javax.swing.JFormattedTextField txtNumPlacas;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtPrecioAlquiler;
    private javax.swing.JTextField txtTipoVehiculo;
    private com.toedter.calendar.JDateChooser txtVencimientoTar;
    // End of variables declaration//GEN-END:variables
}
