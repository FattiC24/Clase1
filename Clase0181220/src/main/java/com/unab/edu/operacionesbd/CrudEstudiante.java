/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.operacionesbd;

import com.unab.edu.DAO.ClsEstudiante;
import com.unab.edu.DAO.ClsPersona;
import com.unab.edu.conexiónmysql.ConexionBd;
import com.unab.edu.entidades.Estudiante;
import com.unab.edu.entidades.Persona;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CruzCalles
 */
public class CrudEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form CrudEstudiante
     */
    public CrudEstudiante() {
        initComponents();  
        MostrarTablaEstudiante();
        MostrarPersonaSeleccionada();
        displayMember();
        
    }
    
    String valueMember[];
    int contador = 1;
    

    void displayMember() {
        
        DefaultComboBoxModel cbdefault = new DefaultComboBoxModel();
        ClsPersona clasePersona = new ClsPersona();
        ArrayList<Persona> Personas = clasePersona.MostrarPersona();
        valueMember = new String[Personas.size()+1];
        String filas[] = new String[5];
        cbdefault.addElement("");
        for (var iterarDatosPersona : Personas) {
            filas[0] = String.valueOf(iterarDatosPersona.getIdPersona());
            filas[1] = iterarDatosPersona.getNombre();
        valueMember[contador] = filas[0];
        cbdefault.addElement(filas[1]);
        contador++;
        }
        cbPersonas.setModel(cbdefault);
    }
    ConexionBd classConectar = new ConexionBd();
    Connection conectar = classConectar.retornarConexion();

    void MostrarTablaEstudiante() {

        String TITULOS[] = {"IDESTUDIANTE", "MATRICULA", "IDPERSONA", "NOMBRE", "USUARIO", "PASSWORD", "NIE"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        ClsEstudiante claseEstudiante = new ClsEstudiante();
        var MostrarTablaEstudiante = claseEstudiante.MostrarEstudiante();
        String filas[] = new String[8];

        for (var iterarDatosEstudiante : MostrarTablaEstudiante) {
            filas[0] = String.valueOf(iterarDatosEstudiante.getIdEstudiante());
            filas[1] = String.valueOf(iterarDatosEstudiante.getMatricula());
            filas[2] = String.valueOf(iterarDatosEstudiante.getIdPersona());
            filas[3] = iterarDatosEstudiante.getNombre();
            filas[4] = iterarDatosEstudiante.getUsu();
            filas[5] = iterarDatosEstudiante.getPass();
            filas[6] = String.valueOf(iterarDatosEstudiante.getNie());

            ModeloTabla.addRow(filas);
        }

        tb_Estudiante.setModel(ModeloTabla);
    }
    void MostrarPersonaSeleccionada() {
        String TITULOS[] = {"ID", "NOMBRE"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        ClsPersona clasePersona = new ClsPersona();
        ArrayList<Persona> Personas = clasePersona.MostrarPersona();
        String filas[] = new String[3];
        for (var IterarDatosPersona : Personas) {
            filas[0] = String.valueOf(IterarDatosPersona.getIdPersona());
            filas[1] = IterarDatosPersona.getNombre();
            ModeloTabla.addRow(filas);
        }
        //tb_SeleccionarPersona.setModel(ModeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        lblSexo1 = new javax.swing.JLabel();
        txtSexo1 = new javax.swing.JTextField();
        tpMostrar = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        PASS = new javax.swing.JLabel();
        lblSexo2 = new javax.swing.JLabel();
        txtNIE = new javax.swing.JTextField();
        cbPersonas = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnVaciar = new javax.swing.JButton();
        txtIdEstudiante = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Estudiante = new javax.swing.JTable();

        lblSexo1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSexo1.setText("SEXO");

        txtSexo1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tpMostrar.setForeground(new java.awt.Color(255, 255, 255));
        tpMostrar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        txtMatricula.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtPass.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID ESTUDIANTE");

        lblNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("MATRICULA");

        lblApellidos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidos.setText("IDPERSONA");

        lblEdad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(255, 255, 255));
        lblEdad.setText("USUARIO");

        PASS.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PASS.setForeground(new java.awt.Color(255, 255, 255));
        PASS.setText("PASSWORD");

        lblSexo2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSexo2.setForeground(new java.awt.Color(255, 255, 255));
        lblSexo2.setText("NIE");

        txtNIE.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        cbPersonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPersonasActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnVaciar.setBackground(new java.awt.Color(255, 255, 255));
        btnVaciar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVaciar.setForeground(new java.awt.Color(0, 0, 0));
        btnVaciar.setText("Vaciar");
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });

        txtIdEstudiante.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVaciar)
                        .addGap(63, 63, 63)
                        .addComponent(btnGuardar)
                        .addGap(57, 57, 57)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnActualizar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblID)
                            .addComponent(lblNombre)
                            .addComponent(lblApellidos)
                            .addComponent(lblEdad)
                            .addComponent(PASS)
                            .addComponent(lblSexo2)
                            .addComponent(txtNIE, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                            .addComponent(cbPersonas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdEstudiante))
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApellidos)
                .addGap(11, 11, 11)
                .addComponent(cbPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEdad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(PASS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(lblSexo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar)
                    .addComponent(btnVaciar))
                .addGap(31, 31, 31))
        );

        tpMostrar.addTab("Operación de CRUD", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 102, 102));

        tb_Estudiante.setBackground(new java.awt.Color(0, 0, 51));
        tb_Estudiante.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tb_Estudiante.setForeground(new java.awt.Color(255, 255, 255));
        tb_Estudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "IDESTUDIANTE", "MATRICULA", "IDPERSONA", "NOMBRE PERSONA", "USUARIO", "PASSWORD", "NIE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Estudiante.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tb_Estudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_EstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Estudiante);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpMostrar.addTab("Mostrar Datos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpMostrar)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpMostrar)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_EstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_EstudianteMouseClicked
        //Modificacion de TabPena.
        tpMostrar.setSelectedIndex(tpMostrar.indexOfComponent(jPanel1));
        //Obtener la fila actual que el usuario selecionó
        int filas = tb_Estudiante.getSelectedRow();

        //Sirve para capturar datos de las tablas, pasandole filas y columnas.
        String IdEstudiante = String.valueOf(tb_Estudiante.getValueAt(filas, 0));
        String Matricula = String.valueOf(tb_Estudiante.getValueAt(filas, 1));
        String IdPersona = String.valueOf(tb_Estudiante.getValueAt(filas, 2));
        String Usuario = String.valueOf(tb_Estudiante.getValueAt(filas, 4));
        String Pass = String.valueOf(tb_Estudiante.getValueAt(filas, 5));
        String Nie = String.valueOf(tb_Estudiante.getValueAt(filas, 6));

        txtIdEstudiante.setText(IdEstudiante);
        txtMatricula.setText(Matricula);
        //txtIdPersona.setText(IdPersona);
        txtUsuario.setText(Usuario);
        txtPass.setText(Pass);
        txtNIE.setText(Nie);
        
        int seleccionadorDeVista = 0;
        for (var iterar : valueMember) {
            if (IdPersona.equals(iterar)) {
                cbPersonas.setSelectedIndex(seleccionadorDeVista);
            }

            seleccionadorDeVista += 1;
        }
    }//GEN-LAST:event_tb_EstudianteMouseClicked
  
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       if (txtIdEstudiante.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡Ingrese un ID para Eliminar!");
        } else {
            ClsEstudiante estudiantes = new ClsEstudiante();
            Estudiante estudiante = new Estudiante();

            estudiante.setIdEstudiante(Integer.parseInt(txtIdEstudiante.getText()));
            estudiantes.BorrarEstudiante(estudiante);
            MostrarPersonaSeleccionada();
            MostrarTablaEstudiante();
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            ClsEstudiante estudiantes = new ClsEstudiante();
            Estudiante estudiante = new Estudiante();

            estudiante.setIdEstudiante(Integer.parseInt(txtIdEstudiante.getText()));
            estudiante.setMatricula(Integer.parseInt(txtMatricula.getText()));
            //estudiante.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
            estudiante.setUsu(txtUsuario.getText());
            estudiante.setPass(txtPass.getText());
            estudiante.setNie(Integer.parseInt(txtNIE.getText()));
            estudiantes.ActualizarEstudiante(estudiante);
            MostrarPersonaSeleccionada();
            MostrarTablaEstudiante();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Verifica todos los campos!");
        }

       
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        try {
            ClsEstudiante estudiantes = new ClsEstudiante();
            Estudiante estudiante = new Estudiante();

            estudiante.setMatricula(Integer.parseInt(txtMatricula.getText()));
            //estudiante.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
            estudiante.setIdPersona(Integer.parseInt(valueMember[cbPersonas.getSelectedIndex()]));
            estudiante.setUsu(txtUsuario.getText());
            estudiante.setPass(txtPass.getText());
            estudiante.setNie(Integer.parseInt(txtNIE.getText()));
            estudiantes.AgregarEstudiante(estudiante);
        MostrarTablaEstudiante();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Verifica todos los campos!");
        }

        
    
   

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPersonasActionPerformed

        
// TODO add your handling code here:
    }//GEN-LAST:event_cbPersonasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //txtIdPersona.setText(valueMember[cbPersonas.getSelectedIndex()]);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed
        txtIdEstudiante.setText("");
        cbPersonas.setSelectedIndex(0);
        txtMatricula.setText("");
        //txtIdPersona.setText("");
        txtUsuario.setText("");
        txtPass.setText("");
        txtNIE.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_btnVaciarActionPerformed

    

    /*
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrudEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PASS;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JComboBox<String> cbPersonas;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSexo1;
    private javax.swing.JLabel lblSexo2;
    private javax.swing.JTable tb_Estudiante;
    private javax.swing.JTabbedPane tpMostrar;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNIE;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtSexo1;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
