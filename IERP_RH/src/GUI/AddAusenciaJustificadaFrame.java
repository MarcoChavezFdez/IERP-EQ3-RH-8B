/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.AusenciaJustificadaDAO;
import conexion.ConexionBD;
import conexion.EmpleadoDAO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.RH_AusenciaJustificada;
import modelo.RH_Empleado;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Marco Chavez
 */
public class AddAusenciaJustificadaFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddAusenciaJustificadaFrame
     */
    ConexionBD conexion;
    ArrayList<RH_Empleado> empleados;
    Boolean isNew;
    RH_AusenciaJustificada ausencia;
    String path;
    byte[] documento;

    public AddAusenciaJustificadaFrame(ConexionBD conexion) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.conexion = conexion;
        this.isNew = true;
        btn_Autoriza.setVisible(false);
        btn_Rechaza.setVisible(false);
    }

    public AddAusenciaJustificadaFrame(ConexionBD conexion, RH_AusenciaJustificada ausencia) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ausencia = ausencia;
        this.isNew = false;
        this.conexion = conexion;
        this.documento = ausencia.getEvidencia();
        btn_Ver.setEnabled(true);
        try {
            path = (new File(".").getCanonicalPath());
            FileUtils.writeByteArrayToFile(new File(path + "\\resources\\docAusencia.pdf"), this.documento);
            creaArchivo();
        } catch (IOException ex) {
            Logger.getLogger(AddAusenciaJustificadaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        ta_Motivo.setText(ausencia.getMotivo());
        for (int i = 1; i < cmb_Tipo.getItemCount(); i++) {
            if (cmb_Tipo.getItemAt(i).equals(this.ausencia.getTipo())) {
                cmb_Tipo.setSelectedIndex(i);
            }
        }

        for (int i = 1; i < cmb_Empleado.getItemCount(); i++) {
            if (cmb_Empleado.getItemAt(i).equals(this.ausencia.getEmpleadoSolicitador().getNombreCompleto())) {
                cmb_Empleado.setSelectedIndex(i);
            }
        }
        cmb_Empleado.setEnabled(false);
        dp_FechaInicio.setDate(this.ausencia.getFechaInicio().toLocalDate());
        dp_FechaFin.setDate(this.ausencia.getFechaFin().toLocalDate());
        txf_Estatus.setText(this.ausencia.getEstatus());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Motivo = new javax.swing.JTextPane();
        btn_Realizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Atras = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dp_FechaInicio = new com.github.lgooddatepicker.components.DatePicker();
        txf_Estatus = new javax.swing.JTextField();
        dp_FechaFin = new com.github.lgooddatepicker.components.DatePicker();
        btn_Autoriza = new javax.swing.JButton();
        cmb_Tipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btn_Seleccionar = new javax.swing.JButton();
        lbl_Mensaje = new javax.swing.JLabel();
        txf_Fecha = new javax.swing.JTextField();
        cmb_Empleado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lbl_MensajeDias = new javax.swing.JLabel();
        lbl_DiasD = new javax.swing.JLabel();
        btn_Ver = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbl_Titulo = new javax.swing.JLabel();
        btn_Rechaza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Documento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        ta_Motivo.setBackground(new java.awt.Color(153, 255, 153));
        jScrollPane1.setViewportView(ta_Motivo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 282, 93));

        btn_Realizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ausencia/RealOp.png"))); // NOI18N
        btn_Realizar.setBorderPainted(false);
        btn_Realizar.setContentAreaFilled(false);
        btn_Realizar.setEnabled(false);
        btn_Realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RealizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Realizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, 170, 80));

        jLabel1.setText("Fecha Solicitud");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        jLabel2.setText("Fecha Inicio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        jLabel3.setText("Fecha Fin");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        btn_Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        btn_Atras.setBorderPainted(false);
        btn_Atras.setContentAreaFilled(false);
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 90));

        jLabel4.setText("Motivo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

        jLabel5.setText("Tipo de Ausencia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        dp_FechaInicio.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.add(dp_FechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        txf_Estatus.setText("PENDIENTE");
        txf_Estatus.setEnabled(false);
        jPanel1.add(txf_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 110, 30));

        dp_FechaFin.setBackground(new java.awt.Color(153, 255, 153));
        dp_FechaFin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dp_FechaFinPropertyChange(evt);
            }
        });
        jPanel1.add(dp_FechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        btn_Autoriza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ausencia/Aut.png"))); // NOI18N
        btn_Autoriza.setBorderPainted(false);
        btn_Autoriza.setContentAreaFilled(false);
        jPanel1.add(btn_Autoriza, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 170, 60));

        cmb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE TIPO DE AUSENCIA", "INCAPACIDAD", "VACACIONES", "PERMISO" }));
        cmb_Tipo.setBackground(new java.awt.Color(153, 255, 153));
        cmb_Tipo.setEnabled(false);
        cmb_Tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_TipoItemStateChanged(evt);
            }
        });
        jPanel1.add(cmb_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        jLabel6.setText("Estatus");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, -1, -1));

        btn_Seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ausencia/SelDoc.png"))); // NOI18N
        btn_Seleccionar.setBorderPainted(false);
        btn_Seleccionar.setContentAreaFilled(false);
        btn_Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 180, 70));
        jPanel1.add(lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 240, 30));

        txf_Fecha.setText("dd/mm/yyyy");
        txf_Fecha.setEnabled(false);
        jPanel1.add(txf_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 120, -1));

        cmb_Empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE EMPLEADO" }));
        cmb_Empleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_EmpleadoItemStateChanged(evt);
            }
        });
        jPanel1.add(cmb_Empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 270, -1));

        jLabel8.setText("Empleado");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));
        jPanel1.add(lbl_MensajeDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 130, 30));
        jPanel1.add(lbl_DiasD, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 130, 20));

        btn_Ver.setText("Ver Documento");
        btn_Ver.setEnabled(false);
        btn_Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VerActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, -1, -1));

        jLabel9.setText("Ausencias Justificadas");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        lbl_Titulo.setText("Añadir Ausencia Justificada");
        jPanel1.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        btn_Rechaza.setText("Rechazar");
        jPanel1.add(btn_Rechaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        AusenciasJustificadasFrame ausenciasFrame = new AusenciasJustificadasFrame(this.conexion);
        this.dispose();
        ausenciasFrame.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txf_Fecha.setText(LocalDate.now().toString());
        EmpleadoDAO daoEmpleado = new EmpleadoDAO(this.conexion);
        empleados = daoEmpleado.consultaEmpleadosVista();
        empleados.forEach((e) -> {
            cmb_Empleado.addItem(e.getNombreCompleto());
            if (!isNew) {
                if (e.getNombreCompleto().equals(ausencia.getEmpleadoSolicitador().getNombreCompleto())) {
                    cmb_Empleado.setSelectedIndex(empleados.indexOf(e) + 1);
                }
            }
        });


    }//GEN-LAST:event_formWindowOpened

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        validaCampos();
    }//GEN-LAST:event_jPanel1MouseMoved

    private void creaArchivo() {
        try {
            path = (new File(".").getCanonicalPath());
            FileUtils.writeByteArrayToFile(new File(path + "\\resources\\docAusencia.pdf"), this.documento);
        } catch (IOException ex) {
            Logger.getLogger(AddAusenciaJustificadaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btn_SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SeleccionarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        //Filtro del filechooser   
        fileChooser.setFileFilter(new FileNameExtensionFilter("Documentos", "pdf"));
        fileChooser.showOpenDialog(fileChooser);
        try {
            File file = null;
            file = fileChooser.getSelectedFile();
            if (file!=null) {
                documento = FileUtils.readFileToByteArray(fileChooser.getSelectedFile());
                creaArchivo();
            }

            if (documento != null) {
                btn_Ver.setEnabled(true);
            } else {
                btn_Ver.setEnabled(false);
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(AddAusenciaJustificadaFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddAusenciaJustificadaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_SeleccionarActionPerformed

    private void dp_FechaFinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dp_FechaFinPropertyChange
        validaDias();
    }//GEN-LAST:event_dp_FechaFinPropertyChange

    private void btn_RealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RealizarActionPerformed
        RH_AusenciaJustificada ausenciaJustificada = new RH_AusenciaJustificada();
        EmpleadoDAO daoEmpleado = new EmpleadoDAO(this.conexion);
        ausenciaJustificada.setFechaSolicitud(java.sql.Date.valueOf(txf_Fecha.getText()));
        ausenciaJustificada.setEvidencia(documento);
        ausenciaJustificada.setFechaFin(java.sql.Date.valueOf(dp_FechaFin.getDate()));
        ausenciaJustificada.setFechaInicio(java.sql.Date.valueOf(dp_FechaInicio.getDate()));
        ausenciaJustificada.setMotivo(ta_Motivo.getText());
        ausenciaJustificada.setEstatus(txf_Estatus.getText());
        ausenciaJustificada.setTipo(cmb_Tipo.getItemAt(cmb_Tipo.getSelectedIndex()));
        ausenciaJustificada.setEmpleadoSolicitador(empleados.get(cmb_Empleado.getSelectedIndex() - 1));
        ausenciaJustificada.setEmpleadoAutorizador(daoEmpleado.consultaEmpleadoDirectorRH());
        AusenciaJustificadaDAO ausenciaDAO = new AusenciaJustificadaDAO(this.conexion);
        if (isNew) {
            if (ausenciaDAO.insertarAusenciaJustificada(ausenciaJustificada)) {
                JOptionPane.showMessageDialog(null, "Ausencia Añadida con exito");
                AusenciasJustificadasFrame ausenciasJustificadas = new AusenciasJustificadasFrame(this.conexion);
                this.dispose();
                ausenciasJustificadas.setVisible(true);
                this.pack();
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al añadir la ausencia");
            }
        } else {
            ausenciaJustificada.setIdAusencia(this.ausencia.getIdAusencia());
            if (ausenciaDAO.actualizarAusenciaJustificada(ausenciaJustificada)) {
                JOptionPane.showMessageDialog(null, "Ausencia Modificada con exito");
                AusenciasJustificadasFrame ausenciasJustificadas = new AusenciasJustificadasFrame(this.conexion);
                this.dispose();
                ausenciasJustificadas.setVisible(true);
                this.pack();
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar la ausencia");
            }
        }
    }//GEN-LAST:event_btn_RealizarActionPerformed

    private void cmb_TipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_TipoItemStateChanged
        muestraDias();

    }//GEN-LAST:event_cmb_TipoItemStateChanged

    private void muestraDias() {
        try {
            AusenciaJustificadaDAO daoAusencia = new AusenciaJustificadaDAO(this.conexion);
            Integer diasUtilizados;
            Integer diasRestantes = 0;
            if (cmb_Tipo.getSelectedIndex() > 1) {
                if (cmb_Tipo.getSelectedIndex() == 2) {
                    diasRestantes = empleados.get(cmb_Empleado.getSelectedIndex() - 1).getDiasPermiso();
                    diasUtilizados = daoAusencia.calculaDiasPermiso(java.sql.Date.valueOf(LocalDate.now()), empleados.get(cmb_Empleado.getSelectedIndex() - 1).getIdEmpleado());
                    diasRestantes -= diasUtilizados;
                } else if (cmb_Tipo.getSelectedIndex() == 3) {
                    diasRestantes = empleados.get(cmb_Empleado.getSelectedIndex() - 1).getDiasVacaciones();
                    diasUtilizados = daoAusencia.calculaDiasVacaciones(java.sql.Date.valueOf(LocalDate.now()), empleados.get(cmb_Empleado.getSelectedIndex() - 1).getIdEmpleado());
                    diasRestantes -= diasUtilizados;
                }
                lbl_DiasD.setText("Dias Disponibles: " + diasRestantes);
            } else {
                lbl_DiasD.setText("");
            }
        } catch (NullPointerException e) {

        }
    }
    private void cmb_EmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_EmpleadoItemStateChanged
        if (cmb_Empleado.getSelectedIndex() > 0) {
            cmb_Tipo.setEnabled(true);
        } else {
            cmb_Tipo.setEnabled(false);
        }
    }//GEN-LAST:event_cmb_EmpleadoItemStateChanged

    private void btn_VerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VerActionPerformed
        try {
            path = (new File(".").getCanonicalPath());
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + path + "\\resources\\docAusencia.pdf");
        } catch (Exception evvv) {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda, probablemente fue borrado", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btn_VerActionPerformed
    public Boolean validaDias() {
        AusenciaJustificadaDAO daoAusencia = new AusenciaJustificadaDAO(this.conexion);
        Integer diasUtilizados;
        Boolean aprobacion = false;
        try {
            //vaccaciones
            long daysBetween = DAYS.between(dp_FechaInicio.getDate(), dp_FechaFin.getDate()) + 1;
            switch (cmb_Tipo.getSelectedIndex()) {
                case 2:
                    diasUtilizados = daoAusencia.calculaDiasPermiso(java.sql.Date.valueOf(dp_FechaInicio.getDate()), empleados.get(cmb_Empleado.getSelectedIndex() - 1).getIdEmpleado());
                    if (empleados.get(cmb_Empleado.getSelectedIndex() - 1).getDiasPermiso() - diasUtilizados >= daysBetween) {
                        //puede pedir permiso
                        aprobacion = true;
                    } else {
                        //no puede pedir permiso
                        aprobacion = false;
                    }
                    break;
                case 3:
                    diasUtilizados = daoAusencia.calculaDiasVacaciones(java.sql.Date.valueOf(dp_FechaInicio.getDate()), empleados.get(cmb_Empleado.getSelectedIndex() - 1).getIdEmpleado());
                    if (empleados.get(cmb_Empleado.getSelectedIndex() - 1).getDiasVacaciones() - diasUtilizados >= daysBetween) {
                        //puede pedir vacaciones
                        aprobacion = true;

                    } else {
                        //no puede pedir vacaciones
                        aprobacion = false;
                    }
                    break;
                case 1:
                    aprobacion = true;
                    break;
                default:
                    break;
            }
        } catch (NullPointerException ex) {
            aprobacion = false;
        }
        return aprobacion;
    }

    public void validaCampos() {
        try {
            if ((dp_FechaInicio.getDate().isBefore(dp_FechaFin.getDate())) && cmb_Empleado.getSelectedIndex() > 0 && cmb_Tipo.getSelectedIndex() > 0 && !"".equals(ta_Motivo.getText()) && validaDias() && documento!=null) {
                btn_Realizar.setEnabled(true);
                lbl_Mensaje.setText("");
            } else {
                btn_Realizar.setEnabled(false);
                lbl_Mensaje.setText("Debe completar todos los campos");
            }
        } catch (NullPointerException ex) {
            btn_Realizar.setEnabled(false);
            lbl_Mensaje.setText("Debe completar todos los campos");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_Autoriza;
    private javax.swing.JButton btn_Realizar;
    private javax.swing.JButton btn_Rechaza;
    private javax.swing.JButton btn_Seleccionar;
    private javax.swing.JButton btn_Ver;
    private javax.swing.JComboBox<String> cmb_Empleado;
    private javax.swing.JComboBox<String> cmb_Tipo;
    private com.github.lgooddatepicker.components.DatePicker dp_FechaFin;
    private com.github.lgooddatepicker.components.DatePicker dp_FechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_DiasD;
    private javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_MensajeDias;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTextPane ta_Motivo;
    private javax.swing.JTextField txf_Estatus;
    private javax.swing.JTextField txf_Fecha;
    // End of variables declaration//GEN-END:variables
}
