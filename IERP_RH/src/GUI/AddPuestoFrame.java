/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import conexion.ConexionBD;
import conexion.PuestoDAO;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import modelo.RH_Puesto;
/**
 *
 * @author Mino
 */
public class AddPuestoFrame extends javax.swing.JFrame {
 ConexionBD conexion;
    RH_Puesto puesto;
    Boolean bandera;
    /**
     * Creates new form AddPuestos
     */
    public AddPuestoFrame(ConexionBD conexion) {
        initComponents();
        this.conexion = conexion;
        lbl_Titulo.setText("Realizar Operación");
        btn_Realizar.setText("");
        this.bandera = false;
    }
public AddPuestoFrame(ConexionBD conexion, RH_Puesto puesto) {
        initComponents();
        this.puesto = puesto;
        this.conexion = conexion;
        lbl_Titulo.setText("Realizar Operación");
        btn_Realizar.setText("");
        btn_Realizar.setEnabled(true);
        txf_Nombre.setText(this.puesto.getNombre());
        spSalMin.setValue(this.puesto.getSalarioMinimo());
        spSalMax.setValue(this.puesto.getSalarioMaximo());
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

        jPanel1 = new javax.swing.JPanel();
        btn_Realizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbl_Titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txf_Nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbl_Mensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        spSalMin = new javax.swing.JSpinner();
        spSalMax = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Realizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ope.png"))); // NOI18N
        btn_Realizar.setBorderPainted(false);
        btn_Realizar.setContentAreaFilled(false);
        btn_Realizar.setEnabled(false);
        btn_Realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RealizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Realizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 110));

        lbl_Titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_Titulo.setText("Realizar Operación");
        jPanel1.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        txf_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_NombreActionPerformed(evt);
            }
        });
        txf_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txf_NombreKeyReleased(evt);
            }
        });
        jPanel1.add(txf_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 111, -1));

        jLabel3.setText("Salario Minimo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 80, -1));
        jPanel1.add(lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 180, 40));

        jLabel1.setText("Salario Maximo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        spSalMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spSalMinMouseClicked(evt);
            }
        });
        spSalMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spSalMinKeyReleased(evt);
            }
        });
        jPanel1.add(spSalMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 110, -1));

        spSalMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spSalMaxKeyReleased(evt);
            }
        });
        jPanel1.add(spSalMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RealizarActionPerformed
         int valueMin= (Integer) spSalMin.getValue();
    int valueMax= (Integer) spSalMax.getValue();
        if (valueMin<0 || valueMax<0) {
            JOptionPane.showMessageDialog(null, "Los valores introducidos no son validos");
        } else if (valueMin>=0 || valueMax>=0){
        RH_Puesto nPuesto = new RH_Puesto();
        nPuesto.setNombre(txf_Nombre.getText().toUpperCase());
        nPuesto.setSalarioMinimo(Float.parseFloat(spSalMin.getValue().toString()));
        nPuesto.setSalarioMaximo(Float.parseFloat(spSalMax.getValue().toString()));
        nPuesto.setEstatus("A");
        PuestoDAO puestoDAO = new PuestoDAO(this.conexion);
        try {
            if (bandera) {
                nPuesto.setIdPuesto(this.puesto.getIdPuesto());
                if (puestoDAO.actualizarPuesto(nPuesto)) {
                    JOptionPane.showMessageDialog(null, "Puesto Modificado con exito");
                    PuestosFrame puestos = new PuestosFrame(this.conexion);
                    this.dispose();
                    puestos.setVisible(true);
                    this.pack();
                }
            } else {
                if (puestoDAO.insertarPuesto(nPuesto)) {
                    JOptionPane.showMessageDialog(null, "Puesto Añadido con exito");
                    PuestosFrame puestos = new PuestosFrame(this.conexion);
                    this.dispose();
                    puestos.setVisible(true);
                    this.pack();
                }
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        }
    }//GEN-LAST:event_btn_RealizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PuestosFrame puestos = new PuestosFrame(this.conexion);
        this.dispose();
        puestos.setVisible(true);
        puestos.pack();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txf_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_NombreActionPerformed

    private void txf_NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_NombreKeyReleased
        verificarCampos();
    }//GEN-LAST:event_txf_NombreKeyReleased

    private void spSalMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spSalMinKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_spSalMinKeyReleased

    private void spSalMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spSalMaxKeyReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_spSalMaxKeyReleased

    private void spSalMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spSalMinMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_spSalMinMouseClicked
public void verificarCampos() {
 
        if ("".equals(txf_Nombre.getText())) {
            btn_Realizar.setEnabled(false);
            lbl_Mensaje.setText("Debe llenar los campos");
        } else {
            btn_Realizar.setEnabled(true);
            lbl_Mensaje.setText("");
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddPuestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPuestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPuestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPuestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Realizar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JSpinner spSalMax;
    private javax.swing.JSpinner spSalMin;
    private javax.swing.JTextField txf_Nombre;
    // End of variables declaration//GEN-END:variables
}
