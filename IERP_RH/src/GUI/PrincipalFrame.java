/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.AsistenciaDAO;
import conexion.ConexionBD;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.swing.JOptionPane;
import modelo.RH_Asistencia;

/**
 *
 * @author Marco Chavez
 */
public class PrincipalFrame extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalFrame
     */
    ConexionBD conexion;
    RH_Asistencia asistencia;

    public PrincipalFrame(ConexionBD conexion) {
        this.conexion = conexion;
        initComponents();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        lbl_fecha.setText(dateFormat.format(date));
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
        lbl_User.setText(this.conexion.getEmpleado().getNombre());
        AsistenciaDAO daoAsistencia = new AsistenciaDAO(this.conexion);
        asistencia = daoAsistencia.consultaAsistenciaFecha(java.sql.Date.valueOf(LocalDate.now()), this.conexion.getEmpleado());
        if (Objects.isNull(asistencia)) {
            btn_Asistencia.setText("Registrar Entrada");
        } else {
            btn_Asistencia.setText("Registrar Salida");
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        etiquetaReloj.setText(formateador.format(LocalDateTime.now()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        evaluatorFloat1 = new org.jdesktop.core.animation.timing.evaluators.EvaluatorFloat();
        jPanel1 = new javax.swing.JPanel();
        btn_Puestos1 = new javax.swing.JButton();
        btn_Ciudades = new javax.swing.JButton();
        btn_Deducciones = new javax.swing.JButton();
        btn_Asistencias = new javax.swing.JButton();
        btn_Turnos = new javax.swing.JButton();
        btn_Historial = new javax.swing.JButton();
        btn_Justificaciones = new javax.swing.JButton();
        bnt_Estados = new javax.swing.JButton();
        btn_Nominas = new javax.swing.JButton();
        btn_Nomdem = new javax.swing.JButton();
        btn_Periodos = new javax.swing.JButton();
        btn_NomPer = new javax.swing.JButton();
        btn_Formas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        etiquetaReloj = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_User = new javax.swing.JLabel();
        btn_CerrarSesion = new javax.swing.JButton();
        btn_Empleados = new javax.swing.JButton();
        btn_Percepciones = new javax.swing.JButton();
        btn_Departamentos = new javax.swing.JButton();
        btn_Puestos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_Asistencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Puestos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnDocumentacion.png"))); // NOI18N
        btn_Puestos1.setBorderPainted(false);
        btn_Puestos1.setContentAreaFilled(false);
        jPanel1.add(btn_Puestos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 180, 50));

        btn_Ciudades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnCiudades.png"))); // NOI18N
        btn_Ciudades.setBorderPainted(false);
        btn_Ciudades.setContentAreaFilled(false);
        btn_Ciudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CiudadesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Ciudades, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 150, 60));

        btn_Deducciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnDeducciones.png"))); // NOI18N
        btn_Deducciones.setBorderPainted(false);
        btn_Deducciones.setContentAreaFilled(false);
        btn_Deducciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeduccionesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Deducciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 170, 50));

        btn_Asistencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAsistencias.png"))); // NOI18N
        btn_Asistencias.setBorderPainted(false);
        btn_Asistencias.setContentAreaFilled(false);
        btn_Asistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AsistenciasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Asistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 270, 160, 50));

        btn_Turnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/bntTurnos.png"))); // NOI18N
        btn_Turnos.setBorderPainted(false);
        btn_Turnos.setContentAreaFilled(false);
        btn_Turnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TurnosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Turnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 170, 60));

        btn_Historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnHistorial.png"))); // NOI18N
        btn_Historial.setToolTipText("");
        btn_Historial.setBorderPainted(false);
        btn_Historial.setContentAreaFilled(false);
        btn_Historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 330, 170, 50));

        btn_Justificaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnJustificaciones.png"))); // NOI18N
        btn_Justificaciones.setToolTipText("");
        btn_Justificaciones.setBorderPainted(false);
        btn_Justificaciones.setContentAreaFilled(false);
        btn_Justificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_JustificacionesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Justificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 330, 170, 50));

        bnt_Estados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnEstados.png"))); // NOI18N
        bnt_Estados.setBorderPainted(false);
        bnt_Estados.setContentAreaFilled(false);
        bnt_Estados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_EstadosActionPerformed(evt);
            }
        });
        jPanel1.add(bnt_Estados, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 170, 50));

        btn_Nominas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnNominas.png"))); // NOI18N
        btn_Nominas.setBorderPainted(false);
        btn_Nominas.setContentAreaFilled(false);
        btn_Nominas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NominasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Nominas, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 170, 50));

        btn_Nomdem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnNom-Ded.png"))); // NOI18N
        btn_Nomdem.setBorderPainted(false);
        btn_Nomdem.setContentAreaFilled(false);
        btn_Nomdem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NomdemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Nomdem, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 640, 170, 50));

        btn_Periodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnPeriodos.png"))); // NOI18N
        btn_Periodos.setBorderPainted(false);
        btn_Periodos.setContentAreaFilled(false);
        btn_Periodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PeriodosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Periodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 640, 170, 50));

        btn_NomPer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnNom-Per.png"))); // NOI18N
        btn_NomPer.setBorderPainted(false);
        btn_NomPer.setContentAreaFilled(false);
        btn_NomPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NomPerActionPerformed(evt);
            }
        });
        jPanel1.add(btn_NomPer, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 640, 170, 50));

        btn_Formas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnFormas.png"))); // NOI18N
        btn_Formas.setBorderPainted(false);
        btn_Formas.setContentAreaFilled(false);
        btn_Formas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FormasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Formas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 740, 170, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 0));
        jLabel1.setText("Menú Principal");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        etiquetaReloj.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        etiquetaReloj.setText("hh:mm:ss");
        jPanel1.add(etiquetaReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 750, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Hora:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 750, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 790, -1, -1));

        lbl_fecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_fecha.setText("dd/mm/aaaa");
        jPanel1.add(lbl_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 790, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setText("Hola de nuevo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 500, -1, -1));

        lbl_User.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel1.add(lbl_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 550, 250, 140));

        btn_CerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/General/Cerrar.png"))); // NOI18N
        btn_CerrarSesion.setBorderPainted(false);
        btn_CerrarSesion.setContentAreaFilled(false);
        btn_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btn_CerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, -1));

        btn_Empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnEmpleados.png"))); // NOI18N
        btn_Empleados.setToolTipText("");
        btn_Empleados.setBorderPainted(false);
        btn_Empleados.setContentAreaFilled(false);
        btn_Empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 170, 50));

        btn_Percepciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnPercepciones.png"))); // NOI18N
        btn_Percepciones.setBorderPainted(false);
        btn_Percepciones.setContentAreaFilled(false);
        btn_Percepciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PercepcionesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Percepciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, 170, 50));

        btn_Departamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnDepartamentos.png"))); // NOI18N
        btn_Departamentos.setBorderPainted(false);
        btn_Departamentos.setContentAreaFilled(false);
        btn_Departamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DepartamentosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Departamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 170, 50));

        btn_Puestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnPuestos.png"))); // NOI18N
        btn_Puestos.setBorderPainted(false);
        btn_Puestos.setContentAreaFilled(false);
        btn_Puestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PuestosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Puestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 180, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/PersonalPanel.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 410));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/EcoPanel.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, 410));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/GeoPanel.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, 410));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/ControlPanel.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, -1, 410));

        btn_Asistencia.setText("Asistencia");
        btn_Asistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AsistenciaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Asistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 820, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnt_EstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_EstadosActionPerformed
        EstadosFrame estados = new EstadosFrame(this.conexion);
        this.dispose();
        estados.setVisible(true);
        estados.pack();

    }//GEN-LAST:event_bnt_EstadosActionPerformed

    private void btn_CiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CiudadesActionPerformed
        CiudadesFrame ciudades = new CiudadesFrame(this.conexion);
        this.dispose();
        ciudades.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_CiudadesActionPerformed

    private void btn_TurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TurnosActionPerformed
        // TODO add your handling code here:
        TurnosFrame turno = new TurnosFrame(this.conexion);
        this.dispose();
        turno.setVisible(true);
        turno.pack();
    }//GEN-LAST:event_btn_TurnosActionPerformed

    private void btn_DeduccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeduccionesActionPerformed
        DeduccionesFrame deduccion = new DeduccionesFrame(this.conexion);
        this.dispose();
        deduccion.setVisible(true);
        deduccion.pack();
    }//GEN-LAST:event_btn_DeduccionesActionPerformed

    private void btn_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarSesionActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea Cerrar Sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            login ventanaLogin = new login();
            this.dispose();
            ventanaLogin.setVisible(true);
            ventanaLogin.pack();
            JOptionPane.showMessageDialog(null, "Sesión Finalizada");
        }
    }//GEN-LAST:event_btn_CerrarSesionActionPerformed

    private void btn_EmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EmpleadosActionPerformed
        EmpleadosFrame empleados = new EmpleadosFrame(this.conexion);
        this.dispose();
        empleados.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_EmpleadosActionPerformed

    private void btn_DepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DepartamentosActionPerformed
        DepartamentoFrame departamentos = new DepartamentoFrame(this.conexion);
        this.dispose();
        departamentos.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_DepartamentosActionPerformed

    private void btn_PercepcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PercepcionesActionPerformed
        Percepciones percepcion = new Percepciones(this.conexion);
        this.dispose();
        percepcion.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_PercepcionesActionPerformed

    private void btn_AsistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AsistenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AsistenciasActionPerformed

    private void btn_HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_HistorialActionPerformed

    private void btn_JustificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_JustificacionesActionPerformed
        AusenciasJustificadasFrame ausenciasFrame = new AusenciasJustificadasFrame(conexion);
        this.dispose();
        ausenciasFrame.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_JustificacionesActionPerformed

    private void btn_NominasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NominasActionPerformed
        NominasFrame nominas = new NominasFrame(this.conexion);
        this.dispose();
        nominas.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_NominasActionPerformed

    private void btn_NomdemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NomdemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NomdemActionPerformed

    private void btn_PeriodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PeriodosActionPerformed
        PeriodosFrame periodos = new PeriodosFrame(this.conexion);
        this.dispose();
        periodos.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_PeriodosActionPerformed

    private void btn_NomPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NomPerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NomPerActionPerformed

    private void btn_FormasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FormasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_FormasActionPerformed
    private void btn_PuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PuestosActionPerformed
        PuestosFrame puesto = new PuestosFrame(this.conexion);
        this.dispose();
        puesto.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_PuestosActionPerformed

    private void btn_AsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AsistenciaActionPerformed
        AsistenciaDAO daoAsistencia = new AsistenciaDAO(this.conexion);
        if (Objects.isNull(asistencia)) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(java.sql.Date.valueOf(LocalDate.now()));
            cal.get(GregorianCalendar.DAY_OF_WEEK);
            asistencia = new RH_Asistencia();
            asistencia.setFecha(java.sql.Date.valueOf(LocalDate.now()));
            asistencia.setEmpleado(this.conexion.getEmpleado());
            asistencia.setHoraEntrada(Time.valueOf(LocalTime.now()));
            asistencia.setEstatus("A");
            switch (cal.get(GregorianCalendar.DAY_OF_WEEK)) {
                case 1:
                    asistencia.setDia("DOMINGO");
                    break;
                case 2:
                    asistencia.setDia("LUNES");
                    break;
                case 3:
                    asistencia.setDia("MARTES");
                    break;
                case 4:
                    asistencia.setDia("MIERCOLES");
                    break;
                case 5:
                    asistencia.setDia("JUEVES");
                    break;
                case 6:
                    asistencia.setDia("VIERNES");
                    break;
                case 7:
                    asistencia.setDia("SABADO");
            }

            if (daoAsistencia.insertarAsistencia(asistencia)) {
                JOptionPane.showMessageDialog(null, "Entrada Registrada con Exito");
                asistencia = daoAsistencia.consultaAsistenciaFecha(java.sql.Date.valueOf(LocalDate.now()), this.conexion.getEmpleado());
                btn_Asistencia.setText("Registrar Salida");
            }

        } else {
            asistencia.setHoraSalida(java.sql.Time.valueOf(LocalTime.now()));
            if (daoAsistencia.actualizarAsistencia(asistencia)) {
                int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea registar la salida?. Se cerrará la sesión y no podrá iniciar de nuevo", "Confirmar Registro de salidaa", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Salida Registrada con Exito");
                    btn_Asistencia.setEnabled(false);
                    login ventanaLogin = new login();
                    this.dispose();
                    ventanaLogin.setVisible(true);
                    ventanaLogin.pack();
                    JOptionPane.showMessageDialog(null, "Sesión Finalizada");
                } else {
                    JOptionPane.showMessageDialog(null, "Registro de Salida Cancelado");
                }

            }
        }
    }//GEN-LAST:event_btn_AsistenciaActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_Estados;
    private javax.swing.JButton btn_Asistencia;
    private javax.swing.JButton btn_Asistencias;
    private javax.swing.JButton btn_CerrarSesion;
    private javax.swing.JButton btn_Ciudades;
    private javax.swing.JButton btn_Deducciones;
    private javax.swing.JButton btn_Departamentos;
    private javax.swing.JButton btn_Empleados;
    private javax.swing.JButton btn_Formas;
    private javax.swing.JButton btn_Historial;
    private javax.swing.JButton btn_Justificaciones;
    private javax.swing.JButton btn_NomPer;
    private javax.swing.JButton btn_Nomdem;
    private javax.swing.JButton btn_Nominas;
    private javax.swing.JButton btn_Percepciones;
    private javax.swing.JButton btn_Periodos;
    private javax.swing.JButton btn_Puestos;
    private javax.swing.JButton btn_Puestos1;
    private javax.swing.JButton btn_Turnos;
    private javax.swing.JLabel etiquetaReloj;
    private org.jdesktop.core.animation.timing.evaluators.EvaluatorFloat evaluatorFloat1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_User;
    private javax.swing.JLabel lbl_fecha;
    // End of variables declaration//GEN-END:variables
}
