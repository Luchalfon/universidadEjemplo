/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.vistas;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Materia;
import universidadejemplo.Entidades.Inscripcion;
import universidadejemplo.accesoADatos.AlumnoData;
import universidadejemplo.accesoADatos.inscripcionData;
import universidadejemplo.accesoADatos.materiaData;

/**
 *
 * @author ULP
 */
public class inscripcionVista extends javax.swing.JInternalFrame {

    /**
     * Creates new form inscripcionVista
     */
    private DefaultTableModel modelo = new DefaultTableModel();

    public inscripcionVista() {
        initComponents();
        llenarCombo();
        armarCabecera();

    }
    private Connection con;
    Alumno aluSelect;
    private int id_aluSelect;
    private int idMateriaSelect;
    private Materia materiasl = new Materia();
    private materiaData mateData = new materiaData();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        BotonInsc = new javax.swing.JButton();
        BotonAnularInsc = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Inscripcion");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione un aumno");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Listado de materias");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setText("Materias inscriptas");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2.setText("Materias no inscriptas");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        BotonInsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/diseño/inscribir.png"))); // NOI18N
        BotonInsc.setText("Inscribir");
        BotonInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInscActionPerformed(evt);
            }
        });

        BotonAnularInsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/diseño/anular inscripcion.png"))); // NOI18N
        BotonAnularInsc.setText("Anular Inscripcion");
        BotonAnularInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnularInscActionPerformed(evt);
            }
        });

        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/diseño/salir.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BotonInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonAnularInsc)
                                .addGap(51, 51, 51)
                                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonAnularInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        aluSelect = (Alumno) jComboBox1.getSelectedItem();
        id_aluSelect = aluSelect.getId_alumno();
        System.out.println(id_aluSelect);
        modelo.setRowCount(0);
//        llenarTabla();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        modelo.setRowCount(0);
        llenarCursada();
        BotonAnularInsc.setEnabled(true);
        BotonInsc.setEnabled(false);

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        modelo.setRowCount(0);
        llenarNoCursada();
        BotonAnularInsc.setEnabled(false);
        BotonInsc.setEnabled(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int filaSelect = jTable1.getSelectedRow();

        if (filaSelect != -1) {

            idMateriaSelect = (Integer) jTable1.getValueAt(filaSelect, 0);
            materiasl = mateData.buscarMateriaPorID(idMateriaSelect);
            
            }
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void BotonInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInscActionPerformed
        Inscripcion insc = new Inscripcion(0,aluSelect, materiasl);
        inscripcionData inscData = new inscripcionData();
        
        if (idMateriaSelect==0){
            JOptionPane.showMessageDialog(this, "Seleccione una Materia");
        }else{
            inscData.guardarInscripcion(insc);
        modelo.setRowCount(0);
        llenarNoCursada();
        idMateriaSelect=0;
        }
        
        
        
    }//GEN-LAST:event_BotonInscActionPerformed

    private void BotonAnularInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnularInscActionPerformed
        inscripcionData inscData = new inscripcionData();
        inscData.borrarInscripcionAlumnoMateria(id_aluSelect, idMateriaSelect);
        modelo.setRowCount(0);
        llenarCursada();
    }//GEN-LAST:event_BotonAnularInscActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAnularInsc;
    private javax.swing.JButton BotonInsc;
    private javax.swing.JButton botonSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Alumno> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void llenarCombo() {
        List<Alumno> alumno = new ArrayList<>();

        AlumnoData aludata = new AlumnoData();
        alumno = aludata.listarAlumnos();

        for (Alumno alu : alumno) {

            jComboBox1.addItem(alu);
        }
    }

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");

        jTable1.setModel(modelo);
    }

    private void llenarCursada() {
        inscripcionData inscData = new inscripcionData();
        for (Materia mateCursa : inscData.obtenerMateriasCursadas(id_aluSelect)) {
            modelo.addRow(new Object[]{mateCursa.getId_materia(), mateCursa.getNombre(), mateCursa.getAño()});

        }

    }

    private void llenarNoCursada() {
        inscripcionData inscData = new inscripcionData();
        for (Materia mateCursa : inscData.obtenerMateriasNOCursadas(id_aluSelect)) {
            modelo.addRow(new Object[]{mateCursa.getId_materia(), mateCursa.getNombre(), mateCursa.getAño()});

        }

    }

}
