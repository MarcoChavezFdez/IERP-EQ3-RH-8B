package GUI;

import conexion.CiudadDAO;
import conexion.ConexionBD;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RH_Ciudad;


public class CiudadesFrame extends javax.swing.JFrame {

    ConexionBD conexion;

    public CiudadesFrame(ConexionBD cn) {
        initComponents();
         this.setLocationRelativeTo(null);
        conexion = cn;
        CiudadDAO ciudades = new CiudadDAO(this.conexion);
        ArrayList<RH_Ciudad> lista = ciudades.consultaCiudadesVista();
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

        evaluatorByte1 = new org.jdesktop.core.animation.timing.evaluators.EvaluatorByte();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_Add = new javax.swing.JButton();
        btn_Atras = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txf_Ciudad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Datos = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ciudades");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(btn_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        btn_Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        btn_Atras.setBorderPainted(false);
        btn_Atras.setContentAreaFilled(false);
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        btn_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btn_Modificar.png"))); // NOI18N
        btn_Modificar.setContentAreaFilled(false);
        btn_Modificar.setDefaultCapable(false);
        btn_Modificar.setEnabled(false);
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

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
        jPanel1.add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Ciudades");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        jLabel2.setText("Buscar por nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        txf_Ciudad.setBackground(new java.awt.Color(153, 255, 153));
        txf_Ciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txf_CiudadKeyReleased(evt);
            }
        });
        jPanel1.add(txf_Ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 161, -1));

        tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdCiudad", "Nombre", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Datos.setBackground(new java.awt.Color(153, 255, 153));
        tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_DatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Datos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 600, 380));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/General/Ant.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setEnabled(false);
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, -1, -1));

        jLabel15.setText("Página");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, -1, -1));

        jLabel14.setText("1");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, -1, -1));

        jLabel13.setText("de");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, -1, -1));

        jLabel12.setText("1");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/General/Sig.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_DatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DatosMousePressed
        btn_Modificar.setEnabled(true);
        btn_Eliminar.setEnabled(true);
    }//GEN-LAST:event_tbl_DatosMousePressed

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        PrincipalFrame pf = new PrincipalFrame(this.conexion);
        this.dispose();
        pf.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        AddCiudadFrame addCiudad = new AddCiudadFrame(this.conexion);
        this.dispose();
        addCiudad.setVisible(true);
        this.pack();

    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        Integer idCiudad = Integer.parseInt(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString());
        String nombre = tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 1).toString();
        int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar la ciudad '" + nombre + "'?", "Confirmar Cambio de estatus", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            RH_Ciudad ciudad = new RH_Ciudad();
            CiudadDAO DAO = new CiudadDAO(this.conexion);
            ciudad = DAO.consultarCiudadId(idCiudad);
            if (DAO.eliminacionLogicaCiudad(ciudad)) {
                JOptionPane.showMessageDialog(null, "Ciudad Eliminada");
                CiudadDAO ciudades = new CiudadDAO(this.conexion);
                ArrayList<RH_Ciudad> lista = ciudades.consultaCiudadesVista();
                llenarTabla(lista);

            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }

        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void txf_CiudadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_CiudadKeyReleased
        CiudadDAO ciudades = new CiudadDAO(this.conexion);
        ArrayList<RH_Ciudad> lista = ciudades.consultarCiudadesNombre(txf_Ciudad.getText());
        llenarTabla(lista);
    }//GEN-LAST:event_txf_CiudadKeyReleased

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        Integer idCiudad = Integer.parseInt(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString());
        CiudadDAO DAO = new CiudadDAO(this.conexion);
        RH_Ciudad ciudad = new RH_Ciudad();
        ciudad = DAO.consultarCiudadId(idCiudad);
        AddCiudadFrame modificarCiudad = new AddCiudadFrame(this.conexion, ciudad);
        this.dispose();
        modificarCiudad.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_ModificarActionPerformed
    private void llenarTabla(ArrayList<RH_Ciudad> lista) {
        String[] encabezado = {"IdCiudad", "Nombre Ciudad", "Estado"};
        Object[][] datos = new Object[lista.size()][4];
        int ren = 0;
        for (RH_Ciudad s : lista) {
            datos[ren][0] = s.getIdCiudad();
            datos[ren][1] = s.getNombre();
            datos[ren][2] = s.getEstado().getNombre();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private org.jdesktop.core.animation.timing.evaluators.EvaluatorByte evaluatorByte1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Datos;
    private javax.swing.JTextField txf_Ciudad;
    // End of variables declaration//GEN-END:variables
}
