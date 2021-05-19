/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.AsistenciaDAO;
import conexion.ConexionBD;
import conexion.EmpleadoDAO;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.RH_Asistencia;
import modelo.RH_Empleado;

/**
 *
 * @author Marco Chavez
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
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
        txfUsuario = new javax.swing.JTextField();
        txPPassw = new javax.swing.JPasswordField();
        btn_IniciarSesion1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txfUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txfUsuario.setText("MCHAVEZ297@ACCITESZ.COM");
        txfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 260, 50));

        txPPassw.setText("HOLA.123");
        txPPassw.setToolTipText("");
        txPPassw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPPasswActionPerformed(evt);
            }
        });
        jPanel1.add(txPPassw, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 260, 50));

        btn_IniciarSesion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Login/Login.png"))); // NOI18N
        btn_IniciarSesion1.setBorderPainted(false);
        btn_IniciarSesion1.setContentAreaFilled(false);
        btn_IniciarSesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IniciarSesion1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_IniciarSesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 320, 80));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Login/Bienvenido.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 270, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Login/Cuadro.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_IniciarSesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IniciarSesion1ActionPerformed
        if (txfUsuario.getText().isEmpty() || txPPassw.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes informar el usuario y password");
        } else {
            ConexionBD conexion = new ConexionBD("Admin", "Hola.123");
            EmpleadoDAO dao = new EmpleadoDAO(conexion);
            RH_Empleado empleado = new RH_Empleado();
            try {
                empleado = dao.consultaEmpleadoCorreo(txfUsuario.getText().toUpperCase());

            } catch (IOException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (empleado != null & (empleado.getPassword() == null ? txPPassw.getText() == null : empleado.getPassword().equals(txPPassw.getText()))) {
                conexion.setEmpleado(empleado);
                AsistenciaDAO daoAsistencia = new AsistenciaDAO(conexion);
                RH_Asistencia asistencia = daoAsistencia.consultaAsistenciaFecha(java.sql.Date.valueOf(LocalDate.now()), empleado);
                if (Objects.isNull(asistencia.getHoraSalida())) {
                    PrincipalFrame pf = new PrincipalFrame(conexion);
                    this.dispose();
                    pf.setVisible(true);
                    pf.pack();
                }
                else{
                     JOptionPane.showMessageDialog(null, "Ya ha registrado su salida, no puede ingresar al sistema");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Credenciales invalidas");
            }

        }
    }//GEN-LAST:event_btn_IniciarSesion1ActionPerformed

    private void txPPasswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPPasswActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPPasswActionPerformed

    private void txfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_IniciarSesion1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txPPassw;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables
}
