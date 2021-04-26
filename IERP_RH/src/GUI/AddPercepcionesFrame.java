/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Carlos EsparzadeAnda
 */
import conexion.ConexionBD;
import conexion.PercepcionDAO;
import java.awt.HeadlessException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.RH_Percepcion;

public class AddPercepcionesFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddPercepcionesFrame
     */
    ConexionBD conexion;
    RH_Percepcion percepcion;
    Boolean bandera;

    public AddPercepcionesFrame(ConexionBD conexion) {
        initComponents();
        this.conexion = conexion;
        this.bandera = false;
    }

    public AddPercepcionesFrame(ConexionBD conexion, RH_Percepcion deduccion) {
        initComponents();
        jLabel1.setText("Realizar Operación");
        btn_Add.setText("");
        this.percepcion = percepcion;
        this.conexion = conexion;
        txNombre.setText(this.percepcion.getNombre());
        TxDescripcion.setText(this.percepcion.getDescripcion());
        String h;
        h = String.valueOf(this.percepcion.getDiasPagar());
        TxPorcentaje.setText(h);
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        TxDescripcion = new javax.swing.JTextField();
        btn_Add = new javax.swing.JButton();
        TxPorcentaje = new javax.swing.JTextField();
        lbl_MensajePorcentaje = new javax.swing.JLabel();
        lbl_Mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Realizar Operación");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, 20));

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel3.setText("Descripcion ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jLabel5.setText("Dias");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

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
        jPanel1.add(txNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 140, -1));

        TxDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxDescripcionKeyReleased(evt);
            }
        });
        jPanel1.add(TxDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 140, -1));

        btn_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ope.png"))); // NOI18N
        btn_Add.setBorderPainted(false);
        btn_Add.setContentAreaFilled(false);
        btn_Add.setEnabled(false);
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, -1));

        TxPorcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxPorcentajeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxPorcentajeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxPorcentajeKeyTyped(evt);
            }
        });
        jPanel1.add(TxPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 160, -1));
        jPanel1.add(lbl_MensajePorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 150, 20));
        jPanel1.add(lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Percepciones Percepcion = new Percepciones(this.conexion);
        this.dispose();
        Percepcion.setVisible(true);
        Percepcion.pack();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNombreActionPerformed

    private void txNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyReleased
        verificarCampos();
    }//GEN-LAST:event_txNombreKeyReleased

    private void TxDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxDescripcionKeyReleased
        verificarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_TxDescripcionKeyReleased

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        RH_Percepcion nPercepcion = new RH_Percepcion();
        nPercepcion.setNombre(txNombre.getText().toUpperCase());
        nPercepcion.setDescripcion(TxDescripcion.getText().toUpperCase());
        try {
            if (Integer.parseInt(TxPorcentaje.getText()) > 0) {
                nPercepcion.setDiasPagar(Integer.parseInt(TxPorcentaje.getText()));
            } else {
                TxPorcentaje.setText("0");
            }

        } catch (NumberFormatException e) {
            TxPorcentaje.setText("0");
        }

        PercepcionDAO PercepcionDAO = new PercepcionDAO(this.conexion);
        try {
            if (bandera) {
                nPercepcion.setIdPercepcion(this.percepcion.getIdPercepcion());
                if (PercepcionDAO.actualizarPercepcion(nPercepcion)) {
                    JOptionPane.showMessageDialog(null, "Percepcion Modificada con exito");
                    Percepciones percepcion = new Percepciones(this.conexion);
                    this.dispose();
                    percepcion.setVisible(true);
                    this.pack();
                }
            } else {
                if (PercepcionDAO.insertarPercepcion(nPercepcion)) {
                    JOptionPane.showMessageDialog(null, "Percepcion Añadida con exito");
                    Percepciones percepcion = new Percepciones(this.conexion);
                    this.dispose();
                    percepcion.setVisible(true);
                    this.pack();
                }
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        } // TODO add your handling code here:
    }//GEN-LAST:event_btn_AddActionPerformed

    private void TxPorcentajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxPorcentajeKeyPressed

    }//GEN-LAST:event_TxPorcentajeKeyPressed

    private void TxPorcentajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxPorcentajeKeyReleased
        try {
            if (!(Float.parseFloat(TxPorcentaje.getText()) < 100.0f && Float.parseFloat(TxPorcentaje.getText()) > 0)) {
                lbl_MensajePorcentaje.setText("Rango no valido");
                TxPorcentaje.setText("0");
                btn_Add.setEnabled(false);
            } else {
                lbl_MensajePorcentaje.setText("");
                btn_Add.setEnabled(true);
                verificarCampos();
            }
        } catch (NumberFormatException e) {
            lbl_MensajePorcentaje.setText("Rango no valido");
            TxPorcentaje.setText("");
            btn_Add.setEnabled(false);
        }
    }//GEN-LAST:event_TxPorcentajeKeyReleased

    private void TxPorcentajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxPorcentajeKeyTyped

    }//GEN-LAST:event_TxPorcentajeKeyTyped

    /**
     * @param args the command line arguments
     */
    public void verificarCampos() {
        if ("".equals(txNombre.getText()) || "".equals(TxDescripcion.getText()) || "".equals(TxPorcentaje.getText())) {
            btn_Add.setEnabled(false);
            lbl_Mensaje.setText("Debe llenar los campos");
        } else {
            btn_Add.setEnabled(true);
            lbl_Mensaje.setText("");
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxDescripcion;
    private javax.swing.JTextField TxPorcentaje;
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_MensajePorcentaje;
    private javax.swing.JTextField txNombre;
    // End of variables declaration//GEN-END:variables
}
