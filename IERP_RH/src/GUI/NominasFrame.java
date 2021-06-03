/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.ConexionBD;
import conexion.NominaDAO;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RH_Nomina;

/**
 *
 * @author Marco Chavez
 */
public class NominasFrame extends javax.swing.JFrame {

    /**
     * Creates new form EstadosFrame
     */
    ConexionBD conexion;
    int paginaActual;
    int paginaMaxima;
    boolean banderaBusqueda = false;

    public NominasFrame(ConexionBD conexion) {
        initComponents();
         this.setLocationRelativeTo(null);
        this.conexion = conexion;

        NominaDAO nomina = new NominaDAO(this.conexion);
        this.paginaActual = 1;
        this.paginaMaxima = nomina.consultaPaginas();
        lbl_PaginaMaxima.setText(String.valueOf(this.paginaMaxima));
        ArrayList<RH_Nomina> lista = nomina.consultaNominasVistaPaginada(paginaActual);
        llenarTabla(lista);
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
        btn_Modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Datos = new javax.swing.JTable();
        btn_Atras = new javax.swing.JButton();
        txf_Busqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Eliminar = new javax.swing.JButton();
        btn_Siguiente = new javax.swing.JButton();
        btn_Anterior = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_PaginaActual = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_PaginaMaxima = new javax.swing.JLabel();
        btn_AgregarMultiples = new javax.swing.JButton();
        btn_Agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estado");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btn_Modificar.png"))); // NOI18N
        btn_Modificar.setBorderPainted(false);
        btn_Modificar.setContentAreaFilled(false);
        btn_Modificar.setEnabled(false);
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 190, -1));

        tbl_Datos.setBackground(new java.awt.Color(153, 255, 153));
        tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IdNomina", "Fecha Elaboracion", "Fecha Pago", "Total", "Dias Trabajados", "Estatus", "Empleado", "Forma Pago", "Periodo"
            }
        ));
        tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DatosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_DatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Datos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 870, 340));

        btn_Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        btn_Atras.setBorderPainted(false);
        btn_Atras.setContentAreaFilled(false);
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, -1));

        txf_Busqueda.setBackground(new java.awt.Color(153, 255, 153));
        txf_Busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_BusquedaActionPerformed(evt);
            }
        });
        txf_Busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txf_BusquedaKeyReleased(evt);
            }
        });
        jPanel1.add(txf_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 254, -1));

        jLabel1.setText("Busqueda por nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Nominas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btn_Eliminar.png"))); // NOI18N
        btn_Eliminar.setBorderPainted(false);
        btn_Eliminar.setContentAreaFilled(false);
        btn_Eliminar.setEnabled(false);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 190, -1));

        btn_Siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/General/Sig.png"))); // NOI18N
        btn_Siguiente.setBorderPainted(false);
        btn_Siguiente.setContentAreaFilled(false);
        btn_Siguiente.setDefaultCapable(false);
        btn_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, 150, 40));

        btn_Anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/General/Ant.png"))); // NOI18N
        btn_Anterior.setBorderPainted(false);
        btn_Anterior.setContentAreaFilled(false);
        btn_Anterior.setDefaultCapable(false);
        btn_Anterior.setEnabled(false);
        btn_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnteriorActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 150, 40));

        jLabel3.setText("Página");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, -1, -1));

        lbl_PaginaActual.setText("1");
        jPanel1.add(lbl_PaginaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 540, 10, -1));

        jLabel4.setText("de");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, -1, -1));

        lbl_PaginaMaxima.setText("1");
        jPanel1.add(lbl_PaginaMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, -1, -1));

        btn_AgregarMultiples.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Nominas/GMN.png"))); // NOI18N
        btn_AgregarMultiples.setBorderPainted(false);
        btn_AgregarMultiples.setContentAreaFilled(false);
        btn_AgregarMultiples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarMultiplesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_AgregarMultiples, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 210, 90));

        btn_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Nominas/GN.png"))); // NOI18N
        btn_Agregar.setBorderPainted(false);
        btn_Agregar.setContentAreaFilled(false);
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 210, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        PrincipalFrame pf = new PrincipalFrame(this.conexion);
        this.dispose();
        pf.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void txf_BusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_BusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_BusquedaActionPerformed

    private void txf_BusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_BusquedaKeyReleased
        if ("".equals(txf_Busqueda.getText())) {
            this.banderaBusqueda = false;
            this.btn_Anterior.setEnabled(false);
            this.btn_Siguiente.setEnabled(true);
            NominaDAO nominas = new NominaDAO(this.conexion);
            this.paginaActual = 1;
            ArrayList<RH_Nomina> lista = nominas.consultaNominasVistaPaginada(this.paginaActual);
            this.paginaMaxima = nominas.consultaPaginas();
            this.lbl_PaginaMaxima.setText(String.valueOf(paginaMaxima));
            this.lbl_PaginaActual.setText(String.valueOf(this.paginaActual));
            llenarTabla(lista);
        } else {
            //Para busqueda
//            this.banderaBusqueda = true;
//            EstadoDAO estados = new EstadoDAO(this.conexion);
//            this.paginaActual = 1;
//            ArrayList<RH_Estado> lista = estados.consultaEstadosNombreVistaPaginada(txf_Busqueda.getText(), this.paginaActual);
//            this.paginaMaxima = estados.consultaPaginasNombre(txf_Busqueda.getText());
//            this.lbl_PaginaMaxima.setText(String.valueOf(paginaMaxima));
//            this.lbl_PaginaActual.setText(String.valueOf(this.paginaActual));
//            if (paginaMaxima == 0) {
//                lbl_PaginaActual.setText("0");
//                btn_Siguiente.setEnabled(false);
//                btn_Anterior.setEnabled(false);
//            } else {
//                btn_Anterior.setEnabled(false);
//                if (paginaMaxima > 1) {
//                    btn_Siguiente.setEnabled(true);
//                } else {
//                    btn_Siguiente.setEnabled(false);
//                }
//
//            }
//            llenarTabla(lista);
        }

    }//GEN-LAST:event_txf_BusquedaKeyReleased

    private void tbl_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DatosMouseClicked

    }//GEN-LAST:event_tbl_DatosMouseClicked

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        Integer idEstado = Integer.parseInt(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString());
        NominaDAO nomina = new NominaDAO(this.conexion);
        RH_Nomina estado = new RH_Nomina();
