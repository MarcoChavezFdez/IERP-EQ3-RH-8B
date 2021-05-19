/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.ConexionBD;
import conexion.PeriodoDAO;
import java.sql.Date;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.RH_Periodo;

/**
 *
 * @author Mino
 */
public class AddPeriodoFrame extends javax.swing.JFrame {

    ConexionBD conexion;
    RH_Periodo periodo;
    Boolean isNew;

    /**
     * Creates new form AddPuestos
     */
    public AddPeriodoFrame(ConexionBD conexion) {
        initComponents();
        this.conexion = conexion;
        lbl_Titulo.setText("Añadir Periodo");
        btn_Realizar.setText("");
        this.isNew = true;
    }

    public AddPeriodoFrame(ConexionBD conexion, RH_Periodo periodo) {
        initComponents();
        this.periodo = periodo;
        this.conexion = conexion;
        lbl_Titulo.setText("Modificar Periodo");
        btn_Realizar.setText("");
        btn_Realizar.setEnabled(true);
        this.isNew = false;
        txf_Nombre.setText(periodo.getNombre());
        dp_FechaInicio.setDate(periodo.getFechaInicio().toLocalDate());
        dp_FechaFin.setDate(periodo.getFechaFin().toLocalDate());
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
        lbl_Mensaje = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dp_FechaInicio = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dp_FechaFin = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Realizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ope.png"))); // NOI18N
        btn_Realizar.setBorderPainted(false);
        btn_Realizar.setContentAreaFilled(false);
        btn_Realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RealizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Realizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 110));

        lbl_Titulo.setText("Realizar Operación");
        lbl_Titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

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
        jPanel1.add(txf_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 200, -1));
        jPanel1.add(lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 180, 40));

        jLabel3.setText("Fecha Incio");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));
        jPanel1.add(dp_FechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        jLabel4.setText("Periodos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel5.setText("Fecha Fin");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));
        jPanel1.add(dp_FechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        RH_Periodo nPeriodo = new RH_Periodo();
        nPeriodo.setNombre(txf_Nombre.getText());
        nPeriodo.setFechaInicio(Date.valueOf(dp_FechaInicio.getDate()));
        nPeriodo.setFechaFin(Date.valueOf(dp_FechaFin.getDate()));
        nPeriodo.setEstatus("A");
        PeriodoDAO dao = new PeriodoDAO(this.conexion);

        if (isNew) {
            if (dao.insertarPeriodo(nPeriodo)) {
                JOptionPane.showMessageDialog(null, "Periodo añadido con exito");
                PeriodosFrame periodos = new PeriodosFrame(this.conexion);
                this.dispose();
                periodos.setVisible(true);
                this.pack();
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
                PeriodosFrame periodos = new PeriodosFrame(this.conexion);
                this.dispose();
                periodos.setVisible(true);
                this.pack();
            }
        } else {
            nPeriodo.setIdPeriodo(this.periodo.getIdPeriodo());
            if (dao.actualizarPeriodo(nPeriodo)) {
                JOptionPane.showMessageDialog(null, "Periodo Modificado con exito");
                PeriodosFrame periodos = new PeriodosFrame(this.conexion);
                this.dispose();
                periodos.setVisible(true);
                this.pack();
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
                PeriodosFrame periodos = new PeriodosFrame(this.conexion);
                this.dispose();
                periodos.setVisible(true);
                this.pack();
            }
        }

    }//GEN-LAST:event_btn_RealizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PeriodosFrame periodos = new PeriodosFrame(this.conexion);
        this.dispose();
        periodos.setVisible(true);
        periodos.pack();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txf_NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_NombreKeyReleased
        verificaCampos();
    }//GEN-LAST:event_txf_NombreKeyReleased

    private void txf_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_NombreActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        verificaCampos();
    }//GEN-LAST:event_jPanel1MouseMoved

    private void verificaCampos() {
        try {
            if (!"".equals(txf_Nombre.getText()) && (dp_FechaInicio.getDate().isBefore(dp_FechaFin.getDate()) || dp_FechaInicio.getDate().isEqual(dp_FechaFin.getDate())) && (dp_FechaFin.getDate().isBefore(LocalDate.now()) || dp_FechaFin.getDate().isEqual(LocalDate.now()))) {
                btn_Realizar.setEnabled(true);
                lbl_Mensaje.setText("");
            } else {
                btn_Realizar.setEnabled(false);
                lbl_Mensaje.setText("Debe de completar los campos correctamente");
            }
        } catch (NullPointerException ex) {
            btn_Realizar.setEnabled(false);
            lbl_Mensaje.setText("Debe de completar los campos correctamente");
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
            java.util.logging.Logger.getLogger(AddPeriodoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPeriodoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPeriodoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPeriodoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Realizar;
    private com.github.lgooddatepicker.components.DatePicker dp_FechaFin;
    private com.github.lgooddatepicker.components.DatePicker dp_FechaInicio;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTextField txf_Nombre;
    // End of variables declaration//GEN-END:variables
}