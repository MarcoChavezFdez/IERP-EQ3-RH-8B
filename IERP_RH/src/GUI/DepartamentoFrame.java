/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.ConexionBD;
import conexion.DepartamentoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RH_Departamento;

/**
 *
 * @author selen
 */
public class DepartamentoFrame extends javax.swing.JFrame {

    /**
     * Creates new form DepartamentoFrame
     */
    ConexionBD conexion;
    int paginaActual;
    int paginaMaxima;
    boolean banderaBusqueda = false;

    public DepartamentoFrame(ConexionBD conexion) {
        this.conexion = conexion;
        this.paginaActual = 1;
        initComponents();
        DepartamentoDAO Depa = new DepartamentoDAO(this.conexion);
        this.paginaMaxima = Depa.consultaPaginas();
        lbl_PaginaMaxima.setText(String.valueOf(this.paginaMaxima));
        ArrayList<RH_Departamento> lista = Depa.consultaDepartamentosVistaPaginada(paginaActual);
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
        btn_Anterior = new javax.swing.JButton();
        btn_Siguiente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_PaginaActual = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txf_Busqueda = new javax.swing.JTextField();
        lbl_PaginaMaxima = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Anterior.setText("Anterior");
        btn_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnteriorActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 643, -1, -1));

        btn_Siguiente.setText("Siguiente");
        btn_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 643, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("DEPARTAMENTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 49, -1, 32));

        jLabel3.setText("Paginas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 647, -1, -1));

        jLabel2.setText("Buscar por nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 157, 109, -1));

        lbl_PaginaActual.setText("1");
        jPanel1.add(lbl_PaginaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 647, -1, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnGuardar.png"))); // NOI18N
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setDefaultCapable(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 185, 168, -1));

        jLabel5.setText("de");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 647, -1, -1));

        txf_Busqueda.setBackground(new java.awt.Color(153, 255, 153));
        txf_Busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txf_BusquedaKeyReleased(evt);
            }
        });
        jPanel1.add(txf_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 154, 222, -1));

        lbl_PaginaMaxima.setText("1");
        jPanel1.add(lbl_PaginaMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 647, -1, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        btnAtras.setContentAreaFilled(false);
        btnAtras.setDefaultCapable(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 214, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Turnos/btn_Modificar.png"))); // NOI18N
        btnModificar.setContentAreaFilled(false);
        btnModificar.setDefaultCapable(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 304, 168, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Turnos/btn_Eliminar.png"))); // NOI18N
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setDefaultCapable(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 413, 168, -1));

        tblDatos.setBackground(new java.awt.Color(153, 255, 153));
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idDepartamento", "Nombre", "Estatus"
            }
        ));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 185, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AddDepartamento AddDepa = new AddDepartamento(this.conexion);
        this.dispose();
        AddDepa.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        PrincipalFrame pf = new PrincipalFrame(this.conexion);
        this.dispose();
        pf.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Integer idDepartamento = Integer.parseInt(tblDatos.getValueAt(tblDatos.getSelectedRow(), 0).toString());
        DepartamentoDAO DAO = new DepartamentoDAO(this.conexion);
        RH_Departamento depa = new RH_Departamento();
        depa = DAO.consultaDepartamentoId(idDepartamento);
        AddDepartamento modificarDepartamento = new AddDepartamento(this.conexion, depa);
        this.setVisible(false);
        modificarDepartamento.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblDatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMousePressed
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblDatosMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Integer idDepartamento = Integer.parseInt(tblDatos.getValueAt(tblDatos.getSelectedRow(), 0).toString());
        String nombre = tblDatos.getValueAt(tblDatos.getSelectedRow(), 1).toString();
        int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el Departamento '" + nombre + "'?", "Confirmar Cambio de estatus", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            RH_Departamento estado = new RH_Departamento();
            DepartamentoDAO DAO = new DepartamentoDAO(this.conexion);
            estado = DAO.consultaDepartamentoId(idDepartamento);
            if (DAO.eliminacionLogica(estado)) {
                JOptionPane.showMessageDialog(null, "Departamento Eliminado");
                DepartamentoDAO depa = new DepartamentoDAO(this.conexion);
                ArrayList<RH_Departamento> lista = depa.consultaDepartamentosVista();
                llenarTabla(lista);

            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }

        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txf_BusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_BusquedaKeyReleased
        if ("".equals(txf_Busqueda.getText())) {
            this.banderaBusqueda = false;
            this.btn_Anterior.setEnabled(false);
            this.btn_Siguiente.setEnabled(true);
            DepartamentoDAO depa = new DepartamentoDAO(this.conexion);
            this.paginaActual = 1;
            ArrayList<RH_Departamento> lista = depa.consultaDepartamentosVistaPaginada(this.paginaActual);
            this.paginaMaxima = depa.consultaPaginas();
            this.lbl_PaginaMaxima.setText(String.valueOf(paginaMaxima));
            this.lbl_PaginaActual.setText(String.valueOf(this.paginaActual));
            llenarTabla(lista);
        } else {
            this.banderaBusqueda = true;
            DepartamentoDAO depa = new DepartamentoDAO(this.conexion);
            this.paginaActual = 1;
            ArrayList<RH_Departamento> lista = depa.consultaDepartamentosNombreVistaPaginada(txf_Busqueda.getText(), this.paginaActual);
            this.paginaMaxima = depa.consultaPaginasNombre(txf_Busqueda.getText());
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
            DepartamentoDAO DAO = new DepartamentoDAO(this.conexion);
            ArrayList<RH_Departamento> lista = new ArrayList<>();
            if (this.banderaBusqueda) {
                lista = DAO.consultaDepartamentosNombreVistaPaginada(txf_Busqueda.getText(), paginaActual);
            } else {
                lista = DAO.consultaDepartamentosVistaPaginada(paginaActual);
            }

            llenarTabla(lista);
        }
    }//GEN-LAST:event_btn_SiguienteActionPerformed

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
            DepartamentoDAO DAO = new DepartamentoDAO(this.conexion);
            ArrayList<RH_Departamento> lista = new ArrayList<>();
            if (this.banderaBusqueda) {
                lista = DAO.consultaDepartamentosNombreVistaPaginada(txf_Busqueda.getText(), paginaActual);
            } else {
                lista = DAO.consultaDepartamentosVistaPaginada(paginaActual);
            }
            llenarTabla(lista);
        }
    }//GEN-LAST:event_btn_AnteriorActionPerformed
    private void llenarTabla(ArrayList<RH_Departamento> lista) {
        String[] encabezado = {"IdDepartamento", "Nombre"};
        Object[][] datos = new Object[lista.size()][2];
        int ren = 0;
        for (RH_Departamento s : lista) {
            datos[ren][0] = s.getIdDepartamento();
            datos[ren][1] = s.getNombre();
            ren++;
        }
        DefaultTableModel m = new DefaultTableModel(datos, encabezado) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };

        tblDatos.setModel(m);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btn_Anterior;
    private javax.swing.JButton btn_Siguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_PaginaActual;
    private javax.swing.JLabel lbl_PaginaMaxima;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txf_Busqueda;
    // End of variables declaration//GEN-END:variables
}