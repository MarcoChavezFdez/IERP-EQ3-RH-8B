/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.ConexionBD;
import conexion.EstadoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RH_Estado;

/**
 *
 * @author Marco Chavez
 */
public class EstadosFrame extends javax.swing.JFrame {

    /**
     * Creates new form EstadosFrame
     */
    ConexionBD conexion;
    int paginaActual;
    int paginaMaxima;
    boolean banderaBusqueda = false;

    public EstadosFrame(ConexionBD conexion) {
        initComponents();
         this.setLocationRelativeTo(null);
        this.conexion = conexion;

        EstadoDAO estados = new EstadoDAO(this.conexion);
        this.paginaActual = 1;
        this.paginaMaxima = estados.consultaPaginas();
        lbl_PaginaMaxima.setText(String.valueOf(this.paginaMaxima));
        ArrayList<RH_Estado> lista = estados.consultaEstadosVistaPaginada(paginaActual);
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
        btn_Add = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estado");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnGuardar.png"))); // NOI18N
        btn_Add.setBorderPainted(false);
        btn_Add.setContentAreaFilled(false);
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 170, -1));

        btn_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btn_Modificar.png"))); // NOI18N
        btn_Modificar.setBorderPainted(false);
        btn_Modificar.setContentAreaFilled(false);
        btn_Modificar.setEnabled(false);
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 190, -1));

        tbl_Datos.setBackground(new java.awt.Color(153, 255, 153));
        tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idEstado", "Nombre", "Siglas", "Estatus"
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 440, 340));

        btn_Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        btn_Atras.setBorderPainted(false);
        btn_Atras.setContentAreaFilled(false);
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, -1));

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
        jLabel2.setText("Estado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btn_Eliminar.png"))); // NOI18N
        btn_Eliminar.setBorderPainted(false);
        btn_Eliminar.setContentAreaFilled(false);
        btn_Eliminar.setEnabled(false);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 190, -1));

        btn_Siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/General/Sig.png"))); // NOI18N
        btn_Siguiente.setBorderPainted(false);
        btn_Siguiente.setContentAreaFilled(false);
        btn_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 160, 50));

        btn_Anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/General/Ant.png"))); // NOI18N
        btn_Anterior.setBorderPainted(false);
        btn_Anterior.setContentAreaFilled(false);
        btn_Anterior.setEnabled(false);
        btn_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnteriorActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 150, 50));

        jLabel3.setText("Página");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, -1, -1));

        lbl_PaginaActual.setText("1");
        jPanel1.add(lbl_PaginaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 540, 10, -1));

        jLabel4.setText("de");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, -1, -1));

        lbl_PaginaMaxima.setText("1");
        jPanel1.add(lbl_PaginaMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        AddEstadoFrame addEstado = new AddEstadoFrame(this.conexion);
        this.dispose();
        addEstado.setVisible(true);
        this.pack();

    }//GEN-LAST:event_btn_AddActionPerformed

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
            EstadoDAO estados = new EstadoDAO(this.conexion);
            this.paginaActual = 1;
            ArrayList<RH_Estado> lista = estados.consultaEstadosVistaPaginada(this.paginaActual);
            this.paginaMaxima = estados.consultaPaginas();
            this.lbl_PaginaMaxima.setText(String.valueOf(paginaMaxima));
            this.lbl_PaginaActual.setText(String.valueOf(this.paginaActual));
            llenarTabla(lista);
        } else {
            this.banderaBusqueda = true;
            EstadoDAO estados = new EstadoDAO(this.conexion);
            this.paginaActual = 1;
            ArrayList<RH_Estado> lista = estados.consultaEstadosNombreVistaPaginada(txf_Busqueda.getText(), this.paginaActual);
            this.paginaMaxima = estados.consultaPaginasNombre(txf_Busqueda.getText());
            this.lbl_PaginaMaxima.setText(String.valueOf(paginaMaxima));
            this.lbl_PaginaActual.setText(String.valueOf(this.paginaActual));
            if (paginaMaxima == 0) {
                lbl_PaginaActual.setText("0");
                btn_Siguiente.setEnabled(false);
                btn_Anterior.setEnabled(false);
            } else {
                btn_Anterior.setEnabled(false);
                if (paginaMaxima > 1) {
                    btn_Siguiente.setEnabled(true);
                } else {
                    btn_Siguiente.setEnabled(false);
                }

            }
            llenarTabla(lista);
        }

    }//GEN-LAST:event_txf_BusquedaKeyReleased

    private void tbl_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DatosMouseClicked

    }//GEN-LAST:event_tbl_DatosMouseClicked

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        Integer idEstado = Integer.parseInt(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString());
        EstadoDAO DAO = new EstadoDAO(this.conexion);
        RH_Estado estado = new RH_Estado();
        estado = DAO.consultaEstadoId(idEstado);
        AddEstadoFrame modificarEstado = new AddEstadoFrame(this.conexion, estado);
        this.setVisible(false);
        modificarEstado.setVisible(true);
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void tbl_DatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DatosMousePressed
        btn_Modificar.setEnabled(true);
        btn_Eliminar.setEnabled(true);
    }//GEN-LAST:event_tbl_DatosMousePressed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        Integer idEstado = Integer.parseInt(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString());
        String nombre = tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 1).toString();
        int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el Estado '" + nombre + "'?", "Confirmar Cambio de estatus", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            RH_Estado estado = new RH_Estado();
            EstadoDAO DAO = new EstadoDAO(this.conexion);
            estado = DAO.consultaEstadoId(idEstado);
            if (DAO.eliminacionLogica(estado)) {
                JOptionPane.showMessageDialog(null, "Estado Eliminado");
                EstadoDAO estados = new EstadoDAO(this.conexion);
                this.paginaActual = 1;
                this.paginaMaxima = estados.consultaPaginas();
                lbl_PaginaActual.setText(String.valueOf(this.paginaActual));
                lbl_PaginaMaxima.setText(String.valueOf(this.paginaMaxima));
                ArrayList<RH_Estado> lista = estados.consultaEstadosVistaPaginada(paginaActual);
                llenarTabla(lista);
                txf_Busqueda.setText("");
                banderaBusqueda = false;
                btn_Anterior.setEnabled(false);
                if ((paginaActual + 1) <= paginaMaxima) {
                    btn_Siguiente.setEnabled(true);
                }
                else{
                    btn_Siguiente.setEnabled(false);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }

        }
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
            EstadoDAO DAO = new EstadoDAO(this.conexion);
            ArrayList<RH_Estado> lista = new ArrayList<>();
            if (this.banderaBusqueda) {
                lista = DAO.consultaEstadosNombreVistaPaginada(txf_Busqueda.getText(), paginaActual);
            } else {
                lista = DAO.consultaEstadosVistaPaginada(paginaActual);
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
            EstadoDAO DAO = new EstadoDAO(this.conexion);
            ArrayList<RH_Estado> lista = new ArrayList<>();
            if (this.banderaBusqueda) {
                lista = DAO.consultaEstadosNombreVistaPaginada(txf_Busqueda.getText(), paginaActual);
            } else {
                lista = DAO.consultaEstadosVistaPaginada(paginaActual);
            }

            llenarTabla(lista);
        }
    }//GEN-LAST:event_btn_AnteriorActionPerformed

    private void llenarTabla(ArrayList<RH_Estado> lista) {
        String[] encabezado = {"IdEstado", "Nombre", "Siglas"};
        Object[][] datos = new Object[lista.size()][3];
        int ren = 0;
        for (RH_Estado s : lista) {
            datos[ren][0] = s.getIdEstado();
            datos[ren][1] = s.getNombre();
            datos[ren][2] = s.getSiglas();
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
    private javax.swing.JButton btn_Add;
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
