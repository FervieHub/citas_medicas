package Formularios;

import ConexionDB.ConexionClinica;
import Entidades.*;
import static Formularios.frmMenu.Escritorio;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmPaciente extends javax.swing.JInternalFrame {
    Connection con3 = null;
    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel TablaPersonal = new DefaultTableModel();
    String transaccion = "";
    boolean ValidarDocumento = false;

    /**
     * Creates new form frmPersonal
     */
    public frmPaciente() {
        initComponents();
        
        Deshabilitar();
        CargarGenero();
        CargarTipoDocumento();
        CargarDistrito();
        
        CargarPaciente();
        
        lblIdGenero.setVisible(false);
        lblIdTipoDocumento.setVisible(false);
        lblIdDistrito.setVisible(false);
    }
    
    public void Habilitar(){
        //txtId.setEnabled(true);
        txtNombre.setEnabled(true);
        txtPaterno.setEnabled(true);
        txtMaterno.setEnabled(true);
        cboGenero.setEnabled(true);
        txtFechaNacimiento.setEnabled(true);
        cboTipoDocumento.setEnabled(true);
        txtNumero.setEnabled(true);
        cboDistrito.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
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
        txtPaterno.setEnabled(false);
        txtMaterno.setEnabled(false);
        cboGenero.setEnabled(false);
        txtFechaNacimiento.setEnabled(false);
        cboTipoDocumento.setEnabled(false);
        txtNumero.setEnabled(false);
        cboDistrito.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCelular.setEnabled(false);
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
        txtPaterno.setText("");
        txtMaterno.setText("");
        cboGenero.setSelectedIndex(0);
        txtFechaNacimiento.setText("");
        cboTipoDocumento.setSelectedIndex(0);
        txtNumero.setText("");
        cboDistrito.setSelectedIndex(0);
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");
        chkEstado.setSelected(false);
    }
    
    public void CargarPaciente(){
        String titulos[] = {"N°", "Id", "Paciente", "Especialidad"};
        TablaPersonal = new DefaultTableModel(null, titulos);
        String[] registros = new String[100];
        String SQLBuscar = "Select * FROM vst_paciente ORDER BY nombre, paterno, materno ASC";
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
                registros[2] = rs.getString("nombre") + " " + rs.getString("paterno") + " " + rs.getString("materno");
                TablaPersonal.addRow(registros);
            }
            
            tblPersonal.setModel(TablaPersonal);
            
            tblPersonal.getColumnModel().getColumn(0).setPreferredWidth(50);
            
            tblPersonal.getColumnModel().getColumn(1).setMaxWidth(0);
            tblPersonal.getColumnModel().getColumn(1).setMinWidth(0);
            tblPersonal.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            tblPersonal.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
            
            tblPersonal.getColumnModel().getColumn(2).setPreferredWidth(300);
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void SearchDocumento(){
        String SQLBuscar = "SELECT * FROM vst_paciente WHERE numero = " + this.txtNumero.getText();
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            ValidarDocumento = false;
            
            while (rs.next()) {
                ValidarDocumento = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void SearchPersonal(){
        String SQLBuscar = "SELECT * FROM vst_paciente WHERE id = " + this.txtId.getText();
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            int count = 0;
            
            while (rs.next()) {
                txtNombre.setText(rs.getString("nombre"));
                txtPaterno.setText(rs.getString("paterno"));
                txtMaterno.setText(rs.getString("materno"));
                cboGenero.setSelectedItem(rs.getString("genero"));
                txtFechaNacimiento.setText(rs.getString("fechanacimiento"));
                cboTipoDocumento.setSelectedItem(rs.getString("tipodocumento"));
                txtNumero.setText(rs.getString("numero"));
                cboDistrito.setSelectedItem(rs.getString("distrito"));
                txtDireccion.setText(rs.getString("direccion"));
                txtTelefono.setText(rs.getString("telefono"));
                txtCelular.setText(rs.getString("celular"));
                chkEstado.setSelected(rs.getBoolean("estado"));
            }
            
            tblPersonal.setModel(TablaPersonal);
            
            tblPersonal.getColumnModel().getColumn(0).setPreferredWidth(50);
            
            tblPersonal.getColumnModel().getColumn(1).setMaxWidth(0);
            tblPersonal.getColumnModel().getColumn(1).setMinWidth(0);
            tblPersonal.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            tblPersonal.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
            
            tblPersonal.getColumnModel().getColumn(2).setPreferredWidth(300);
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void CargarGenero(){
        String SQLBuscar = "SELECT id, codigo, nombre, estado FROM vst_genero WHERE estado = true ORDER BY nombre ASC";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();
        
        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            cboGenero.removeAllItems();
            cboGenero.addItem("SELECCIONE");
            
            while (rs.next()) {
                cboGenero.addItem(rs.getString("nombre"));
            }
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void CargarTipoDocumento(){
        String SQLBuscar = "SELECT id, nombre, descripcion, estado FROM vst_tipodocumento WHERE estado = true ORDER BY nombre ASC";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();
        
        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            cboTipoDocumento.removeAllItems();
            cboTipoDocumento.addItem("SELECCIONE");
            
            while (rs.next()) {
                cboTipoDocumento.addItem(rs.getString("descripcion"));
            }
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void CargarDistrito(){
        String SQLBuscar = "SELECT id, nombre, estado FROM vst_distrito WHERE estado = true ORDER BY nombre ASC";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();
        
        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            cboDistrito.removeAllItems();
            cboDistrito.addItem("SELECCIONE");
            
            while (rs.next()) {
                cboDistrito.addItem(rs.getString("nombre"));
            }
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void SearchGenero(){
        String SQLBuscar = "Select id, codigo, nombre, estado FROM vst_genero WHERE nombre = '" + this.cboGenero.getSelectedItem() + "'";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            lblIdGenero.setText("0");
            
            while (rs.next()) {
                lblIdGenero.setText(rs.getString("id"));
            }
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void SearchTipoDocumento(){
        String SQLBuscar = "Select id, nombre, descripcion, estado FROM vst_tipodocumento WHERE descripcion = '" + this.cboTipoDocumento.getSelectedItem() + "'";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            lblIdTipoDocumento.setText("0");
            
            while (rs.next()) {
                lblIdTipoDocumento.setText(rs.getString("id"));
            }
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void SearchDistito(){
        String SQLBuscar = "Select id, nombre, estado FROM vst_distrito WHERE nombre = '" + this.cboDistrito.getSelectedItem() + "'";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            lblIdDistrito.setText("0");
            
            while (rs.next()) {
                lblIdDistrito.setText(rs.getString("id"));
            }
            
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

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        dateChooser3 = new com.raven.datechooser.DateChooser();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonal = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        cboTipoDocumento = new javax.swing.JComboBox<>();
        lblIdDistrito = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblIdTipoDocumento = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblIdGenero = new javax.swing.JLabel();
        cboGenero = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        chkEstado = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cboDistrito = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        dateChooser3.setTextRefernce(txtFechaNacimiento);

        setTitle("Personal");

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 51, 204));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/b_editar.jpg"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 51, 204));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/b_nuevo.jpg"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(0, 51, 204));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/salir.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        tblPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonal);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Número");

        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblIdDistrito.setText("jLabel17");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tipo de documento");

        lblIdTipoDocumento.setText("jLabel17");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Fecha de Nacimiento");

        lblIdGenero.setText("jLabel17");

        cboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Género");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ap. Materno");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Ap. Paterno");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Estado");

        chkEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkEstado.setText("Activo");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Id");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Celular");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Teléfono");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Dirección");

        cboDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Distrito");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 51, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/wzsave.jpg"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 51, 204));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/undo_mb.jpg"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel16))
                                        .addGap(77, 77, 77))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblIdTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnCancelar)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(chkEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                                    .addComponent(txtTelefono))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14)
                                                .addGap(33, 33, 33)
                                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(157, 157, 157))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(23, 23, 23)
                                .addComponent(lblIdGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(377, 377, 377))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblIdDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNombre)
                                    .addComponent(txtPaterno)
                                    .addComponent(txtMaterno))
                                .addGap(157, 157, 157))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(lblIdDistrito)
                    .addComponent(jLabel10)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lblIdGenero))
                    .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(lblIdTipoDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(chkEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("REGISTROS DEL PACIENTES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Habilitar();
        transaccion="Editar";
        txtNombre.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Deshabilitar();
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        Habilitar();
        Limpiar();
        transaccion="Nuevo";
        txtNombre.requestFocus();
        dispose();
        frmPacienteRegistrar regPaciente = new frmPacienteRegistrar();
        Escritorio.add(regPaciente);
        regPaciente.show();
        
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(txtNombre.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese su nombre");
            txtNombre.requestFocus();
            return;
        }
        
        if(txtPaterno.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese su apellido paterno");
            txtPaterno.requestFocus();
            return;
        }
        
        if(txtMaterno.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese su apellido materno");
            txtMaterno.requestFocus();
            return;
        }
        
        if(cboGenero.getSelectedItem()=="SELECCIONE"){
            JOptionPane.showMessageDialog(null, "Seleccione un género");
            cboGenero.requestFocus();
            return;
        }
        
        if(cboTipoDocumento.getSelectedItem()=="SELECCIONE"){
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de documento");
            cboTipoDocumento.requestFocus();
            return;
        }
        
        if(txtNumero.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese su número de documento");
            txtNumero.requestFocus();
            return;
        }
        
        if(cboDistrito.getSelectedItem()=="SELECCIONE"){
            JOptionPane.showMessageDialog(null, "Seleccione un distrito");
            cboDistrito.requestFocus();
            return;
        }
        
        SearchDocumento();
        
        if(ValidarDocumento == true && transaccion=="Nuevo"){
            JOptionPane.showMessageDialog(null, "El documento ingresado ya se encuentra registrado");
            txtNumero.requestFocus();
        }else{
            SearchGenero();
            SearchTipoDocumento();
            SearchDistito();
            
            String SQLGuardar = "";
            
            Connection con1 = null;
            ConexionClinica conectado = new ConexionClinica();
            con1 = conectado.getConexion();
            //Statement st = con1.createStatement();

            if(transaccion=="Nuevo"){
                SQLGuardar = "INSERT INTO tbl_paciente (paciente_nombre, paciente_paterno, paciente_materno, id_genero, paciente_fechanacimiento, " + 
                                "id_tipodocumento, paciente_numero, id_distrito, paciente_direccion, paciente_telefono, paciente_celular, paciente_estado) " + 
                                "VALUES ('" + txtNombre.getText().toUpperCase() + "', '" + txtPaterno.getText().toUpperCase() + 
                                "', '" + txtMaterno.getText().toUpperCase() + "', " + lblIdGenero.getText() + ", '" + txtFechaNacimiento.getText() + "', " + lblIdTipoDocumento.getText() + 
                                ", '" + txtNumero.getText().toUpperCase() + "', " + lblIdDistrito.getText() + ", '" + txtDireccion.getText().toUpperCase() + "', '" + txtTelefono.getText() + 
                                "', '" + txtCelular.getText() + "', " + chkEstado.isSelected() + ")";
            }else{
                SQLGuardar = "UPDATE tbl_paciente SET paciente_nombre = '" + txtNombre.getText().toUpperCase() + "', paciente_paterno = '" + txtPaterno.getText().toUpperCase() + 
                                "', paciente_materno = '" + txtMaterno.getText().toUpperCase() + "', id_genero = " + lblIdGenero.getText() + 
                                ", paciente_fechanacimiento = '" + txtFechaNacimiento.getText() + "', id_tipodocumento = " + lblIdTipoDocumento.getText() + 
                                ", paciente_numero = '" + txtNumero.getText().toUpperCase() + "', id_distrito = " + lblIdDistrito.getText() + 
                                ", paciente_direccion = '" + txtDireccion.getText().toUpperCase() + "', paciente_telefono = '" + txtTelefono.getText() + 
                                "', paciente_celular = '" + txtCelular.getText() + "', paciente_estado = " + chkEstado.isSelected() + " WHERE id_paciente = " + this.txtId.getText();
            }

            try {
                PreparedStatement pst = con1.prepareCall(SQLGuardar);

                int n = pst.executeUpdate();
                pst.close();

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    Deshabilitar();
                    CargarPaciente();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos \n" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void tblPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonalMouseClicked
        // TODO add your handling code here:
        int seleccionar = tblPersonal.rowAtPoint(evt.getPoint());
        
        txtId.setText(String.valueOf(tblPersonal.getValueAt(seleccionar, 1)));
        SearchPersonal();
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_tblPersonalMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboDistrito;
    private javax.swing.JComboBox<String> cboGenero;
    private javax.swing.JComboBox<String> cboTipoDocumento;
    private javax.swing.JCheckBox chkEstado;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblIdDistrito;
    private javax.swing.JLabel lblIdGenero;
    private javax.swing.JLabel lblIdTipoDocumento;
    private javax.swing.JTable tblPersonal;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
