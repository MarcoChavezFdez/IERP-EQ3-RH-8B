package GUI;

import conexion.CiudadDAO;
import conexion.ConexionBD;
import conexion.EstadoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RH_Ciudad;
import modelo.RH_Estado;

public class CiudadesFrame extends javax.swing.JFrame {

    ConexionBD conexion;

    public CiudadesFrame(ConexionBD cn) {
        initComponents();
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Datos = new javax.swing.JTable();
        btn_Add = new javax.swing.JButton();
        btn_Atras = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txf_Ciudad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
        tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_DatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Datos);

        btn_Add.setText("Añadir ");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        btn_Atras.setText("Atras");
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });

        btn_Modificar.setText("Modificar");
        btn_Modificar.setEnabled(false);
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.setEnabled(false);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ciudades");

        jLabel2.setText("Buscar por nombre");

        txf_Ciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txf_CiudadKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_Atras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(296, 296, 296)
                        .addComponent(btn_Add))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Modificar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txf_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Eliminar)))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Atras)
                    .addComponent(btn_Add)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btn_Modificar)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Eliminar)
                    .addComponent(jLabel2)
                    .addComponent(txf_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                JOptionPane.showMessageDialog(null, "Estado Eliminado");
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
        ciudad.setNombreEstado(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 2).toString());
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
            datos[ren][2] = s.getNombreEstado();
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Datos;
    private javax.swing.JTextField txf_Ciudad;
    // End of variables declaration//GEN-END:variables
}
