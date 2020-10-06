/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.operacionesbd;

import com.unab.edu.DAO.ClsPersona;
import com.unab.edu.conexiónmysql.ConexionBd;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CruzCalles
 */
public class PersonaCrud extends javax.swing.JFrame {

    /**
     * Creates new form Persona
     */
    public PersonaCrud() {
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarTablaPersona();
    }

    SimpleDateFormat formato = new SimpleDateFormat("d MM y");
    void MostrarTablaPersona() {

        String TITULOS[] = {"ID", "NOMBRE", "APELLIDO", "EDAD", "SEXO", "FECHA"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        ClsPersona clasePersona = new ClsPersona();
        ArrayList<com.unab.edu.entidades.Persona> Personas = clasePersona.MostrarPersona();
        String filas[] = new String[6];

        for (var iterarDatosPersona : Personas) {
            filas[0] = String.valueOf(iterarDatosPersona.getIdPersona());
            filas[1] = iterarDatosPersona.getNombre();
            filas[2] = iterarDatosPersona.getApellido();
            filas[3] = String.valueOf(iterarDatosPersona.getEdad());
            filas[4] = iterarDatosPersona.getSexo();
            if (iterarDatosPersona.getFecha()== null){
                filas[5] = "Null";
            }else{
                filas[5] = String.valueOf(formato.format(iterarDatosPersona.getFecha()));
            }
            
            ModeloTabla.addRow(filas);
        }

        tb_Persona.setModel(ModeloTabla);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpMostrar = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        btnConector = new javax.swing.JButton();
        txtFecha = new com.toedter.calendar.JDateChooser();
        lblSexo1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Persona = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tpMostrar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        txtNombres.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtApellidos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtEdad.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtSexo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblID.setText("ID");

        lblNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblNombre.setText("NOMBRES");

        lblApellidos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblApellidos.setText("APELLIDOS");

        lblEdad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblEdad.setText("EDAD");

        lblSexo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblSexo.setText("SEXO");

        btnConector.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnConector.setText("Conectar");
        btnConector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectorActionPerformed(evt);
            }
        });

        lblSexo1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblSexo1.setText("FECHA");

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres)
                            .addComponent(txtSexo)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblID)
                                    .addComponent(lblNombre)
                                    .addComponent(lblApellidos)
                                    .addComponent(lblEdad)
                                    .addComponent(lblSexo))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(btnConector)
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSexo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblApellidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEdad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSexo1)
                .addGap(8, 8, 8)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnConector)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        tpMostrar.addTab("Operación de CRUD", jPanel1);

        tb_Persona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Persona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_PersonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Persona);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ClsPersona personas = new ClsPersona();
        com.unab.edu.entidades.Persona persona = new com.unab.edu.entidades.Persona();

        persona.setNombre(txtNombres.getText());
        persona.setApellido(txtApellidos.getText());
        persona.setEdad(Integer.parseInt(txtEdad.getText()));
        persona.setSexo(txtSexo.getText());
        persona.setFecha(txtFecha.getDate());
        if (txtID.getText().isEmpty()){
            personas.AgregarPersonas(persona);
        }else{
            persona.setIdPersona(Integer.parseInt(txtID.getText()));
            personas.ActualizarPersonas(persona);
        }
        MostrarTablaPersona();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        ClsPersona personas = new ClsPersona();
        com.unab.edu.entidades.Persona persona = new com.unab.edu.entidades.Persona();

        persona.setIdPersona(Integer.parseInt(txtID.getText()));

        personas.BorrarPersonas(persona);
        MostrarTablaPersona();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectorActionPerformed

        ConexionBd classConectar = new ConexionBd();
        Connection conectar = classConectar.retornarConexion();
    }//GEN-LAST:event_btnConectorActionPerformed

    private void tb_PersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_PersonaMouseClicked
        //Modificacion de TabPena.
        tpMostrar.setSelectedIndex(tpMostrar.indexOfComponent(jPanel1));
        //Obtener la fila actual que el usuario selecionó
        int filas = tb_Persona.getSelectedRow();

        //Sirve para capturar datoa de las tablas, pasandole filas y columnas.
        String Id = String.valueOf(tb_Persona.getValueAt(filas, 0));
        String Nombre = String.valueOf(tb_Persona.getValueAt(filas, 1));
        String Apellido = String.valueOf(tb_Persona.getValueAt(filas, 2));
        String Edad = String.valueOf(tb_Persona.getValueAt(filas, 3));
        String Sexo = String.valueOf(tb_Persona.getValueAt(filas, 4));
        String Fecha = String.valueOf(tb_Persona.getValueAt(filas, 5));
        txtID.setText(Id);
        txtNombres.setText(Nombre);
        txtApellidos.setText(Apellido);
        txtEdad.setText(Edad);
        txtSexo.setText(Sexo);
        Date castfecha= new Date();
        try {
            castfecha = formato.parse(Fecha);
            txtFecha.setDate(castfecha);
        } catch (ParseException ex) {
            Logger.getLogger(PersonaCrud.class.getName()).log(Level.SEVERE, null, ex);
            txtFecha.setDate(null);
        }
    }//GEN-LAST:event_tb_PersonaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtID.setText(null);
        txtNombres.setText(null);
        txtApellidos.setText(null);
        txtEdad.setText(null);
        txtSexo.setText(null);
        txtFecha.setDate(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
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
            java.util.logging.Logger.getLogger(PersonaCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonaCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonaCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonaCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonaCrud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConector;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexo1;
    private javax.swing.JTable tb_Persona;
    private javax.swing.JTabbedPane tpMostrar;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtEdad;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtSexo;
    // End of variables declaration//GEN-END:variables
}
