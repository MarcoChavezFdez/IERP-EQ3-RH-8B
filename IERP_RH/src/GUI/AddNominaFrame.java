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
import conexion.PercepcionDAO;
import conexion.PeriodoDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.RH_Empleado;
import modelo.RH_Deduccion;
import modelo.RH_FormaPago;
import modelo.RH_Percepcion;
import modelo.RH_Periodo;

/**
 *
 * @author Marco Chavez
 */
public class AddNominaFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddEmpleadoFrame
     */
    ConexionBD conexion;
    RH_Empleado empleado;

    ArrayList<RH_FormaPago> formasPago;
    ArrayList<RH_Periodo> periodos;
    ArrayList<RH_Empleado> empleados = new ArrayList<>();
    ArrayList<RH_Percepcion> percepcionesTabla = new ArrayList<>();
    ArrayList<RH_Deduccion> deduccionesTabla = new ArrayList<>();

    EstadoDAO daoEstado;
    Boolean isNew;

    public AddNominaFrame(ConexionBD conexion) {
        initComponents();
         this.setLocationRelativeTo(null);
        this.conexion = conexion;
        this.isNew = true;

    }

    public AddNominaFrame(ConexionBD conexion, RH_Empleado empleado) {

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
        btn_RealizarOperacion = new javax.swing.JButton();
        btn_Atras = new javax.swing.JButton();
        lbl_Titulo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Deducciones = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_Percepciones = new javax.swing.JTable();
        cmb_Empleado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmb_Periodo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmb_FormaPago = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Realizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        btn_RealizarOperacion.setText("Realizar Operacion");
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
        jPanel1.add(btn_RealizarOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 1207, -1, -1));

        btn_Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        btn_Atras.setBorderPainted(false);
        btn_Atras.setContentAreaFilled(false);
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 90));

        lbl_Titulo.setText("Generar Nomina");
        lbl_Titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, -1));

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
        tbl_Deducciones.setEnabled(false);
        jScrollPane3.setViewportView(tbl_Deducciones);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, -1, 120));

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
        tbl_Percepciones.setEnabled(false);
        jScrollPane4.setViewportView(tbl_Percepciones);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, 120));

        cmb_Empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR EMPLEADO" }));
        cmb_Empleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_EmpleadoItemStateChanged(evt);
            }
        });
        jPanel1.add(cmb_Empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 210, -1));

        jLabel4.setText("Empleado");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel5.setText("Periodo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, -1, -1));

        cmb_Periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR PERIODO" }));
        cmb_Periodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_PeriodoItemStateChanged(evt);
            }
        });
        jPanel1.add(cmb_Periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, -1));

        jLabel6.setText("Forma Pago");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, -1, -1));

        cmb_FormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE FORMA DE PAGO" }));
        jPanel1.add(cmb_FormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, -1, -1));

        jTable3.setAutoCreateRowSorter(true);
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "SubTotal", "Retenciones", "Total", "Dias Trabajados", "Estatus"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 540, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Deducciones Nomina");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Resumen Nomina");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Percepciones Nomina");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        btn_Realizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ope.png"))); // NOI18N
        btn_Realizar.setBorderPainted(false);
        btn_Realizar.setContentAreaFilled(false);
        jPanel1.add(btn_Realizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 610, 180, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1170, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        EmpleadoDAO daoEmpleado = new EmpleadoDAO(this.conexion);
        DeduccionDAO daoDeduccion = new DeduccionDAO(this.conexion);
        PercepcionDAO daoPercepcion = new PercepcionDAO(this.conexion);
        FormaPagoDAO daoFormaPago = new FormaPagoDAO(this.conexion);
        PeriodoDAO daoPeriodo = new PeriodoDAO(this.conexion);

        empleados = daoEmpleado.consultaEmpleadosVista();
        deduccionesTabla = daoDeduccion.consultaDeducionesVista();
        percepcionesTabla = daoPercepcion.consultaPercepcionesVista();
        formasPago = daoFormaPago.consultaFormasPagoVista();
        periodos = daoPeriodo.consultaPeriodosVista();

        empleados.forEach((e) -> {
            cmb_Empleado.addItem(e.getNombreCompleto());
        });

        periodos.forEach((t) -> {
            cmb_Periodo.addItem(t.getNombre());
        });

        formasPago.forEach((t) -> {
            cmb_FormaPago.addItem(t.getNombre());
        });

        llenarTablaPercepciones(percepcionesTabla);
        llenarTablaDeducciones(deduccionesTabla);


    }//GEN-LAST:event_formWindowOpened

    private void btn_RealizarOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RealizarOperacionActionPerformed
//        for (int i = 0; i < tbl_Empleados.getRowCount(); i++) {
//            if ((Boolean) tbl_Empleados.getValueAt(i, 3)) {
//                RH_Empleado e = new RH_Empleado(Integer.parseInt(tbl_Empleados.getValueAt(i, 0).toString()), this.conexion);
//                empleados.add(e);
//
//            }
//        }
//        System.out.println("Lista Seleccionados");
//        empleados.forEach((t) -> {
//            System.out.println(t.getNombreCompleto());;
//        });


    }//GEN-LAST:event_btn_RealizarOperacionActionPerformed

    private void btn_RealizarOperacionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RealizarOperacionMouseMoved

    }//GEN-LAST:event_btn_RealizarOperacionMouseMoved

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        NominasFrame nominas = new NominasFrame(this.conexion);
        this.dispose();
        nominas.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void cmb_EmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_EmpleadoItemStateChanged
        if (cmb_Empleado.getSelectedIndex() > 0) {
            tbl_Percepciones.setEnabled(true);
            tbl_Deducciones.setEnabled(true);
        } else {
            tbl_Percepciones.setEnabled(false);
            tbl_Deducciones.setEnabled(false);
        }
    }//GEN-LAST:event_cmb_EmpleadoItemStateChanged

    private void cmb_PeriodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_PeriodoItemStateChanged
       if(cmb_Periodo.getSelectedIndex()>0){
           
       }
    }//GEN-LAST:event_cmb_PeriodoItemStateChanged

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
        String[] encabezado = {"Nombre", "Porcentanje", "Seleccionado"};
        Object[][] datos = new Object[lista.size()][4];
        int ren = 0;
        for (RH_Deduccion s : lista) {
            datos[ren][0] = s.getNombre();
            datos[ren][1] = s.getPorcentaje();
            datos[ren][2] = false;
            ren++;
        }
        DefaultTableModel m = new DefaultTableModel(datos, encabezado) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if (colIndex != 2) {
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
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }

        };
        tbl_Deducciones.setModel(m);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_Realizar;
    private javax.swing.JButton btn_RealizarOperacion;
    private javax.swing.JComboBox<String> cmb_Empleado;
    private javax.swing.JComboBox<String> cmb_FormaPago;
    private javax.swing.JComboBox<String> cmb_Periodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTable tbl_Deducciones;
    private javax.swing.JTable tbl_Percepciones;
    // End of variables declaration//GEN-END:variables
}
