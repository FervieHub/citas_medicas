/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
*/
package Formularios;

import ConexionDB.ConexionBase;
import Entidades.*;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmUsuario extends javax.swing.JInternalFrame {
    Connection con3 = null;
    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel TablaUsuario = new DefaultTableModel();
    String transaccion = "";
    int idPersonal = 0;

    /**
     * Creates new form frmUsuario
     */
    public frmUsuario() {        
        initComponents();
        Deshabilitar();
        CargarUsuario();
    }
    
    public void Habilitar(){
        //txtId.setEnabled(true);
        txtNumero.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtContrasena.setEnabled(true);
        chkEstado.setEnabled(true);
        
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        
        idPersonal = 0;
    }
    
    public void Deshabilitar(){
        txtId.setEnabled(false);
        txtNumero.setEnabled(false);
        txtUsuario.setEnabled(false);
        txtContrasena.setEnabled(false);
        chkEstado.setEnabled(false);
        
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        
        idPersonal = 0;
    }
    
    public void Limpiar(){
        txtId.setText("");
        txtNumero.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");
        chkEstado.setSelected(false);
        
        idPersonal = 0;
    }
    
    public void CargarUsuario(){
        String titulos[] = {"N°", "Id", "N° Documento", "Usuario"};
        TablaUsuario = new DefaultTableModel(null, titulos);
        String[] registros = new String[100];
        String SQLBuscar = "SELECT * FROM vst_usuario ORDER BY usuario ASC";
        ConexionBase Conectado = new ConexionBase();
        con3 = Conectado.getConnection();
        
        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            int count = 0;
            
            while (rs.next()) {
                count++;
                registros[0] = String.valueOf(count);
                registros[1] = rs.getString("id");
                registros[2] = rs.getString("numero");
                registros[3] = rs.getString("usuario");
                TablaUsuario.addRow(registros);
            }
            
            tblUsuario.setModel(TablaUsuario);
            
            tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(50);
            
            tblUsuario.getColumnModel().getColumn(1).setMaxWidth(0);
            tblUsuario.getColumnModel().getColumn(1).setMinWidth(0);
            tblUsuario.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            tblUsuario.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
            
            tblUsuario.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblUsuario.getColumnModel().getColumn(3).setPreferredWidth(200);
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void SearchUsuario(){
        String SQLBuscar = "Select * FROM vst_usuario WHERE id = " + txtId.getText();
        ConexionBase Conectado = new ConexionBase();
        con3 = Conectado.getConnection();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            int count = 0;
            
            while (rs.next()) {
                txtNumero.setText(rs.getString("numero"));
                txtUsuario.setText(rs.getString("usuario"));
                txtContrasena.setText(rs.getString("contraseNa"));
                chkEstado.setSelected(rs.getBoolean("estado"));
            }
            
            tblUsuario.setModel(TablaUsuario);
            
            tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(50);
            
            tblUsuario.getColumnModel().getColumn(1).setMaxWidth(0);
            tblUsuario.getColumnModel().getColumn(1).setMinWidth(0);
            tblUsuario.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            tblUsuario.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
            
            tblUsuario.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblUsuario.getColumnModel().getColumn(3).setPreferredWidth(200);
            
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
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        txtUsuario = new javax.swing.JTextField();
        chkEstado = new javax.swing.JCheckBox();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();

        setTitle("Usuario");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Usuario");

        jLabel3.setText("Estado");

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "Id", "N° Documento", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuario.setColumnSelectionAllowed(true);
        tblUsuario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblUsuario.getTableHeader().setReorderingAllowed(false);
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuario);
        tblUsuario.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblUsuario.getColumnModel().getColumnCount() > 0) {
            tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblUsuario.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblUsuario.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        chkEstado.setText("Activo");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel4.setText("N° DNI");

        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroKeyReleased(evt);
            }
        });

        jLabel5.setText("Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNuevo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(chkEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtContrasena, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 91, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkEstado)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        txtNumero.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Deshabilitar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Habilitar();
        transaccion="Editar";
        txtNumero.setEnabled(false);
        txtNumero.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed
    
    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked
        // TODO add your handling code here:
        int seleccionar = tblUsuario.rowAtPoint(evt.getPoint());
        
        txtId.setText(String.valueOf(tblUsuario.getValueAt(seleccionar, 1)));
        SearchUsuario();
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_tblUsuarioMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(txtNumero.getText()==""){
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del género");
        }
        
        if(txtUsuario.getText()==""){
            JOptionPane.showMessageDialog(null, "Ingrese la descripción del género");
        }else{
            String SQLGuardar = "";
            
            Connection con1 = null;
            ConexionBase conectado = new ConexionBase();
            con1 = conectado.getConnection();
            //Statement st = con1.createStatement();
            
            if(transaccion=="Nuevo"){
                SQLGuardar = "INSERT INTO tbl_usuario (id_personal, usuario_nombre, usuario_contrasena, usuario_estado) VALUES (" + idPersonal + ", '" + txtUsuario.getText().toUpperCase() + "', '" + txtContrasena.getText().toUpperCase() + "', " + chkEstado.isSelected() + ")";
            }else{
                SQLGuardar = "UPDATE tbl_usuario SET usuario_nombre = '" + txtUsuario.getText().toUpperCase() + "', usuario_contrasena = '" + txtContrasena.getText().toUpperCase() + "', usuario_estado = " + chkEstado.isSelected() + " WHERE id_usuario = " + this.txtId.getText();
            }
            
            try {
                PreparedStatement pst = con1.prepareCall(SQLGuardar);
                
                int n = pst.executeUpdate();
                pst.close();
                
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    Deshabilitar();
                    CargarUsuario();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos \n" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String SQLBuscar = "SELECT * FROM vst_usuario WHERE numero = '" + txtNumero.getText() + "'";
            ConexionBase Conectado = new ConexionBase();
            con3 = Conectado.getConnection();
            boolean Verifica_Existe = false;

            try {
                st = (Statement) con3.createStatement();
                rs = st.executeQuery(SQLBuscar);

                while (rs.next()) {
                    Verifica_Existe = true;
                }
                
                st.close();
                
                if(Verifica_Existe == true){
                    btnGuardar.setEnabled(false);
                    idPersonal = 0;
                    JOptionPane.showMessageDialog(null, "El personal con ese núnero de documento, ya se encuentra registrado.");
                    return;
                }else{
                    btnGuardar.setEnabled(true);
                    
                    SQLBuscar = "SELECT * FROM vst_personal WHERE numero = '" + txtNumero.getText() + "'";
                    con3 = Conectado.getConnection();
                    boolean Verifica_Registro = false;
                    
                    st = (Statement) con3.createStatement();
                    rs = st.executeQuery(SQLBuscar);

                    while (rs.next()) {
                        idPersonal = Integer.valueOf(rs.getString("id"));
                        txtUsuario.setText(rs.getString("nombre"));
                        Verifica_Registro = true;
                        txtContrasena.requestFocus();
                    }

                    if(Verifica_Registro == false){
                        JOptionPane.showMessageDialog(null, "No se ha encontrado a un personal con ese núnero de documento");
                    }

                    st.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
            }
        }
    }//GEN-LAST:event_txtNumeroKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}