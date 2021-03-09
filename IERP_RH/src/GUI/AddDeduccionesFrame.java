/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import conexion.ConexionBD;
import conexion.DeduccionesDAO;
import javax.swing.JOptionPane;
import modelo.RH_Deduccion;

/**
 *
 * @author Carlos EsparzadeAnda
 */
public class AddDeduccionesFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddDeduccionesFrame
     */
    ConexionBD conexion;
    RH_Deduccion deduccion;
    Boolean bandera;
    
    public AddDeduccionesFrame(ConexionBD conexion){
        initComponents();
        this.conexion = conexion;
        this.bandera = false;      
    }
    public AddDeduccionesFrame(ConexionBD conexion, RH_Deduccion deduccion) {
        initComponents();
        this.deduccion = deduccion;
        this.conexion = conexion;
        txNombre.setText(this.deduccion.getNombre());
        TxDescripcion.setText(this.deduccion.getDescripcion());
        String h;
        h =String.valueOf(this.deduccion.getPorcentaje());
        jTextField1.setText(h);
        this.bandera = true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        TxDescripcion = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nueva Deducción");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel1.setText("Nueva Deducción");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel3.setText("Descripcion ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel5.setText("Porcentaje");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        txNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNombreActionPerformed(evt);
            }
        });
        txNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNombreKeyReleased(evt);
            }
        });
        jPanel1.add(txNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 140, -1));

        TxDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxDescripcionKeyReleased(evt);
            }
        });
        jPanel1.add(TxDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 140, -1));

        jButton2.setText("Añadir Deducción");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DeduccionesFrame deduccion  = new DeduccionesFrame(this.conexion);
        this.dispose();
        deduccion.setVisible(true);
        deduccion.pack();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        RH_Deduccion nDeduccion = new RH_Deduccion();
        nDeduccion.setNombre(txNombre.getText().toUpperCase());
        nDeduccion.setDescripcion(TxDescripcion.getText().toUpperCase());
        
        nDeduccion.setPorcentaje(Float.parseFloat(jTextField1.getText()));
        DeduccionesDAO deduccionesDAO = new DeduccionesDAO(this.conexion);
        try {
            if (bandera) {
                nDeduccion.setIdDeduccion(this.deduccion.getIdDeduccion());
                if (deduccionesDAO.actualizarDeduccion(nDeduccion)) {
                    JOptionPane.showMessageDialog(null, "Deduccion Modificada con exito");
                    DeduccionesFrame deduccion = new DeduccionesFrame(this.conexion);
                    this.dispose();
                    deduccion.setVisible(true);
                    this.pack();
                }
            } else {
                if (deduccionesDAO.insertarDeduccion(nDeduccion)) {
                    JOptionPane.showMessageDialog(null, "Deduccion Añadida con exito");
                    DeduccionesFrame deduccion = new DeduccionesFrame(this.conexion);
                    this.dispose();
                    deduccion.setVisible(true);
                    this.pack();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        } // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public void verificarCampos() {
        if ("".equals(txNombre.getText()) || "".equals(TxDescripcion.getText())) {
            jButton2.setEnabled(false);
            jLabel6.setText("Debe llenar los campos");
        } else {
            jButton2.setEnabled(true);
            jLabel6.setText("");
        }

    }
    private void txNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNombreActionPerformed

    private void txNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyReleased
    verificarCampos();
    }//GEN-LAST:event_txNombreKeyReleased

    private void TxDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxDescripcionKeyReleased
    verificarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_TxDescripcionKeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxDescripcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txNombre;
    // End of variables declaration//GEN-END:variables
}
