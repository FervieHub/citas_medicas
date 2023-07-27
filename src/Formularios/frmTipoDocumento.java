/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
*/
package Formularios;

import ConexionDB.ConexionClinica;
import Entidades.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmTipoDocumento extends javax.swing.JInternalFrame {
    Connection con3 = null;
    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel TablaTipoDocumento = new DefaultTableModel();
    String transaccion = "";

    /**
     * Creates new form frmTipoDocumento
     */
    public frmTipoDocumento() {        
        initComponents();
        Deshabilitar();
        CargarTipoDocumento();
    }
    
    public void Habilitar(){
        //txtId.setEnabled(true);
        txtNombre.setEnabled(true);
        txtDescripcion.setEnabled(true);
        chkEstado.setEnabled(true);
        
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        jTabbedPane1.setSelectedIndex(1);
    }
    
    public void Deshabilitar(){
        txtId.setEnabled(false);
        txtNombre.setEnabled(false);
        txtDescripcion.setEnabled(false);
        chkEstado.setEnabled(false);
        
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        jTabbedPane1.setSelectedIndex(0);
    }
    
    public void Limpiar(){
        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        chkEstado.setSelected(false);
    }
    
    public void CargarTipoDocumento(){
        String titulos[] = {"N°", "Id", "Nombre", "Descripción"};
        TablaTipoDocumento = new DefaultTableModel(null, titulos);
        String[] registros = new String[100];
        String SQLBuscar = "Select id, nombre, descripcion, estado FROM vst_tipodocumento ORDER BY nombre ASC";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            int count = 0;
            
            while (rs.next()) {
                count++;
                registros[0] = String.valueOf(count);
                registros[1] = rs.getString("id");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("descripcion");
                TablaTipoDocumento.addRow(registros);
            }
            
            tblTipoDocumento.setModel(TablaTipoDocumento);
            
            tblTipoDocumento.getColumnModel().getColumn(0).setPreferredWidth(50);
            
            tblTipoDocumento.getColumnModel().getColumn(1).setMaxWidth(0);
            tblTipoDocumento.getColumnModel().getColumn(1).setMinWidth(0);
            tblTipoDocumento.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            tblTipoDocumento.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
            
            tblTipoDocumento.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblTipoDocumento.getColumnModel().getColumn(3).setPreferredWidth(200);
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void SearchTipoDocumento(){
        String SQLBuscar = "Select id, nombre, descripcion, estado FROM vst_tipodocumento WHERE id = " + this.txtId.getText();
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            int count = 0;
            
            while (rs.next()) {
                txtNombre.setText(rs.getString("nombre"));
                txtDescripcion.setText(rs.getString("descripcion"));
                chkEstado.setSelected(rs.getBoolean("estado"));
            }
            
            tblTipoDocumento.setModel(TablaTipoDocumento);
            
            tblTipoDocumento.getColumnModel().getColumn(0).setPreferredWidth(50);
            
            tblTipoDocumento.getColumnModel().getColumn(1).setMaxWidth(0);
            tblTipoDocumento.getColumnModel().getColumn(1).setMinWidth(0);
            tblTipoDocumento.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            tblTipoDocumento.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
            
            tblTipoDocumento.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblTipoDocumento.getColumnModel().getColumn(3).setPreferredWidth(200);
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Panel_Detalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoDocumento = new javax.swing.JTable();
        PanelEdita = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        chkEstado = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setTitle("Perfil");

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 102, 255));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 102, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(0, 102, 255));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        tblTipoDocumento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "Id", "Turno", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTipoDocumento.setColumnSelectionAllowed(true);
        tblTipoDocumento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTipoDocumento.getTableHeader().setReorderingAllowed(false);
        tblTipoDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoDocumentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTipoDocumento);
        tblTipoDocumento.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblTipoDocumento.getColumnModel().getColumnCount() > 0) {
            tblTipoDocumento.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblTipoDocumento.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblTipoDocumento.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        javax.swing.GroupLayout Panel_DetalleLayout = new javax.swing.GroupLayout(Panel_Detalle);
        Panel_Detalle.setLayout(Panel_DetalleLayout);
        Panel_DetalleLayout.setHorizontalGroup(
            Panel_DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_DetalleLayout.setVerticalGroup(
            Panel_DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("", Panel_Detalle);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Id");
        jLabel1.setToolTipText("");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripción");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Estado");

        chkEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkEstado.setText("Activo");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 102, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 102, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEditaLayout = new javax.swing.GroupLayout(PanelEdita);
        PanelEdita.setLayout(PanelEditaLayout);
        PanelEditaLayout.setHorizontalGroup(
            PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PanelEditaLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(130, 130, 130))
                        .addGroup(PanelEditaLayout.createSequentialGroup()
                            .addGroup(PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(chkEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombre))))
                    .addGroup(PanelEditaLayout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        PanelEditaLayout.setVerticalGroup(
            PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkEstado)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(PanelEditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("", PanelEdita);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("MANTENIMIENTO DE DISTRITOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        Habilitar();
        Limpiar();
        transaccion="Nuevo";
        txtNombre.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Deshabilitar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Habilitar();
        transaccion="Editar";
        txtNombre.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed
    
    private void tblTipoDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoDocumentoMouseClicked
        // TODO add your handling code here:
        int seleccionar = tblTipoDocumento.rowAtPoint(evt.getPoint());
        
        txtId.setText(String.valueOf(tblTipoDocumento.getValueAt(seleccionar, 1)));
        SearchTipoDocumento();
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_tblTipoDocumentoMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(txtDescripcion.getText()==""){
            JOptionPane.showMessageDialog(null, "Ingrese la descripción del perfil");
        }else{
            String SQLGuardar = "";
            
            Connection con1 = null;
            ConexionClinica conectado = new ConexionClinica();
            con1 = conectado.getConexion();
            //Statement st = con1.createStatement();
            
            if(transaccion=="Nuevo"){
                SQLGuardar = "INSERT INTO tbl_tipodocumento (tipodocumento_nombre, tipodocumento_descripcion, tipodocumento_estado) VALUES ('" + this.txtNombre.getText().toUpperCase() + "', '" + this.txtDescripcion.getText().toUpperCase() + "', " + this.chkEstado.isSelected() + ")";
            }else{
                SQLGuardar = "UPDATE tbl_tipodocumento SET tipodocumento_nombre = '" + this.txtNombre.getText().toUpperCase() + "', tipodocumento_descripcion = '" + this.txtDescripcion.getText().toUpperCase() + "', tipodocumento_estado = " + this.chkEstado.isSelected() + " WHERE id_tipodocumento = " + this.txtId.getText();
            }
            
            try {
                PreparedStatement pst = con1.prepareCall(SQLGuardar);
                
                int n = pst.executeUpdate();
                pst.close();
                
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");                   
                    Deshabilitar();
                    CargarTipoDocumento();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos \n" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEdita;
    private javax.swing.JPanel Panel_Detalle;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblTipoDocumento;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
