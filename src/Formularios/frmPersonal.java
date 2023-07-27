package Formularios;

import ConexionDB.ConexionClinica;
import Entidades.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmPersonal extends javax.swing.JInternalFrame {
    Connection con3 = null;
    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel TablaPersonal = new DefaultTableModel();
    String transaccion = "";
    boolean ValidarDocumento = false;

    /**
     * Creates new form frmPersonal
     */
    public frmPersonal() {
        initComponents();
        
        Deshabilitar();
        CargarPerfil();
        CargarEspecialidad();
        CargarGenero();
        CargarTipoDocumento();
        CargarDistrito();
        
        CargarPersonal();
        
        lblIdPerfil.setVisible(false);
        lblIdEspecialidad.setVisible(false);
        lblIdGenero.setVisible(false);
        lblIdTipoDocumento.setVisible(false);
        lblIdDistrito.setVisible(false);
    }
    
    public void Habilitar(){
        //txtId.setEnabled(true);
        cboPerfil.setEnabled(true);
        cboEspecialidad.setEnabled(true);
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
        txtCorreo.setEnabled(true);
        chkEstado.setEnabled(true);
        
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnDate.setEnabled(true);
        jTabbedPane1.setSelectedIndex(1);
    }
    
    public void Deshabilitar(){
        txtId.setEnabled(false);
        cboPerfil.setEnabled(false);
        cboEspecialidad.setEnabled(false);
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
        txtCorreo.setEnabled(false);
        chkEstado.setEnabled(false);
        
        btnNuevo.setEnabled(true);
        btnDate.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        jTabbedPane1.setSelectedIndex(0);
    }
    
    public void Limpiar(){
        txtId.setText("");
        cboPerfil.setSelectedIndex(0);
        cboEspecialidad.setSelectedIndex(0);
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
        txtCorreo.setText("");
        chkEstado.setSelected(false);
    }
    
    public void CargarPersonal(){
        String titulos[] = {"N°", "Id", "Personal", "Especialidad"};
        TablaPersonal = new DefaultTableModel(null, titulos);
        String[] registros = new String[100];
        String SQLBuscar = "Select * FROM vst_personal ORDER BY nombre, paterno, materno ASC";
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
        String SQLBuscar = "SELECT * FROM vst_personal WHERE numero = " + this.txtNumero.getText();
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
        String SQLBuscar = "SELECT * FROM vst_personal WHERE id = " + this.txtId.getText();
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            int count = 0;
            
            while (rs.next()) {
                cboPerfil.setSelectedItem(rs.getString("perfil"));
                cboEspecialidad.setSelectedItem(rs.getString("especialidad"));
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
                txtCorreo.setText(rs.getString("correo"));
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
    
    public void CargarPerfil(){
        String SQLBuscar = "SELECT id, descripcion, estado FROM vst_perfil WHERE estado = true ORDER BY descripcion ASC";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            cboPerfil.removeAllItems();
            cboPerfil.addItem("SELECCIONE");
            
            while (rs.next()) {
                cboPerfil.addItem(rs.getString("descripcion"));
            }
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void CargarEspecialidad(){
        String SQLBuscar = "SELECT id, nombre, estado FROM vst_especialidad WHERE estado = true ORDER BY nombre ASC";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();
        
        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            cboEspecialidad.removeAllItems();
            cboEspecialidad.addItem("SELECCIONE");
            
            while (rs.next()) {
                cboEspecialidad.addItem(rs.getString("nombre"));
            }
            
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
    
    public void SearchPerfil(){
        String SQLBuscar = "Select id, descripcion, estado FROM vst_perfil WHERE descripcion = '" + this.cboPerfil.getSelectedItem() + "'";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();
        
        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            lblIdPerfil.setText("0");
            
            while (rs.next()) {
                lblIdPerfil.setText(rs.getString("id"));
            }
            
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }
    
    public void SearchEspecialidad(){
        String SQLBuscar = "Select id, nombre, estado FROM vst_especialidad WHERE nombre = '" + this.cboEspecialidad.getSelectedItem() + "'";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);
            
            lblIdEspecialidad.setText("0");
            
            while (rs.next()) {
                lblIdEspecialidad.setText(rs.getString("id"));
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
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonal = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cboEspecialidad = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboGenero = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnDate = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboPerfil = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        chkEstado = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboTipoDocumento = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboDistrito = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblIdPerfil = new javax.swing.JLabel();
        lblIdEspecialidad = new javax.swing.JLabel();
        lblIdGenero = new javax.swing.JLabel();
        lblIdTipoDocumento = new javax.swing.JLabel();
        lblIdDistrito = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        dateChooser1.setTextRefernce(txtFechaNacimiento);

        setTitle("Personal");

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 51, 204));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/b_editar.jpg"))); // NOI18N
        btnEditar.setText("Modificar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("", jPanel1);

        cboEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Ap. Paterno");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ap. Materno");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Género");

        cboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Fecha de Nacimiento");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo");

        btnDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/date.jpg"))); // NOI18N
        btnDate.setName(""); // NOI18N
        btnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Perfil");

        cboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Especialidad");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Correo");

        chkEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkEstado.setText("Activo");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Estado");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tipo de documento");

        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Número");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Distrito");

        cboDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Dirección");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Teléfono");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Celular");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 51, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/b_editar.jpg"))); // NOI18N
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

        lblIdPerfil.setText("jLabel18");

        lblIdEspecialidad.setText("jLabel18");

        lblIdGenero.setText("jLabel19");

        lblIdTipoDocumento.setText("jLabel20");

        lblIdDistrito.setText("jLabel21");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(103, 103, 103)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblIdPerfil)
                                .addGap(18, 18, 18)
                                .addComponent(lblIdEspecialidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblIdGenero)
                                .addGap(18, 18, 18)
                                .addComponent(lblIdTipoDocumento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblIdDistrito))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(chkEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(114, 114, 114)
                                .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(67, 67, 67)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel13))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboDistrito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblIdEspecialidad)
                    .addComponent(lblIdPerfil)
                    .addComponent(lblIdGenero)
                    .addComponent(lblIdTipoDocumento)
                    .addComponent(lblIdDistrito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(btnDate)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(chkEstado))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(297, 297, 297))
        );

        jTabbedPane1.addTab("", jPanel2);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("REGISTRO DEL PERSONAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar))
                .addGap(27, 27, 27)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Habilitar();
        transaccion="Editar";
        cboPerfil.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        Habilitar();
        Limpiar();
        transaccion="Nuevo";
        cboPerfil.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Deshabilitar();
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(cboPerfil.getSelectedItem()=="SELECCIONE"){
            JOptionPane.showMessageDialog(null, "Seleccione un perfil");
            cboPerfil.requestFocus();
            return;
        }

        if(cboEspecialidad.getSelectedItem()=="SELECCIONE"){
            JOptionPane.showMessageDialog(null, "Seleccione una especialidad");
            cboEspecialidad.requestFocus();
            return;
        }

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
            SearchPerfil();
            SearchEspecialidad();
            SearchGenero();
            SearchTipoDocumento();
            SearchDistito();

            String SQLGuardar = "";

            Connection con1 = null;
            ConexionClinica conectado = new ConexionClinica();
            con1 = conectado.getConexion();
            //Statement st = con1.createStatement();

            if(transaccion=="Nuevo"){
                SQLGuardar = "INSERT INTO tbl_personal (id_perfil, id_especialidad, personal_nombre, personal_paterno, personal_materno, id_genero, personal_fechanacimiento, " +
                "id_tipodocumento, personal_numero, id_distrito, personal_direccion, personal_telefono, personal_celular, personal_correo, personal_estado) " +
                "VALUES (" + lblIdPerfil.getText() + ", " + lblIdEspecialidad.getText() + ", '" + txtNombre.getText().toUpperCase() + "', '" + txtPaterno.getText().toUpperCase() +
                "', '" + txtMaterno.getText().toUpperCase() + "', " + lblIdGenero.getText() + ", '" + txtFechaNacimiento.getText() + "', " + lblIdTipoDocumento.getText() +
                ", '" + txtNumero.getText().toUpperCase() + "', " + lblIdDistrito.getText() + ", '" + txtDireccion.getText().toUpperCase() + "', '" + txtTelefono.getText() +
                "', '" + txtCelular.getText() + "', '" + txtCorreo.getText().toUpperCase() + "', " + chkEstado.isSelected() + ")";
            }else{
                SQLGuardar = "UPDATE tbl_personal SET id_perfil = " + lblIdPerfil.getText() + ", id_especialidad = " + lblIdEspecialidad.getText() +
                ", personal_nombre = '" + txtNombre.getText().toUpperCase() + "', personal_paterno = '" + txtPaterno.getText().toUpperCase() +
                "', personal_materno = '" + txtMaterno.getText().toUpperCase() + "', id_genero = " + lblIdGenero.getText() +
                ", personal_fechanacimiento = '" + txtFechaNacimiento.getText() + "', id_tipodocumento = " + lblIdTipoDocumento.getText() +
                ", personal_numero = '" + txtNumero.getText().toUpperCase() + "', id_distrito = " + lblIdDistrito.getText() +
                ", personal_direccion = '" + txtDireccion.getText().toUpperCase() + "', personal_telefono = '" + txtTelefono.getText() +
                "', personal_celular = '" + txtCelular.getText() + "', personal_correo = '" + txtCorreo.getText().toUpperCase() +
                "', personal_estado = " + chkEstado.isSelected() + " WHERE id_personal = " + this.txtId.getText();
            }

            try {
                PreparedStatement pst = con1.prepareCall(SQLGuardar);

                int n = pst.executeUpdate();
                pst.close();

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    Deshabilitar();
                    CargarPersonal();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos \n" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
        // TODO add your handling code here:
        this.dateChooser1.showPopup();
    }//GEN-LAST:event_btnDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnDate;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboDistrito;
    private javax.swing.JComboBox<String> cboEspecialidad;
    private javax.swing.JComboBox<String> cboGenero;
    private javax.swing.JComboBox<String> cboPerfil;
    private javax.swing.JComboBox<String> cboTipoDocumento;
    private javax.swing.JCheckBox chkEstado;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblIdDistrito;
    private javax.swing.JLabel lblIdEspecialidad;
    private javax.swing.JLabel lblIdGenero;
    private javax.swing.JLabel lblIdPerfil;
    private javax.swing.JLabel lblIdTipoDocumento;
    private javax.swing.JTable tblPersonal;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
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
