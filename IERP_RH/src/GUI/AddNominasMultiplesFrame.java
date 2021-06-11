/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.ConexionBD;
import conexion.DeduccionDAO;
import conexion.EmpleadoDAO;
import conexion.EstadoDAO;
import conexion.FormaPagoDAO;
import conexion.NominaDAO;
import conexion.NominaDeduccionDAO;
import conexion.NominaPercepcionDAO;
import conexion.PercepcionDAO;
import conexion.PeriodoDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.RH_Empleado;
import javax.swing.table.DefaultTableModel;
import modelo.RH_Deduccion;
import modelo.RH_FormaPago;
import modelo.RH_Nomina;
import modelo.RH_NominaDeduccion;
import modelo.RH_NominaPercepcion;
import modelo.RH_Percepcion;
import modelo.RH_Periodo;

/**
 *
 * @author Marco Chavez
 */
public class AddNominasMultiplesFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddEmpleadoFrame
     */
    ConexionBD conexion;
    RH_Empleado empleado;

    ArrayList<RH_FormaPago> formasPago;
    ArrayList<RH_Periodo> periodos;

    ArrayList<RH_Empleado> empleadosTabla = new ArrayList<>();
    ArrayList<RH_Percepcion> percepcionesTabla = new ArrayList<>();
    ArrayList<RH_Deduccion> deduccionesTabla = new ArrayList<>();

    ArrayList<RH_Empleado> empleadosSeleccionados = new ArrayList<>();
    ArrayList<RH_Percepcion> percepcionesSeleccionadas = new ArrayList<>();
    ArrayList<RH_Deduccion> deduccionesSeleccionadas = new ArrayList<>();

    EstadoDAO daoEstado;
    Boolean isNew;

    public AddNominasMultiplesFrame(ConexionBD conexion) {
        initComponents();
         this.setLocationRelativeTo(null);
        this.conexion = conexion;
        this.isNew = true;

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
        tp_DatosNominas = new javax.swing.JTabbedPane();
        lp_Empleados = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Empleados = new javax.swing.JTable();
        lp_Percepciones = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Percepciones = new javax.swing.JTable();
        lp_Deducciones = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Deducciones = new javax.swing.JTable();
        lp_Resumen = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        cmb_FormaPago = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        dp_FechaPago = new com.github.lgooddatepicker.components.DatePicker();
        cmb_Periodo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btn_Atras = new javax.swing.JButton();
        btn_RealizarOperacion = new javax.swing.JButton();
        lbl_Titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generar Multiples Nominas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 547));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tp_DatosNominas.setBackground(new java.awt.Color(153, 255, 153));
        tp_DatosNominas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tp_DatosNominasPropertyChange(evt);
            }
        });

        tbl_Empleados.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Empleados.setBackground(new java.awt.Color(153, 255, 153));
        jScrollPane3.setViewportView(tbl_Empleados);
        tbl_Empleados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        lp_Empleados.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lp_EmpleadosLayout = new javax.swing.GroupLayout(lp_Empleados);
        lp_Empleados.setLayout(lp_EmpleadosLayout);
        lp_EmpleadosLayout.setHorizontalGroup(
            lp_EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lp_EmpleadosLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        lp_EmpleadosLayout.setVerticalGroup(
            lp_EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lp_EmpleadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        tp_DatosNominas.addTab("Empleados a Pagar", lp_Empleados);

        tbl_Percepciones.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Percepciones.setBackground(new java.awt.Color(153, 255, 153));
        jScrollPane2.setViewportView(tbl_Percepciones);
        tbl_Percepciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        lp_Percepciones.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lp_PercepcionesLayout = new javax.swing.GroupLayout(lp_Percepciones);
        lp_Percepciones.setLayout(lp_PercepcionesLayout);
        lp_PercepcionesLayout.setHorizontalGroup(
            lp_PercepcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lp_PercepcionesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        lp_PercepcionesLayout.setVerticalGroup(
            lp_PercepcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lp_PercepcionesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        tp_DatosNominas.addTab("Percepciones de Nominas", lp_Percepciones);

        tbl_Deducciones.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Deducciones.setBackground(new java.awt.Color(153, 255, 153));
        tbl_Deducciones.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tbl_Deducciones);
        tbl_Deducciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        lp_Deducciones.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lp_DeduccionesLayout = new javax.swing.GroupLayout(lp_Deducciones);
        lp_Deducciones.setLayout(lp_DeduccionesLayout);
        lp_DeduccionesLayout.setHorizontalGroup(
            lp_DeduccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lp_DeduccionesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        lp_DeduccionesLayout.setVerticalGroup(
            lp_DeduccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lp_DeduccionesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        tp_DatosNominas.addTab("Deducciones de Nomina", lp_Deducciones);

        jLabel1.setText("Forma Pago");

        cmb_FormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Forma de Pago" }));

        jLabel2.setText("Fecha Pago");

        dp_FechaPago.setBackground(new java.awt.Color(153, 255, 153));

        cmb_Periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Periodo" }));

        jLabel3.setText("Periodo");

        lp_Resumen.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lp_Resumen.setLayer(cmb_FormaPago, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lp_Resumen.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lp_Resumen.setLayer(dp_FechaPago, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lp_Resumen.setLayer(cmb_Periodo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lp_Resumen.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lp_ResumenLayout = new javax.swing.GroupLayout(lp_Resumen);
        lp_Resumen.setLayout(lp_ResumenLayout);
        lp_ResumenLayout.setHorizontalGroup(
            lp_ResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lp_ResumenLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(lp_ResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addGroup(lp_ResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_FormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dp_FechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(586, Short.MAX_VALUE))
        );
        lp_ResumenLayout.setVerticalGroup(
            lp_ResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lp_ResumenLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(lp_ResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_FormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(lp_ResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dp_FechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(lp_ResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(329, Short.MAX_VALUE))
        );

        tp_DatosNominas.addTab("Pago", lp_Resumen);

        jPanel1.add(tp_DatosNominas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 105, -1, 530));

        btn_Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        btn_Atras.setBorderPainted(false);
        btn_Atras.setContentAreaFilled(false);
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 80));

        btn_RealizarOperacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ope.png"))); // NOI18N
        btn_RealizarOperacion.setBorderPainted(false);
        btn_RealizarOperacion.setContentAreaFilled(false);
        btn_RealizarOperacion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_RealizarOperacionMouseMoved(evt);
            }
        });
        btn_RealizarOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RealizarOperacionActionPerformed(evt);
            }
        });
        jPanel1.add(btn_RealizarOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 640, 190, 80));

        lbl_Titulo.setText("Generar Nominas");
        lbl_Titulo.setFocusable(false);
        lbl_Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        EmpleadoDAO daoEmpleado = new EmpleadoDAO(this.conexion);
        DeduccionDAO daoDeduccion = new DeduccionDAO(this.conexion);
        PercepcionDAO daoPercepcion = new PercepcionDAO(this.conexion);

        empleadosTabla = daoEmpleado.consultaEmpleadosVista();
        deduccionesTabla = daoDeduccion.consultaDeducionesVista();
        percepcionesTabla = daoPercepcion.consultaPercepcionesVista();

        llenarTablaEmpleados(empleadosTabla);
        llenarTablaPercepciones(percepcionesTabla);
        llenarTablaDeducciones(deduccionesTabla);

        FormaPagoDAO daoFormaPago = new FormaPagoDAO(this.conexion);
        PeriodoDAO daoPeriodo = new PeriodoDAO(this.conexion);
        formasPago = daoFormaPago.consultaFormasPagoVista();
        //Crear un filtro para los periodos que no han tenido nomina
        periodos = daoPeriodo.consultaPeriodosVista();

        periodos.forEach((t) -> {
            cmb_Periodo.addItem(t.getNombre());
        });

        formasPago.forEach((t) -> {
            cmb_FormaPago.addItem(t.getNombre());
        });

    }//GEN-LAST:event_formWindowOpened

    private void btn_RealizarOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RealizarOperacionActionPerformed

        for (int i = 0; i < tbl_Empleados.getRowCount(); i++) {
            if ((Boolean) tbl_Empleados.getValueAt(i, 3)) {
                RH_Empleado e = new RH_Empleado(Integer.parseInt(tbl_Empleados.getValueAt(i, 0).toString()), this.conexion);
                empleadosSeleccionados.add(e);
            }
        }
        for (int i = 0; i < tbl_Percepciones.getRowCount(); i++) {
            if ((Boolean) tbl_Percepciones.getValueAt(i, 3)) {
                RH_Percepcion p = new RH_Percepcion(Integer.parseInt(tbl_Percepciones.getValueAt(i, 0).toString()), this.conexion);
                percepcionesSeleccionadas.add(p);
            }
        }
        for (int i = 0; i < tbl_Deducciones.getRowCount(); i++) {
            if ((Boolean) tbl_Deducciones.getValueAt(i, 3)) {
                RH_Deduccion d = new RH_Deduccion(Integer.parseInt(tbl_Deducciones.getValueAt(i, 0).toString()), this.conexion);
                deduccionesSeleccionadas.add(d);
            }
        }
        ArrayList<RH_Nomina> nominas = new ArrayList<>();
        empleadosSeleccionados.forEach((e) -> {
            NominaDAO daoNomina = new NominaDAO(this.conexion);
            RH_Nomina nomina = new RH_Nomina();
            nomina.setFechaElaboracion(Date.valueOf(LocalDate.now()));
            nomina.setFechaPago(Date.valueOf(dp_FechaPago.getDate()));
            nomina.setSubtotal(0.0f);
            nomina.setRetenciones(0.0f);
            nomina.setTotal(0.0f);
            nomina.setDiasTrabajados(0);
            nomina.setEstatus("PENDIENTE");
            nomina.setEmpleado(e);
            nomina.setFormaPago(formasPago.get(cmb_FormaPago.getSelectedIndex() - 1));
            nomina.setPeriodo(periodos.get(cmb_Periodo.getSelectedIndex() - 1));
            /**
             * Insertar nomina y despues recuperar para insertar deducciones y
             * percepciones para despues calcular con un procedimiento
             * almacenado
             *
             */
            if (daoNomina.insertarNomina(nomina)) {
                nomina.setIdNomina(daoNomina.consultaIdGenerado());
                percepcionesSeleccionadas.forEach((p) -> {
                    RH_NominaPercepcion nominaPercepcion = new RH_NominaPercepcion();
                    NominaPercepcionDAO daoNominaPercepcion = new NominaPercepcionDAO(this.conexion);
                    nominaPercepcion.setNomina(nomina);
                    nominaPercepcion.setPercepcion(p);
                    nominaPercepcion.setEstatus("A");
                    nominaPercepcion.calculaImporte();
                    daoNominaPercepcion.insertarNominaPercepcion(nominaPercepcion);
                });
                daoNomina.calculaNominaPercepciones(nomina.getIdNomina(),nomina.getPeriodo().getIdPeriodo());
                nomina.recuperaNomina(conexion);

                deduccionesSeleccionadas.forEach((d) -> {
                    nomina.recuperaNomina(conexion);
                    RH_NominaDeduccion nominaDeduccion = new RH_NominaDeduccion();
                    NominaDeduccionDAO nominaDeduccionDAO = new NominaDeduccionDAO(this.conexion);
                    nominaDeduccion.setNomina(nomina);
                    nominaDeduccion.setDeduccion(d);
                    Float importe;
                    importe = nomina.getSubtotal() * (nominaDeduccion.getDeduccion().getPorcentaje() / 100);
                    nominaDeduccion.setImporte(importe);
                    nominaDeduccion.setEstatus("A");
                    nominaDeduccionDAO.insertarNominaDeduccion(nominaDeduccion);
                });//Fin Deducciones
                daoNomina.calculaNominaDeducciones(nomina.getIdNomina());
                System.out.println("Es todo tigre");

            }//Fin insertar nomina

        });
    }//GEN-LAST:event_btn_RealizarOperacionActionPerformed

    private void btn_RealizarOperacionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RealizarOperacionMouseMoved

    }//GEN-LAST:event_btn_RealizarOperacionMouseMoved

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        NominasFrame nominas = new NominasFrame(this.conexion);
        this.dispose();
        nominas.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void tp_DatosNominasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tp_DatosNominasPropertyChange

    }//GEN-LAST:event_tp_DatosNominasPropertyChange

    private void llenarTablaEmpleados(ArrayList<RH_Empleado> lista) {
        String[] encabezado = {"IdEmpleado", "Nombre Completo", "Puesto", "Seleccionado"};
        Object[][] datos = new Object[lista.size()][4];
        int ren = 0;
        for (RH_Empleado s : lista) {
            datos[ren][0] = s.getIdEmpleado();
            datos[ren][1] = s.getNombreCompleto();
            datos[ren][2] = s.getPuesto().getNombre();
            datos[ren][3] = false;
            ren++;
        }
        DefaultTableModel m = new DefaultTableModel(datos, encabezado) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if (colIndex != 3) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Boolean.class;
                    default:
                        return Boolean.class;
                }
            }

        };
        tbl_Empleados.setModel(m);
    }

    private void llenarTablaPercepciones(ArrayList<RH_Percepcion> lista) {
        String[] encabezado = {"IdPercepcion", "Nombre", "Dias a Pagar", "Seleccionado"};
        Object[][] datos = new Object[lista.size()][4];
        int ren = 0;
        for (RH_Percepcion s : lista) {
            datos[ren][0] = s.getIdPercepcion();
            datos[ren][1] = s.getNombre();
            datos[ren][2] = s.getDiasPagar();
            datos[ren][3] = false;
            ren++;
        }
        DefaultTableModel m = new DefaultTableModel(datos, encabezado) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if (colIndex != 3) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Boolean.class;
                    default:
                        return Boolean.class;
                }
            }

        };
        tbl_Percepciones.setModel(m);
    }

    private void llenarTablaDeducciones(ArrayList<RH_Deduccion> lista) {
        String[] encabezado = {"IdDeduccion", "Nombre", "Porcentanje", "Seleccionado"};
        Object[][] datos = new Object[lista.size()][4];
        int ren = 0;
        for (RH_Deduccion s : lista) {
            datos[ren][0] = s.getIdDeduccion();
            datos[ren][1] = s.getNombre();
            datos[ren][2] = s.getPorcentaje();
            datos[ren][3] = false;
            ren++;
        }
        DefaultTableModel m = new DefaultTableModel(datos, encabezado) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if (colIndex != 3) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Float.class;
                    default:
                        return Boolean.class;
                }
            }

        };
        tbl_Deducciones.setModel(m);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_RealizarOperacion;
    private javax.swing.JComboBox<String> cmb_FormaPago;
    private javax.swing.JComboBox<String> cmb_Periodo;
    private com.github.lgooddatepicker.components.DatePicker dp_FechaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLayeredPane lp_Deducciones;
    private javax.swing.JLayeredPane lp_Empleados;
    private javax.swing.JLayeredPane lp_Percepciones;
    private javax.swing.JLayeredPane lp_Resumen;
    private javax.swing.JTable tbl_Deducciones;
    private javax.swing.JTable tbl_Empleados;
    private javax.swing.JTable tbl_Percepciones;
    private javax.swing.JTabbedPane tp_DatosNominas;
    // End of variables declaration//GEN-END:variables
}
