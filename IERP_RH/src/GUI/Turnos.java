/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author selen
 */
public class Turnos extends javax.swing.JFrame {

    /**
     * Creates new form Turnos
     */
    public Turnos() {
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTurnos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtidTurno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txthoraInicio = new javax.swing.JTextField();
        txthoraFin = new javax.swing.JTextField();
        rbLunes = new javax.swing.JRadioButton();
        rbMartes = new javax.swing.JRadioButton();
        rbMiercoles = new javax.swing.JRadioButton();
        rbJueves = new javax.swing.JRadioButton();
        rbViernes = new javax.swing.JRadioButton();
        rbSabado = new javax.swing.JRadioButton();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        rbDomingo = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        etiqueta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Turnos");
        setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, 340));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/material/Turnos.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 270, 110));

        tblTurnos.setBackground(new java.awt.Color(153, 255, 255));
        tblTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Fecha Inicio", "Fecha Fin", "Dias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTurnos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 423, 394));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 31, 22));

        txtidTurno.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.add(txtidTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 64, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 80, -1));

        txtnombre.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 111, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha Inicio:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Fin:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Días:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, -1));

        txthoraInicio.setBackground(new java.awt.Color(153, 255, 255));
        txthoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoraInicioActionPerformed(evt);
            }
        });
        jPanel2.add(txthoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 94, -1));

        txthoraFin.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.add(txthoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 97, -1));

        rbLunes.setBackground(new java.awt.Color(0, 0, 0));
        rbLunes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbLunes.setForeground(new java.awt.Color(255, 255, 255));
        rbLunes.setText("Lunes");
        jPanel2.add(rbLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, -1, -1));

        rbMartes.setBackground(new java.awt.Color(0, 0, 0));
        rbMartes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbMartes.setForeground(new java.awt.Color(255, 255, 255));
        rbMartes.setText("Martes");
        jPanel2.add(rbMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, -1, -1));

        rbMiercoles.setBackground(new java.awt.Color(0, 0, 0));
        rbMiercoles.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbMiercoles.setForeground(new java.awt.Color(255, 255, 255));
        rbMiercoles.setText("Miercoles");
        jPanel2.add(rbMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, -1, -1));

        rbJueves.setBackground(new java.awt.Color(0, 0, 0));
        rbJueves.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbJueves.setForeground(new java.awt.Color(255, 255, 255));
        rbJueves.setText("Jueves");
        rbJueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJuevesActionPerformed(evt);
            }
        });
        jPanel2.add(rbJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, -1, -1));

        rbViernes.setBackground(new java.awt.Color(0, 0, 0));
        rbViernes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbViernes.setForeground(new java.awt.Color(255, 255, 255));
        rbViernes.setText("Viernes");
        rbViernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbViernesActionPerformed(evt);
            }
        });
        jPanel2.add(rbViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, -1, -1));

        rbSabado.setBackground(new java.awt.Color(0, 0, 0));
        rbSabado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbSabado.setForeground(new java.awt.Color(255, 255, 255));
        rbSabado.setText("Sabado");
        jPanel2.add(rbSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, -1, -1));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/material/Save.png"))); // NOI18N
        btnguardar.setBorderPainted(false);
        btnguardar.setContentAreaFilled(false);
        btnguardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnguardarMouseEntered(evt);
            }
        });
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 90, 80));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/material/Modify.png"))); // NOI18N
        btnmodificar.setBorderPainted(false);
        btnmodificar.setContentAreaFilled(false);
        jPanel2.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 90, -1));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/material/Trash.png"))); // NOI18N
        btneliminar.setBorderPainted(false);
        btneliminar.setContentAreaFilled(false);
        jPanel2.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 90, -1));

        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/material/Clean.png"))); // NOI18N
        btnlimpiar.setBorderPainted(false);
        btnlimpiar.setContentAreaFilled(false);
        jPanel2.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 90, -1));

        rbDomingo.setBackground(new java.awt.Color(0, 0, 0));
        rbDomingo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbDomingo.setForeground(new java.awt.Color(255, 255, 255));
        rbDomingo.setText("Domingo");
        jPanel2.add(rbDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/material/fondo1.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, -60, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/material/fondo1.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, -60, -1, -1));

        etiqueta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        etiqueta.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta.setText("Prueba");
        jPanel2.add(etiqueta, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        int idTurno = Integer .parseInt(txtidTurno.getText());
        String nombre = txtnombre.getText();
        int horaInicio = Integer .parseInt(txthoraInicio.getText());
        int horaFin = Integer .parseInt(txthoraFin.getText());
        String dias = null;
        if (rbLunes.isSelected()== true){
            dias = "Lunes";

        }if (rbMartes.isSelected()== true){
            dias="Martes";
        }
        if (rbMiercoles.isSelected()== true){
            dias="Miercoles";
        }
        if (rbJueves.isSelected()== true){
            dias="Jueves";
        }
        if (rbViernes.isSelected()== true){
            dias="Viernes";
        }
        if (rbSabado.isSelected()== true){
            dias="Sabado";
        }
        if (rbDomingo.isSelected()== true){
            dias="Domingo";
        }
        try{
            Connection con = ConexionBD.GetConexion();
            PreparedStatement ps =con.prepareStatement("INSERT INTO Turnos(idTurno,nombre,horaInicio,horaFin,dias) VALUES (?,?,?,?,?)");
            ps.setInt(1, idTurno);
            ps.setString(2, nombre);
            ps.setInt(3, horaInicio);
            ps.setInt(4,horaFin);
            ps.setString(5,dias);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Turnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void rbJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJuevesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbJuevesActionPerformed

    private void txthoraInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoraInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoraInicioActionPerformed

    private void rbViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbViernesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbViernesActionPerformed

    private void btnguardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarMouseEntered
       etiqueta.setText("Guardar");
    }//GEN-LAST:event_btnguardarMouseEntered

    private void cargarTabla(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tblTurnos.getModel();
        modeloTabla.setRowCount(0);
        
        
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
            java.util.logging.Logger.getLogger(Turnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Turnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Turnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Turnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Turnos().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JLabel etiqueta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbDomingo;
    private javax.swing.JRadioButton rbJueves;
    private javax.swing.JRadioButton rbLunes;
    private javax.swing.JRadioButton rbMartes;
    private javax.swing.JRadioButton rbMiercoles;
    private javax.swing.JRadioButton rbSabado;
    private javax.swing.JRadioButton rbViernes;
    private javax.swing.JTable tblTurnos;
    private javax.swing.JTextField txthoraFin;
    private javax.swing.JTextField txthoraInicio;
    private javax.swing.JTextField txtidTurno;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
