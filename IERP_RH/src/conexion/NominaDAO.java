/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.RH_Empleado;
import modelo.RH_FormaPago;
import modelo.RH_Nomina;
import modelo.RH_Periodo;

/**
 *
 * @author Marco Chavez
 */
public class NominaDAO {

    private ConexionBD conexion;

    public NominaDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarNomina(RH_Nomina nomina) {
        String sql = "insert into RH.Nominas values(?,?,?,?,?,?,?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setDate(1, nomina.getFechaElaboracion());
            st.setDate(2, nomina.getFechaPago());
            st.setFloat(3, nomina.getSubtotal());
            st.setFloat(4, nomina.getRetenciones());
            st.setFloat(5, nomina.getTotal());
            st.setInt(6, nomina.getDiasTrabajados());
            st.setString(7, nomina.getEstatus());
            st.setInt(8, nomina.getEmpleado().getIdEmpleado());
            st.setInt(9, nomina.getFormaPago().getIdFormaPago());
            st.setInt(10, nomina.getPeriodo().getIdPeriodo());
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Nomina> consultaNominasVista() {
        String sql = "select * from vNominas "
                + "order by idNomina ";

        ArrayList<RH_Nomina> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Nomina e = new RH_Nomina();
                e.setIdNomina(rs.getInt("idNomina"));
                e.setFechaElaboracion(rs.getDate("fechaElaboracion"));
                e.setFechaPago(rs.getDate("fechaPago"));
                e.setSubtotal(rs.getFloat("subtotal"));
                e.setRetenciones(rs.getFloat("retenciones"));
                e.setTotal(rs.getFloat("total"));
                e.setDiasTrabajados(rs.getInt("diastrabajados"));
                e.setEstatus(rs.getString("estatus"));
                e.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                e.setFormaPago(new RH_FormaPago(rs.getInt("idFormaPago"), this.conexion));
                e.setPeriodo(new RH_Periodo(rs.getInt("idPeriodo"), this.conexion));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public void calculaNominaPercepciones(Integer idNomina) {
        String sql = "{call RH.calculaNominaPercepciones(?)}";
        try {
            PreparedStatement pstmt = conexion.getConexion().prepareStatement(sql);
            pstmt.setInt(1, idNomina);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Executar calculaNominaPercepciones: " + ex.getMessage());
        }
    }
    
        public void calculaNominaDeducciones(Integer idNomina) {
        String sql = "{call RH.calculaNominaDeducciones(?)}";
        try {
            PreparedStatement pstmt = conexion.getConexion().prepareStatement(sql);
            pstmt.setInt(1, idNomina);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Executar calculaNominaDeducciones: " + ex.getMessage());
        }
    }

    public ArrayList<RH_Nomina> consultaNominasVistaPaginada(Integer pagina) {
        String sql = "select * from vNominas "
                + "order by idNomina "
                + "offset " + (pagina - 1) * 5 + " rows "
                + "fetch next 5 rows only ";

        ArrayList<RH_Nomina> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Nomina e = new RH_Nomina();
                e.setIdNomina(rs.getInt("idNomina"));
                e.setFechaElaboracion(rs.getDate("fechaElaboracion"));
                e.setFechaPago(rs.getDate("fechaPago"));
                e.setSubtotal(rs.getFloat("subtotal"));
                e.setRetenciones(rs.getFloat("retenciones"));
                e.setTotal(rs.getFloat("total"));
                e.setDiasTrabajados(rs.getInt("diastrabajados"));
                e.setEstatus(rs.getString("estatus"));
                e.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                e.setFormaPago(new RH_FormaPago(rs.getInt("idFormaPago"), this.conexion));
                e.setPeriodo(new RH_Periodo(rs.getInt("idPeriodo"), this.conexion));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_Nomina consultaNominaId(Integer idNomina) {
        String sql = "select * from RH.Nominas "
                + " where idNomina=" + idNomina;
        RH_Nomina n = new RH_Nomina();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                n.setIdNomina(rs.getInt("idNomina"));
                n.setFechaElaboracion(rs.getDate("fechaElaboracion"));
                n.setFechaPago(rs.getDate("fechaPago"));
                n.setSubtotal(rs.getFloat("subtotal"));
                n.setRetenciones(rs.getFloat("retenciones"));
                n.setTotal(rs.getFloat("total"));
                n.setDiasTrabajados(rs.getInt("diastrabajados"));
                n.setEstatus(rs.getString("estatus"));
                n.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                n.setFormaPago(new RH_FormaPago(rs.getInt("idFormaPago"), this.conexion));
                n.setPeriodo(new RH_Periodo(rs.getInt("idPeriodo"), this.conexion));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return n;
    }

    public Integer consultaPaginas() {
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Nominas FROM vNominas)/CAST(" + 5 + " AS float)))as paginasMaximas";
        Integer r = null;
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                r = rs.getInt("paginasMaximas");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return r;
    }

    public Integer consultaIdGenerado() {
        String sql = "select MAX(idNomina)as idNomina from RH.Nominas ";
        Integer idNomina = 0;
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                idNomina = (rs.getInt("idNomina"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return idNomina;
    }
}
