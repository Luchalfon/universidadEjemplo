
package universidadejemplo.vistas;

import java.sql.Connection;
import java.sql.Date;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.accesoADatos.AlumnoData;
import universidadejemplo.accesoADatos.miConexion;
import validacion.ValidacionDeIngresos;


public class alumnosVista extends javax.swing.JInternalFrame {

    
    public alumnosVista() {
        initComponents();
        Modificar.setEnabled(false);
        Guardar.setEnabled(false);
        Eliminar.setEnabled(false);
        
    }
    private Connection con;
    Alumno alumno1;

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        textDocu = new javax.swing.JTextField();
        textApe = new javax.swing.JTextField();
        textNom = new javax.swing.JTextField();
        OptionEstado = new javax.swing.JRadioButton();
        textFecha = new javax.swing.JTextField();
        LabelLegajo = new javax.swing.JLabel();
        TextLegajo = new javax.swing.JTextField();
        Modificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Alumno");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alumno");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Documento");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Apellido");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Estado");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Fecha de nacimiento");

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/diseño/buscar.png"))); // NOI18N
        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/diseño/new_25355.png"))); // NOI18N
        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/diseño/eliminar.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/diseño/guardar.png"))); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/diseño/salir.png"))); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        textDocu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        textNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomActionPerformed(evt);
            }
        });

        OptionEstado.setSelected(true);

        LabelLegajo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelLegajo.setText("Legajo");

        TextLegajo.setEnabled(false);

        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/diseño/modificar.png"))); // NOI18N
        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        jLabel7.setText("(AAAA-MM-DD)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Buscar)
                                .addGap(43, 43, 43))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelLegajo)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(97, 97, 97)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(textNom, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textApe, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(OptionEstado)
                                                .addComponent(TextLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addComponent(textDocu, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(195, 195, 195))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(248, 248, 248))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(LabelLegajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(TextLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(textDocu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OptionEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textFecha))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        Buscar.setEnabled(false);
        Modificar.setEnabled(false);
        Eliminar.setEnabled(false);
        Guardar.setEnabled(true);
        TextLegajo.setText("");
        textNom.setText("");
        textApe.setText("");
        textDocu.setText("");
        textFecha.setText("");
        textDocu.requestFocus();
        
        
    }//GEN-LAST:event_NuevoActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
//        String fecha1 = textFecha.getText();
//        Date fecha = Date.valueOf(fecha1);
//        Alumno alumno = new Alumno(
//        Integer.parseInt(textDocu.getText()),
//        textApe.getText(),
//        textNom.getText(),
//        fecha,
//        true);
//        AlumnoData alumnoCon = new AlumnoData();
//        alumnoCon.guardarAlumno(alumno);
    if(ValidacionDeIngresos.validarEntero(textDocu.getText()) 
            && !textApe.getText().isEmpty()
            && !textNom.getText().isEmpty()){
        CrearAlumno();
        AlumnoData alum = new AlumnoData();
        alum.guardarAlumno(alumno1);
    }else{
        JOptionPane.showMessageDialog(this, "Verifique los campos y sus ingresos");
    }
    TextLegajo.setText("");
        textNom.setText("");
        textApe.setText("");
        textDocu.setText("");
        textFecha.setText("");
        Buscar.setEnabled(true);
        Nuevo.setEnabled(true);
        Modificar.setEnabled(false);
        Guardar.setEnabled(false);
        Eliminar.setEnabled(false);
    
    
    
    }//GEN-LAST:event_GuardarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        String id = JOptionPane.showInputDialog(null, "ingrese el Legajo del Alumno a eliminar");
        //crear metodo de validacion ingreso mas tarde NumberFormatException
        if(ValidacionDeIngresos.validarEntero(id)){
        int idAlu = Integer.parseInt(id);
            AlumnoData alum = new AlumnoData();
            alum.eliminarAlumno(idAlu);
            TextLegajo.setText("");
            textNom.setText("");
            textApe.setText("");
            textDocu.setText("");
            textFecha.setText("");
            Buscar.setEnabled(true);
            Nuevo.setEnabled(true);
            Modificar.setEnabled(false);
            Guardar.setEnabled(false);
            Eliminar.setEnabled(false);
    
        }else{
            JOptionPane.showMessageDialog(null, "Ingreso invalido, ingre un numero");
        }
        /*try {
            int idAlu = Integer.parseInt(id);
            AlumnoData alum = new AlumnoData();
            alum.eliminarAlumno(idAlu);
            TextLegajo.setText("");
            textNom.setText("");
            textApe.setText("");
            textDocu.setText("");
            textFecha.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingreso invalido, ingre un numero");
        }
        */
    }//GEN-LAST:event_EliminarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        Guardar.setEnabled(false);
        OptionEstado.setEnabled(false);
        String opciones = (JOptionPane.showInputDialog(null, "seleccione una opcion", "Buscar", JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Buscar por dni", "Buscar por id"}, "seleccion")).toString();

        switch (opciones) {
            case "Buscar por dni":
                String dni = JOptionPane.showInputDialog("Ingrese el dni");
                if(ValidacionDeIngresos.validarEntero(dni)){
                int dni1 = Integer.parseInt(dni);
                System.out.println("Ingreso un dni " + dni);
                AlumnoData alum = new AlumnoData();
                alumno1 = alum.buscarAlumnoPorDni(dni1);
                TextLegajo.setText(alumno1.getId_alumno() + "");
                textApe.setText(alumno1.getApellido());
                textDocu.setText(String.valueOf(alumno1.getDni()));
                textNom.setText(alumno1.getNombre());
                textFecha.setText(String.valueOf(alumno1.getFecha_nacimiento()));
                }else{
                    JOptionPane.showMessageDialog(this, "Ingreso invalido, ingrese un numero de DNI");
                }
                break;
            case "Buscar por id":
                String id = JOptionPane.showInputDialog("Ingrese el id");
                if(ValidacionDeIngresos.validarEntero(id)){
                int miId = Integer.parseInt(id);
                System.out.println("Ingreso un id " + id);
                AlumnoData aluid = new AlumnoData();
                alumno1 = aluid.buscarAlumnoPorID(miId);
                TextLegajo.setText(id);
                textApe.setText(alumno1.getApellido());
                textDocu.setText(String.valueOf(alumno1.getDni()));
                textNom.setText(alumno1.getNombre());
                textFecha.setText(String.valueOf(alumno1.getFecha_nacimiento()));
                }else{
                    JOptionPane.showMessageDialog(this, "Ingrese in valor numerico");
                }
                break;

        }

        Modificar.setEnabled(true);
        Eliminar.setEnabled(true);
        Nuevo.setEnabled(true);
        Guardar.setEnabled(false);
        
    }//GEN-LAST:event_BuscarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        Alumno alumno1 = new Alumno();
        AlumnoData alumData = new AlumnoData();
        if(ValidacionDeIngresos.validarEntero(textDocu.getText()) &&
                !textApe.getText().isEmpty() &&
                !textNom.getText().isEmpty()){
        alumno1.setId_alumno(Integer.parseInt(TextLegajo.getText()));
        
        alumno1.setDni(Integer.parseInt(textDocu.getText()));
        
            
        
        alumno1.setApellido(textApe.getText());
        alumno1.setNombre(textNom.getText());
        alumno1.setEstado(true);
        //verificar validacion para la fecha o usar calendar
        alumno1.setFecha_nacimiento(Date.valueOf(textFecha.getText()));
        
        alumData.modificarAlumno(alumno1);
        }else{
            JOptionPane.showMessageDialog(this, "Verifique que los campos ingresados correspopndan al tipo de dato a m odificar /n");
        }
        
     Nuevo.setEnabled(true);
     Modificar.setEnabled(false);
     Guardar.setEnabled(false);
     Eliminar.setEnabled(false);
     TextLegajo.setText("");
     textNom.setText("");
     textApe.setText("");
     textDocu.setText("");
     textFecha.setText("");
    }//GEN-LAST:event_ModificarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel LabelLegajo;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Nuevo;
    private javax.swing.JRadioButton OptionEstado;
    private javax.swing.JButton Salir;
    private javax.swing.JTextField TextLegajo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField textApe;
    private javax.swing.JTextField textDocu;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textNom;
    // End of variables declaration//GEN-END:variables

    public Alumno CrearAlumno() {
        
        int dni = Integer.parseInt(textDocu.getText());
        String nombre = textNom.getText();
        String apellido = textApe.getText();
        String Fecha = textFecha.getText();
        Date FechaNacimiento = Date.valueOf(Fecha);

        alumno1 = new Alumno(dni, apellido, nombre, FechaNacimiento, true);

        return alumno1;
    }
}
