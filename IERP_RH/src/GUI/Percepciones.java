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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RH_Percepcion;

public class Percepciones extends javax.swing.JFrame {

    /**
     * Creates new form Percepciones
     */
    ConexionBD conexion;
    int paginaActual;
    int paginaMaxima;
    boolean banderaBusqueda = false;

    public Percepciones(ConexionBD cn) {
        initComponents();
         this.setLocationRelativeTo(null);
        conexion = cn;
        PercepcionDAO percepcion = new PercepcionDAO(this.conexion);
        this.paginaMaxima = percepcion.consultaPaginas();
        this.paginaActual = 1;
        ArrayList<RH_Percepcion> lista = percepcion.consultaPercepcionesVistaPaginada(this.paginaActual);
        lbl_PaginaActual.setText(String.valueOf(paginaActual));
        lbl_PaginaMaxima.setText(String.valueOf(paginaMaxima));
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
        btn_Anterior = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_PaginaActual = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_PaginaMaxima = new javax.swing.JLabel();
        btn_Siguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Percepciones");
        setResizable(false);

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
                "IdPercepcion", "Nombre", "Descripcion", "Dias Pagar"
            }
        ));
        tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_DatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Datos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 390, 350));

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
        jLabel2.setText("Percepciones");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, 40));

        btn_Anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/General/Ant.png"))); // NOI18N
        btn_Anterior.setBorderPainted(false);
        btn_Anterior.setContentAreaFilled(false);
        btn_Anterior.setEnabled(false);
        btn_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnteriorActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 140, 40));

        jLabel3.setText("Página");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, -1, -1));

        lbl_PaginaActual.setText("1");
        jPanel1.add(lbl_PaginaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 10, -1));

        jLabel4.setText("de");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, -1, -1));

        lbl_PaginaMaxima.setText("1");
        jPanel1.add(lbl_PaginaMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, -1, -1));

        btn_Siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/General/Sig.png"))); // NOI18N
        btn_Siguiente.setBorderPainted(false);
        btn_Siguiente.setContentAreaFilled(false);
        btn_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

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

    private void txf_BusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_BusquedaKeyReleased
        if ("".equals(txf_Busqueda.getText())) {
            this.banderaBusqueda = false;
            this.btn_Anterior.setEnabled(false);
            this.btn_Siguiente.setEnabled(true);
            PercepcionDAO percepciones = new PercepcionDAO(this.conexion);
            this.paginaActual = 1;
            ArrayList<RH_Percepcion> lista = percepciones.consultaPercepcionesVistaPaginada(this.paginaActual);
            this.paginaMaxima = percepciones.consultaPaginas();
            this.lbl_PaginaMaxima.setText(String.valueOf(paginaMaxima));
            this.lbl_PaginaActual.setText(String.valueOf(this.paginaActual));
            llenarTabla(lista);
        } else {
            this.banderaBusqueda = true;
            PercepcionDAO estados = new PercepcionDAO(this.conexion);
            this.paginaActual = 1;
            ArrayList<RH_Percepcion> lista = estados.consultaPercepcionesNombreVistaPaginada(txf_Busqueda.getText(), this.paginaActual);
            this.paginaMaxima = estados.consultaPaginasNombre(txf_Busqueda.getText());
            this.lbl_PaginaMaxima.setText(String.valueOf(paginaMaxima));
            this.lbl_PaginaActual.setText(String.valueOf(this.paginaActual));
            if (paginaMaxima == 0) {
                lbl_PaginaActual.setText("0");
                btn_Siguiente.setEnabled(false);
                btn_Anterior.setEnabled(false);
            } else {
                btn_Anterior.setEnabled(false);
                if (paginaMaxima > 1) {
                    btn_Siguiente.setEnabled(true);
                } else {
                    btn_Siguiente.setEnabled(false);
                }
            }
            llenarTabla(lista);
        }
    }//GEN-LAST:event_txf_BusquedaKeyReleased

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        AddPercepcionesFrame addPercepcion = new AddPercepcionesFrame(this.conexion);
        this.dispose();
        addPercepcion.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        Integer idPercepcion = Integer.parseInt(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString());
        PercepcionDAO DAO = new PercepcionDAO(this.conexion);
        RH_Percepcion deduccion = new RH_Percepcion();
        deduccion = DAO.consultaPercepcionId(idPercepcion);
        AddPercepcionesFrame modificarPercepcion = new AddPercepcionesFrame(this.conexion, deduccion);
        this.setVisible(false);
        modificarPercepcion.setVisible(true);
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void tbl_DatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DatosMousePressed
        btn_Modificar.setEnabled(true);
        btn_Eliminar.setEnabled(true);
    }//GEN-LAST:event_tbl_DatosMousePressed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        Integer idPercepcion = Integer.parseInt(tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 0).toString());
        String nombre = tbl_Datos.getValueAt(tbl_Datos.getSelectedRow(), 1).toString();
        int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea ELIMINAR la Percepcion '" + nombre + "' ?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
        PercepcionDAO DAO = new PercepcionDAO(this.conexion);
        RH_Percepcion percepcion = new RH_Percepcion();
        percepcion = DAO.consultaPercepcionId(idPercepcion);
        if (reply == JOptionPane.YES_OPTION) {
            if (DAO.eliminacionLogica(percepcion)) {
                JOptionPane.showMessageDialog(null, "Percepcion Eliminada");
                PercepcionDAO deducciones = new PercepcionDAO(this.conexion);
                ArrayList<RH_Percepcion> lista = deducciones.consultaPercepcionesNombreVista(nombre);
                llenarTabla(lista);

            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnteriorActionPerformed
        if ((paginaActual - 1) >= 1) {
            btn_Siguiente.setEnabled(true);
            paginaActual--;
            if (paginaActual == 1) {
                this.btn_Anterior.setEnabled(false);
            } else {
                this.btn_Anterior.setEnabled(true);
            }
            this.lbl_PaginaActual.setText(String.valueOf(paginaActual));
            PercepcionDAO DAO = new PercepcionDAO(this.conexion);
            ArrayList<RH_Percepcion> lista = new ArrayList<>();
            if (this.banderaBusqueda) {
                lista = DAO.consultaPercepcionesNombreVistaPaginada(txf_Busqueda.getText(), paginaActual);
            } else {
                lista = DAO.consultaPercepcionesVistaPaginada(paginaActual);
            }

            llenarTabla(lista);
        }
    }//GEN-LAST:event_btn_AnteriorActionPerformed

    private void btn_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiguienteActionPerformed
        if ((paginaActual + 1) <= paginaMaxima) {
            btn_Anterior.setEnabled(true);
            paginaActual++;
            if (paginaActual == paginaMaxima) {
                this.btn_Siguiente.setEnabled(false);
            } else {
                this.btn_Siguiente.setEnabled(true);
            }
            this.lbl_PaginaActual.setText(String.valueOf(paginaActual));
            PercepcionDAO DAO = new PercepcionDAO(this.conexion);
            ArrayList<RH_Percepcion> lista = new ArrayList<>();
            if (this.banderaBusqueda) {
                lista = DAO.consultaPercepcionesNombreVista(txf_Busqueda.getText());
            } else {
                lista = DAO.consultaPercepcionesVistaPaginada(paginaActual);
            }

            llenarTabla(lista);
        }
    }//GEN-LAST:event_btn_SiguienteActionPerformed

    /**
     * @param args the command line arguments
     */
    private void llenarTabla(ArrayList<RH_Percepcion> lista) {
        String[] encabezado = {"IdPercepcion", "Nombre", "Descripcion", "DiasPagar"};
        Object[][] datos = new Object[lista.size()][4];
        int ren = 0;
        for (RH_Percepcion s : lista) {
            datos[ren][0] = s.getIdPercepcion();
            datos[ren][1] = s.getNombre();
            datos[ren][2] = s.getDescripcion();
            datos[ren][3] = s.getDiasPagar();
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
    private javax.swing.JButton btn_Anterior;
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Siguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_PaginaActual;
    private javax.swing.JLabel lbl_PaginaMaxima;
    private javax.swing.JTable tbl_Datos;
    private javax.swing.JTextField txf_Busqueda;
    // End of variables declaration//GEN-END:variables
}
