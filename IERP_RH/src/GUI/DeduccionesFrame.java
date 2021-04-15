/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.CiudadDAO;
import conexion.ConexionBD;
import conexion.DeduccionesDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RH_Ciudad;
import modelo.RH_Deduccion;

/**
 *
 * @author Carlos Esparza
 */
public class DeduccionesFrame extends javax.swing.JFrame {

    /**
     * Creates new form DeduccionesFrame
     */
    ConexionBD conexion;

    public DeduccionesFrame(ConexionBD conexion) {
        this.conexion = conexion;
        initComponents();
        DeduccionesDAO deduccion = new DeduccionesDAO(this.conexion);
        ArrayList<RH_Deduccion> lista = deduccion.consultaDeducciones();
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
        btn_Atras = new javax.swing.JButton();
        txf_Busqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_Add = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Datos = new javax.swing.JTable();
        btn_Eliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Deducciones");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        btn_Atras.setBorderPainted(false);
        btn_Atras.setContentAreaFilled(false);
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

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
        jPanel1.add(txf_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 205, -1));

        jLabel1.setText("Busqueda por nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        btn_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnGuardar.png"))); // NOI18N
        btn_Add.setBorderPainted(false);
        btn_Add.setContentAreaFilled(false);
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 180, -1));

        btn_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btn_Modificar.png"))); // NOI18N
        btn_Modificar.setBorderPainted(false);
        btn_Modificar.setContentAreaFilled(false);
        btn_Modificar.setEnabled(false);
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 180, -1));

        tbl_Datos.setBackground(new java.awt.Color(153, 255, 153));
        tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IdDeducciones", "Nombre", "Descripcion", "Porcentaje"
            }
        ));
        tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_DatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Datos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 380, 360));

        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btn_Eliminar.png"))); // NOI18N
        btn_Eliminar.setToolTipText("");
        btn_Eliminar.setBorderPainted(false);
        btn_Eliminar.setContentAreaFilled(false);
        btn_Eliminar.setEnabled(false);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 170, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Deducciones");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 560));

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

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        AddDeduccionesFrame addDeduccion = new AddDeduccionesFrame(this.conexion);
        this.dispose();
        addDeduccion.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_AddActionPerformed

    private void txf_BusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_BusquedaKeyReleased
        DeduccionesDAO deduccion = new DeduccionesDAO(this.conexion);
        ArrayList<RH_Deduccion> lista = deduccion.consultaDeduccionesNombre(txf_Busqueda.getText());
        llenarTabla(lista);
    }//GEN-LAST:event_txf_BusquedaKeyReleased

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        Integer idDeduccion = Integer.parseInt(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString());
        String nombre = tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString();
        int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea ELIMINAR la Deduccion " + nombre, "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
        DeduccionesDAO DAO = new DeduccionesDAO(this.conexion);
        RH_Deduccion deduccion = new RH_Deduccion();
        if (reply == JOptionPane.YES_OPTION) {
            if (DAO.eliminacionLogicaDeduccion(idDeduccion)) {
                JOptionPane.showMessageDialog(null, "Deduccion Eliminada");
                DeduccionesDAO deducciones = new DeduccionesDAO(this.conexion);
                ArrayList<RH_Deduccion> lista = deducciones.consultaDeducciones();
                llenarTabla(lista);

            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        Integer idDeduccion = Integer.parseInt(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString());
        DeduccionesDAO DAO = new DeduccionesDAO(this.conexion);
        RH_Deduccion deduccion = new RH_Deduccion();
        deduccion = DAO.consultaDeduccionId(idDeduccion);
        AddDeduccionesFrame modificarDeduccion = new AddDeduccionesFrame(this.conexion, deduccion);
        this.setVisible(false);
        modificarDeduccion.setVisible(true);
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void tbl_DatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DatosMousePressed
        btn_Modificar.setEnabled(true);
        btn_Eliminar.setEnabled(true);

    }//GEN-LAST:event_tbl_DatosMousePressed

    private void llenarTabla(ArrayList<RH_Deduccion> lista) {
        String[] encabezado = {"IdDeduccion", "Nombre", "Descripcion", "Porcentaje"};
        Object[][] datos = new Object[lista.size()][4];
        int ren = 0;
        for (RH_Deduccion s : lista) {
            datos[ren][0] = s.getIdDeduccion();
            datos[ren][1] = s.getNombre();
            datos[ren][2] = s.getDescripcion();
            datos[ren][3] = s.getPorcentaje();
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
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Datos;
    private javax.swing.JTextField txf_Busqueda;
    // End of variables declaration//GEN-END:variables
}