//        estado = nomina.consultaEstadoId(idEstado);
//        AddEstadoFrame modificarEstado = new AddEstadoFrame(this.conexion, estado);
//        this.setVisible(false);
//        modificarEstado.setVisible(true);
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void tbl_DatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DatosMousePressed
        btn_Modificar.setEnabled(true);
        btn_Eliminar.setEnabled(true);
    }//GEN-LAST:event_tbl_DatosMousePressed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
//        Integer idEstado = Integer.parseInt(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString());
//        String nombre = tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 1).toString();
//        int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el Estado '" + nombre + "'?", "Confirmar Cambio de estatus", JOptionPane.YES_NO_OPTION);
//        if (reply == JOptionPane.YES_OPTION) {
//            RH_Estado estado = new RH_Estado();
//            EstadoDAO DAO = new EstadoDAO(this.conexion);
//            estado = DAO.consultaEstadoId(idEstado);
//            if (DAO.eliminacionLogica(estado)) {
//                JOptionPane.showMessageDialog(null, "Estado Eliminado");
//                EstadoDAO estados = new EstadoDAO(this.conexion);
//                this.paginaActual = 1;
//                this.paginaMaxima = estados.consultaPaginas();
//                lbl_PaginaActual.setText(String.valueOf(this.paginaActual));
//                lbl_PaginaMaxima.setText(String.valueOf(this.paginaMaxima));
//                ArrayList<RH_Estado> lista = estados.consultaEstadosVistaPaginada(paginaActual);
//                llenarTabla(lista);
//                txf_Busqueda.setText("");
//                banderaBusqueda = false;
//                btn_Anterior.setEnabled(false);
//                if ((paginaActual + 1) <= paginaMaxima) {
//                    btn_Siguiente.setEnabled(true);
//                } else {
//                    btn_Siguiente.setEnabled(false);
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
//            }
//
//        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiguienteActionPerformed
        if ((paginaActual + 1) <= paginaMaxima) {
            btn_Anterior.setEnabled(true);
            paginaActual++;
            if (paginaActual == paginaMaxima) {
                this.btn_Siguiente.setEnabled(false);
            } else {
                this.btn_Siguiente.setEnabled(true);
            }
            this.lbl_PaginaActual.setText(String.valueOf(paginaActual));
            NominaDAO DAO = new NominaDAO(this.conexion);
            ArrayList<RH_Nomina> lista = new ArrayList<>();
            if (this.banderaBusqueda) {
//                lista = DAO.consultaEstadosNombreVistaPaginada(txf_Busqueda.getText(), paginaActual);
            } else {
                lista = DAO.consultaNominasVistaPaginada(paginaActual);
            }

            llenarTabla(lista);
        }
    }//GEN-LAST:event_btn_SiguienteActionPerformed

    private void btn_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnteriorActionPerformed
        if ((paginaActual - 1) >= 1) {
            btn_Siguiente.setEnabled(true);
            paginaActual--;
            if (paginaActual == 1) {
                this.btn_Anterior.setEnabled(false);
            } else {
                this.btn_Anterior.setEnabled(true);
            }
            this.lbl_PaginaActual.setText(String.valueOf(paginaActual));
            NominaDAO DAO = new NominaDAO(this.conexion);
            ArrayList<RH_Nomina> lista = new ArrayList<>();
            if (this.banderaBusqueda) {
//                lista = DAO.consultaEstadosNominaVistaPaginada(txf_Busqueda.getText(), paginaActual);
            } else {
                lista = DAO.consultaNominasVistaPaginada(paginaActual);
            }

            llenarTabla(lista);
        }
    }//GEN-LAST:event_btn_AnteriorActionPerformed

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        AddNominaFrame addNomina = new AddNominaFrame(this.conexion);
        this.dispose();
        addNomina.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_AgregarMultiplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarMultiplesActionPerformed
       AddNominasMultiplesFrame addNominas = new AddNominasMultiplesFrame(this.conexion);
       this.dispose();
       addNominas.setVisible(true);
       this.pack();
       
    }//GEN-LAST:event_btn_AgregarMultiplesActionPerformed

    private void llenarTabla(ArrayList<RH_Nomina> lista) {
        String[] encabezado = {"IdNomina", "Fecha Elaboracion", "Fecha Pago", "Total", "Dias Trabajados", "Estatus", "Empleado", "Forma Pago", "Periodo"};
        Object[][] datos = new Object[lista.size()][9];
        int ren = 0;
        for (RH_Nomina s : lista) {
            datos[ren][0] = s.getIdNomina();
            datos[ren][1] = s.getFechaElaboracion();
            datos[ren][2] = s.getFechaPago();
            datos[ren][3] = s.getTotal();
            datos[ren][4] = s.getDiasTrabajados();
            datos[ren][5] = s.getEstatus();
            datos[ren][6] = s.getEmpleado().getNombreCompleto();
            datos[ren][7] = s.getFormaPago().getNombre();
            datos[ren][8] = s.getPeriodo().getNombre();
            ren++;
        }
        DefaultTableModel m = new DefaultTableModel(datos, encabezado) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };
        tbl_Datos.setModel(m);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_AgregarMultiples;
    private javax.swing.JButton btn_Anterior;
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Siguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_PaginaActual;
    private javax.swing.JLabel lbl_PaginaMaxima;
    private javax.swing.JTable tbl_Datos;
    private javax.swing.JTextField txf_Busqueda;
    // End of variables declaration//GEN-END:variables
}
