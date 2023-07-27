/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;

import ConexionDB.ConexionClinica;
import Entidades.Cita;
import java.awt.event.KeyEvent;
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

public class frmCita extends javax.swing.JInternalFrame {

    Connection con3 = null;
    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel TablaBuscar = new DefaultTableModel();
    DefaultTableModel TablaHorario = new DefaultTableModel();
    String transaccion = "";
    Cita nuevaCita = new Cita();

    /**
     * Creates new form frmCita
     */
    public frmCita() {
        initComponents();
        CargarEspecialidad();
        CargarTurno();

        //this.cboEspecialidad.setModel(new DefaultComboBoxModel<>(new String [] {}));
    }

    public void Habilitar() {
        //txtId.setEnabled(true);
        txtNombre.setEnabled(true);
    }

    public void Deshabilitar() {
        txtDni.setEnabled(false);
        txtNombre.setEnabled(false);
        cboEspecialidad.setEnabled(true);
        cboTurno.setEnabled(true);
        txtFecha.setEnabled(false);

    }

    public void Limpiar() {
        txtNombre.setText("");
    }

    public void CargarEspecialidad() {
        String SQLBuscar = "SELECT * FROM vst_especialidad WHERE estado = true ORDER BY nombre ASC";
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

    public void CargarTurno() {
        String SQLBuscar = "SELECT * FROM vst_turno WHERE estado = true ORDER BY nombre ASC";
        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);

            cboTurno.removeAllItems();
            cboTurno.addItem("SELECCIONE");

            while (rs.next()) {
                cboTurno.addItem(rs.getString("nombre"));
            }

            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
        }
    }

    public void CargarHorario() {

        String titulos[] = {"N°", "Nombre del médico", "Especialidad", "Turno", "Desde", "Hasta", "idper", "idespe", "idturno", "idhora"};
        TablaHorario = new DefaultTableModel(null, titulos);
        String[] registros = new String[100];
        String SQLBuscar = "Select medico_nombre, especialidad_nombre, turno_nombre,horario_inicio,horario_fin,id_personal,id_especialidad,id_turno,id_horario FROM vst_horarioDisponible ";
        SQLBuscar += " where id_horario not in (select id_horario from tbl_cita where cita_fecha ='" + this.txtFecha.getText() + "')";
        if (!(this.cboEspecialidad.getSelectedItem().toString().isEmpty() || this.cboEspecialidad.getSelectedItem() == "SELECCIONE")) {
            SQLBuscar += " AND especialidad_nombre = '" + this.cboEspecialidad.getSelectedItem() + "' ";
        }

        if (!(this.cboTurno.getSelectedItem().toString().isEmpty() || this.cboTurno.getSelectedItem() == "SELECCIONE")) {
            SQLBuscar += " and turno_nombre = '" + this.cboTurno.getSelectedItem() + "'";
        }

        ConexionClinica Conectado = new ConexionClinica();
        con3 = Conectado.getConexion();

        try {
            st = (Statement) con3.createStatement();
            rs = st.executeQuery(SQLBuscar);

            int count = 0;

            while (rs.next()) {
                count++;
                registros[0] = String.valueOf(count);
                registros[1] = rs.getString("medico_nombre");
                registros[2] = rs.getString("especialidad_nombre");
                registros[3] = rs.getString("turno_nombre");
                registros[4] = rs.getString("horario_inicio");
                registros[5] = rs.getString("horario_fin");
                registros[6] = rs.getString("id_personal");
                registros[7] = rs.getString("id_especialidad");
                registros[8] = rs.getString("id_turno");
                registros[9] = rs.getString("id_horario");

                TablaHorario.addRow(registros);
            }

            tblMedico.setModel(TablaHorario);

            tblMedico.getColumnModel().getColumn(0).setPreferredWidth(50);

            tblMedico.getColumnModel().getColumn(1).setMaxWidth(200);
            tblMedico.getColumnModel().getColumn(1).setMinWidth(200);
            //tblMedico.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            //tblMedico.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

            tblMedico.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblMedico.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblMedico.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblMedico.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblMedico.getColumnModel().getColumn(6).setPreferredWidth(0);
            tblMedico.getColumnModel().getColumn(7).setPreferredWidth(0);
            tblMedico.getColumnModel().getColumn(8).setPreferredWidth(0);
            tblMedico.getColumnModel().getColumn(9).setPreferredWidth(0);

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
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboEspecialidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboTurno = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedico = new javax.swing.JTable();
        btnReservar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        txtCodigoPaciente = new javax.swing.JTextField();
        btnDate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        dateChooser1.setTextRefernce(txtFecha);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(153, 0, 102));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/buscar.jpg"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("Nombre del paciente");

        txtNombre.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DNI");
        jLabel1.setToolTipText("");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Especialidad");

        cboEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Turno");

        cboTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fecha");

        tblMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre del médico", "Fecha", "Turno", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMedico);

        btnReservar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReservar.setForeground(new java.awt.Color(0, 0, 204));
        btnReservar.setText("Reservar cita");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(153, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        txtCodigoPaciente.setEnabled(false);

        btnDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/date.jpg"))); // NOI18N
        btnDate.setToolTipText("");
        btnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/usuario_ico.jpg"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("RESERVA DE CITAS MÉDICAS");
        jLabel7.setToolTipText("");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/MEDICO.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("DATOS MEDICOS");
        jLabel9.setToolTipText("");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/usuario_ico.jpg"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("HORARIO");
        jLabel11.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("DATOS DEL PACIENTE");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cboEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnDate))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel12))))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnReservar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)))
                .addGap(0, 5, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(4, 4, 4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(btnDate))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(btnReservar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String SQLBuscar = "SELECT * FROM vst_paciente WHERE numero = '" + txtDni.getText() + "'";
            ConexionClinica Conectado = new ConexionClinica();
            con3 = Conectado.getConexion();
            boolean ValidarPaciente = false;

            try {
                st = (Statement) con3.createStatement();
                rs = st.executeQuery(SQLBuscar);

                while (rs.next()) {
                    ValidarPaciente = true;
                    this.txtNombre.setText(rs.getString("nombre") + " " + rs.getString("paterno") + " " + rs.getString("materno"));
                    this.txtCodigoPaciente.setText(rs.getString("id"));
                }

                if (ValidarPaciente == false) {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado al paciente con el número de documento ingresado");
                    txtDni.requestFocus();
                }

                st.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los datos \n" + e);
            }
        }
    }//GEN-LAST:event_txtDniKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (this.txtFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha de la cita");
        } else {
            if (this.txtDni.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese el DNI del Paciente");
            } else {
                if (this.txtCodigoPaciente.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El DNI Ingresado es invalido");
                } else {
                    CargarHorario();
                }
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        if (this.txtDni.getText() == "") {
            JOptionPane.showMessageDialog(null, "Ingrese el DNI del paciente");
        } else {
            String SQLGuardar = "";

            Connection con1 = null;
            ConexionClinica conectado = new ConexionClinica();
            con1 = conectado.getConexion();
            //Statement st = con1.createStatement();

            int id_personal = nuevaCita.getId_personal();
            int id_paciente = nuevaCita.getId_paciente();
            int id_tuno = nuevaCita.getId_tuno();
            int id_horario = nuevaCita.getId_horario();
            int id_espe = nuevaCita.getId_espe();
            String cita_fecha = nuevaCita.getCita_fecha();

            SQLGuardar = "INSERT INTO tbl_cita (id_personal,id_paciente,id_turno,cita_fecha,id_horario) VALUES (" + id_personal + ", " + id_paciente + ", " + id_tuno + ", '" + cita_fecha + "', " + id_horario + ")";

            try {
                PreparedStatement pst = con1.prepareCall(SQLGuardar);

                int n = pst.executeUpdate();
                pst.close();

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    Deshabilitar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos \n" + e);
            }

        }
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void tblMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedicoMouseClicked
        int seleccionar = tblMedico.rowAtPoint(evt.getPoint());
        int id_personal = Integer.parseInt(String.valueOf(tblMedico.getValueAt(seleccionar, 6)));
        int id_paciente = Integer.parseInt(this.txtCodigoPaciente.getText().toUpperCase());
        int id_tuno = Integer.parseInt(String.valueOf(tblMedico.getValueAt(seleccionar, 8)));
        int id_horario = Integer.parseInt(String.valueOf(tblMedico.getValueAt(seleccionar, 9)));
        int id_espe = Integer.parseInt(String.valueOf(tblMedico.getValueAt(seleccionar, 7)));
        String cita_fecha = this.txtFecha.getText();
        nuevaCita.setId_horario(id_horario);
        nuevaCita.setId_tuno(id_tuno);
        nuevaCita.setId_paciente(id_paciente);
        nuevaCita.setId_personal(id_personal);
        nuevaCita.setId_espe(id_espe);
        nuevaCita.setCita_fecha(cita_fecha);
        //Cita nuevaCita = new Cita(id_personal,id_paciente,id_tuno,id_horario,id_espe,cita_fecha);

    }//GEN-LAST:event_tblMedicoMouseClicked

    private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
        // TODO add your handling code here:
        this.dateChooser1.showPopup();
    }//GEN-LAST:event_btnDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDate;
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox<String> cboEspecialidad;
    private javax.swing.JComboBox<String> cboTurno;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMedico;
    private javax.swing.JTextField txtCodigoPaciente;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
