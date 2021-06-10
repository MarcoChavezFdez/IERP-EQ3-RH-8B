/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import conexion.ConexionBD;
import conexion.DocumentacionEmpleadoDAO;
import conexion.EmpleadoDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.RH_DocumentacionEmpleado;
import modelo.RH_Empleado;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Mino
 */
public class AddDocumentacionEmpleado extends javax.swing.JFrame {

    ConexionBD conexion;
    RH_DocumentacionEmpleado documentacionEmpleado;
    byte[] documento = null;
    ArrayList<RH_Empleado> empleados = new ArrayList();
    Boolean bandera;
    Boolean isNew;
    String path = "";

    /**
     * Creates new form AddPuestos
     *
     * @param conexion
     */
    public AddDocumentacionEmpleado(ConexionBD conexion) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.conexion = conexion;
        lbl_Titulo.setText("Añadir Documentación Empleado");
        btn_Realizar.setText("");
        this.txf_FechaDocumento.setText(String.valueOf(java.sql.Date.valueOf(LocalDate.now())));
        this.bandera = false;
        this.isNew = true;
    }

    public AddDocumentacionEmpleado(ConexionBD conexion, RH_DocumentacionEmpleado documentacion) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.conexion = conexion;
        this.documentacionEmpleado = documentacion;
        documento = this.documentacionEmpleado.getDocumento();
        txf_Nombre.setText(documentacion.getNombreDocumento());
        txf_FechaDocumento.setText(String.valueOf(documentacion.getFechaEntrega().toLocalDate()));
        this.txf_FechaDocumento.setText(String.valueOf(this.documentacionEmpleado.getFechaEntrega()));
        creaArchivo();
        lbl_Titulo.setText("Modificar Documentación Empleado");
        btn_Realizar.setText("");
        btn_Realizar.setEnabled(true);
        this.bandera = true;
        this.isNew = false;
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
        btn_Atras = new javax.swing.JButton();
        lbl_Titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txf_Nombre = new javax.swing.JTextField();
        lbl_Mensaje = new javax.swing.JLabel();
        btn_Documento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Ver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmb_Empleado = new javax.swing.JComboBox<>();
        txf_FechaDocumento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 151, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Realizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ope.png"))); // NOI18N
        btn_Realizar.setBorderPainted(false);
        btn_Realizar.setContentAreaFilled(false);
        btn_Realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RealizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Realizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, -1, -1));

        btn_Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnAtras.png"))); // NOI18N
        btn_Atras.setBorderPainted(false);
        btn_Atras.setContentAreaFilled(false);
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 110));

        lbl_Titulo.setText("Realizar Operación");
        lbl_Titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        txf_Nombre.setBackground(new java.awt.Color(153, 255, 153));
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
        jPanel1.add(lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 180, 40));

        btn_Documento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Documentacion/Sele.png"))); // NOI18N
        btn_Documento.setBorderPainted(false);
        btn_Documento.setContentAreaFilled(false);
        btn_Documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DocumentoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 170, 50));

        jLabel1.setText("Documento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, 20));

        jLabel3.setText("Fecha Documento");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        btn_Ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Documentacion/Ver.png"))); // NOI18N
        btn_Ver.setBorderPainted(false);
        btn_Ver.setContentAreaFilled(false);
        btn_Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VerActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 180, 50));

        jLabel4.setText("Documentación de Empleados");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel5.setText("Empleado: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        cmb_Empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Empleado" }));
        cmb_Empleado.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.add(cmb_Empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 300, 30));

        txf_FechaDocumento.setText("dd/mm/yyyy");
        txf_FechaDocumento.setEnabled(false);
        jPanel1.add(txf_FechaDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 660, 599));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RealizarActionPerformed
        DocumentacionEmpleadoDAO documentacionDAO = new DocumentacionEmpleadoDAO(this.conexion);
        RH_DocumentacionEmpleado documentacion = new RH_DocumentacionEmpleado();
        documentacion.setNombreDocumento(txf_Nombre.getText());
        documentacion.setFechaEntrega(java.sql.Date.valueOf(txf_FechaDocumento.getText()));
        documentacion.setDocumento(documento);
        documentacion.setEmpleado(empleados.get(cmb_Empleado.getSelectedIndex() - 1));
        documentacion.setEstatus("A");
        if (!isNew) {
            documentacion.setIdDocumento(this.documentacionEmpleado.getIdDocumento());
            if (documentacionDAO.actualizarDocumentacionEmpleado(documentacion)) {
                JOptionPane.showMessageDialog(null, "Documentacion Modificada con exito");
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al intentar modificar la documentacion");
            }
        } else {
            if (documentacionDAO.insertarDocumentacionEmpleado(documentacion)) {
                JOptionPane.showMessageDialog(null, "Documentacion creada con exito");

            } else {
                JOptionPane.showMessageDialog(null, "Sucedio un error al intentar crear la documentacion");
            }
        }
        DocumentacionEmpleadoFrame documentacionEmpleado = new DocumentacionEmpleadoFrame(this.conexion);
        this.dispose();
        documentacionEmpleado.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btn_RealizarActionPerformed
    private void creaArchivo() {
        try {
            path = (new File(".").getCanonicalPath());
            FileUtils.writeByteArrayToFile(new File(path + "\\resources\\docEmpleado.pdf"), this.documento);
        } catch (IOException ex) {
            Logger.getLogger(AddAusenciaJustificadaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        PrincipalFrame principal = new PrincipalFrame(this.conexion);
        this.dispose();
        principal.setVisible(true);
        principal.pack();
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void txf_NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_NombreKeyReleased
        verificarCampos();
    }//GEN-LAST:event_txf_NombreKeyReleased

    private void txf_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_NombreActionPerformed

    private void btn_DocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DocumentoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Documentos", "pdf"));
        fileChooser.showOpenDialog(fileChooser);
        try {
            documento = FileUtils.readFileToByteArray(fileChooser.getSelectedFile());
            creaArchivo();
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(AddDocumentacionEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_DocumentoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        EmpleadoDAO daoEmpleado = new EmpleadoDAO(this.conexion);
        empleados = daoEmpleado.consultaEmpleadosVista();
        empleados.forEach((e) -> {
            cmb_Empleado.addItem(e.getNombreCompleto());
            if (!isNew) {
                if (e.getNombreCompleto().equals(documentacionEmpleado.getEmpleado().getNombreCompleto())) {
                    cmb_Empleado.setSelectedIndex(empleados.indexOf(e) + 1);
                }
            }
        });
    }//GEN-LAST:event_formWindowOpened

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        verificarCampos();
    }//GEN-LAST:event_formMouseMoved

    private void btn_VerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VerActionPerformed
        try {
            path = (new File(".").getCanonicalPath());
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + path + "\\resources\\docEmpleado.pdf");
        } catch (Exception evvv) {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda, probablemente fue borrado", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btn_VerActionPerformed
    public void verificarCampos() {

        if (!"".equals(txf_Nombre.getText()) && cmb_Empleado.getSelectedIndex() > 0 && !Objects.isNull(documento)) {
            btn_Realizar.setEnabled(true);
            lbl_Mensaje.setText("");
        } else {
            btn_Realizar.setEnabled(false);
            lbl_Mensaje.setText("Debe llenar los campos");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_Documento;
    private javax.swing.JButton btn_Realizar;
    private javax.swing.JButton btn_Ver;
    private javax.swing.JComboBox<String> cmb_Empleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTextField txf_FechaDocumento;
    private javax.swing.JTextField txf_Nombre;
    // End of variables declaration//GEN-END:variables
}
