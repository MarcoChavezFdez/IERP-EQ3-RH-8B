/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.CiudadDAO;
import conexion.ConexionBD;
import conexion.EstadoDAO;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.RH_Ciudad;
import modelo.RH_Estado;

/**
 *
 * @author Marco Chavez
 */
public class AddCiudadFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddCiudadFrame
     */
    ConexionBD conexion;
    Boolean isNewCiudad;
    RH_Ciudad nCiudad;

    public AddCiudadFrame(ConexionBD conexion) {
        initComponents();
        this.conexion = conexion;
        isNewCiudad = true;
        EstadoDAO estadosDAO = new EstadoDAO(this.conexion);
        ArrayList<RH_Estado> estados = new ArrayList<>();
        estados = estadosDAO.consultaEstados();
        for (RH_Estado s : estados) {
            cmb_Estado.addItem(s.getNombre());

        }

    }

    public AddCiudadFrame(ConexionBD conexion, RH_Ciudad ciudad) {
        initComponents();
        this.conexion = conexion;
        lbl_Operacion.setText("Realizar Operación");
        btn_AddCiudad.setText("");
        txf_Nombre.setText(ciudad.getNombre());
        isNewCiudad = false;
        EstadoDAO estadosDAO = new EstadoDAO(this.conexion);
        ArrayList<RH_Estado> estados = new ArrayList<>();
        estados = estadosDAO.consultaEstados();
        nCiudad = ciudad;
        int cont = 1;
        for (RH_Estado s : estados) {
            cmb_Estado.addItem(s.getNombre());
            if (s.getNombre() == null ? nCiudad.getNombreEstado() == null : s.getNombre().equals(nCiudad.getNombreEstado())) {
                cmb_Estado.setSelectedIndex(cont);
            } else {
                cont++;
            }
        }

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
        lbl_Operacion = new javax.swing.JLabel();
        btn_Atras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txf_Nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmb_Estado = new javax.swing.JComboBox<>();
        btn_AddCiudad = new javax.swing.JButton();
        lbl_Mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Operacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_Operacion.setText("Realizar Operación");
        jPanel1.add(lbl_Operacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        btn_Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        btn_Atras.setBorderPainted(false);
        btn_Atras.setContentAreaFilled(false);
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

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
        jPanel1.add(txf_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 158, -1));

        jLabel3.setText("Estado");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        cmb_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Estado" }));
        cmb_Estado.setToolTipText("");
        cmb_Estado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_EstadoItemStateChanged(evt);
            }
        });
        cmb_Estado.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmb_EstadoPropertyChange(evt);
            }
        });
        jPanel1.add(cmb_Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 158, -1));

        btn_AddCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ope.png"))); // NOI18N
        btn_AddCiudad.setToolTipText("");
        btn_AddCiudad.setBorderPainted(false);
        btn_AddCiudad.setContentAreaFilled(false);
        btn_AddCiudad.setEnabled(false);
        btn_AddCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(btn_AddCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));
        jPanel1.add(lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 151, 21));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txf_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_NombreActionPerformed

    }//GEN-LAST:event_txf_NombreActionPerformed

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        CiudadesFrame ciudades = new CiudadesFrame(this.conexion);
        this.dispose();
        ciudades.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void txf_NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_NombreKeyReleased
        verificarCampos();
    }//GEN-LAST:event_txf_NombreKeyReleased

    private void cmb_EstadoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmb_EstadoPropertyChange

    }//GEN-LAST:event_cmb_EstadoPropertyChange

    private void cmb_EstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_EstadoItemStateChanged
        verificarCampos();
    }//GEN-LAST:event_cmb_EstadoItemStateChanged

    private void btn_AddCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddCiudadActionPerformed
        if (isNewCiudad) {
            nCiudad = new RH_Ciudad();
            EstadoDAO estadoDAO = new EstadoDAO(this.conexion);
            RH_Estado estado = new RH_Estado();
            estado = estadoDAO.consultaEstadoNombre(cmb_Estado.getItemAt(cmb_Estado.getSelectedIndex()));
            nCiudad.setNombre(txf_Nombre.getText().toUpperCase());
            nCiudad.setIdEstado(estado.getIdEstado());
            nCiudad.setEstatus("A");
            try {
                CiudadDAO altaCiudad = new CiudadDAO(this.conexion);
                if (altaCiudad.insertarCiudad(nCiudad)) {
                    JOptionPane.showMessageDialog(null, "Ciudad Añadida con exito");
                    CiudadesFrame ciudades = new CiudadesFrame(this.conexion);
                    this.dispose();
                    ciudades.setVisible(true);
                    this.pack();
                } else {
                    JOptionPane.showMessageDialog(null, "Error: No se pudo realizar la operaciónn");
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else {
            EstadoDAO estadoDAO = new EstadoDAO(this.conexion);
            RH_Estado estado = new RH_Estado();
            estado = estadoDAO.consultaEstadoNombre(cmb_Estado.getItemAt(cmb_Estado.getSelectedIndex()));
            nCiudad.setNombre(txf_Nombre.getText().toUpperCase());
            nCiudad.setIdEstado(estado.getIdEstado());
            try {
                CiudadDAO modificarCiudad = new CiudadDAO(this.conexion);
                if (modificarCiudad.actualizarCiudad(nCiudad)) {
                    JOptionPane.showMessageDialog(null, "Ciudad Modificada con exito");
                    CiudadesFrame ciudades = new CiudadesFrame(this.conexion);
                    this.dispose();
                    ciudades.setVisible(true);
                    this.pack();
                } else {
                    JOptionPane.showMessageDialog(null, "Error: No se pudo realizar la operación");
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_AddCiudadActionPerformed
    public void verificarCampos() {
        if ("".equals(txf_Nombre.getText()) && cmb_Estado.getSelectedIndex() == 0) {
            lbl_Mensaje.setText("Debe llenar todos los campos");
            btn_AddCiudad.setEnabled(false);
        } else {
            if ("".equals(txf_Nombre.getText())) {
                lbl_Mensaje.setText("Debe asignar un nombre a la ciudad");
                btn_AddCiudad.setEnabled(false);
            } else {
                if (cmb_Estado.getSelectedIndex() == 0) {
                    lbl_Mensaje.setText("Debe asignar un estado");
                    btn_AddCiudad.setEnabled(false);
                } else {
                    lbl_Mensaje.setText("");
                    btn_AddCiudad.setEnabled(true);
                }
            }

        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddCiudad;
    private javax.swing.JButton btn_Atras;
    private javax.swing.JComboBox<String> cmb_Estado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_Operacion;
    private javax.swing.JTextField txf_Nombre;
    // End of variables declaration//GEN-END:variables
}
