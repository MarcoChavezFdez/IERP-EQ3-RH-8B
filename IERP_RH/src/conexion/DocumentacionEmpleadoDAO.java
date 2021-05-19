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
import javax.swing.JOptionPane;
import modelo.RH_DocumentacionEmpleado;
import modelo.RH_Empleado;

/**
 *
 * @author Marco Chavez
 */
public class DocumentacionEmpleadoDAO {

    private ConexionBD conexion;

    public DocumentacionEmpleadoDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public boolean insertarDocumentacionEmpleado(RH_DocumentacionEmpleado documentacionEmpleado) {
        String sql = "insert into RH.DocumentacionEmpleado values(?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, documentacionEmpleado.getNombreDocumento());
            st.setDate(2, documentacionEmpleado.getFechaEntrega());
            st.setBinaryStream(3, documentacionEmpleado.getDocumento());
            st.setInt(4, documentacionEmpleado.getEmpleado().getIdEmpleado());
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_DocumentacionEmpleado> consultaDocumentacionEmpleadosVista() {
        String sql = "select * from vDocumentacionEmpleados "
                + "order by idDocumento ";
        ArrayList<RH_DocumentacionEmpleado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_DocumentacionEmpleado de = new RH_DocumentacionEmpleado();
                de.setIdDocumento(rs.getInt("idDocumento"));
                de.setNombreDocumento(rs.getString("nombreDocumento"));
                de.setFechaEntrega(rs.getDate("fechaEntrega"));
                de.setDocumento(rs.getBinaryStream("documento"));
                de.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                lista.add(de);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_DocumentacionEmpleado> consultaDocumentacionEmpleadosVistaPaginada(Integer pagina) {
        String sql = "select * from vDocumentacionEmpleados "
                + "order by idDocumento "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_DocumentacionEmpleado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_DocumentacionEmpleado de = new RH_DocumentacionEmpleado();
                de.setIdDocumento(rs.getInt("idDocumento"));
                de.setNombreDocumento(rs.getString("nombreDocumento"));
                de.setFechaEntrega(rs.getDate("fechaEntrega"));
                de.setDocumento(rs.getBinaryStream("documento"));
                de.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                lista.add(de);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public Integer consultaPaginas() {
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as DocumentacionEmpleados FROM vDocumentacionEmpleados)/CAST(" + 3 + " AS float)))as paginasMaximas";
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

    public Integer consultaPaginasNombre(String nombre) {
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as DocumentacionEmpleados FROM vDocumentacionEmpleados where Nombre like CONCAT( '%','" + nombre + "','%'))/CAST(" + 3 + " AS float)))as paginasMaximas";
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

    public ArrayList<RH_DocumentacionEmpleado> consultaDocumentacionEmpleadosNombreVistaPaginada(String nombre, Integer pagina) {
        String sql = "select * "
                + "from vDocumentacionEmpleados "
                + "where nombre like CONCAT( '%','" + nombre + "','%') "
                + "order by idDocumentacion "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_DocumentacionEmpleado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_DocumentacionEmpleado de = new RH_DocumentacionEmpleado();
                de.setIdDocumento(rs.getInt("idDocumento"));
                de.setNombreDocumento(rs.getString("nombreDocumento"));
                de.setFechaEntrega(rs.getDate("fechaEntrega"));
                de.setDocumento(rs.getBinaryStream("documento"));
                de.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                lista.add(de);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_DocumentacionEmpleado> consultaDocumentacionEmpleadosNombreVista(String nombre) {
        String sql = "select * "
                + "from RH.DocumentacionEmpleados "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<RH_DocumentacionEmpleado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_DocumentacionEmpleado de = new RH_DocumentacionEmpleado();
                de.setIdDocumento(rs.getInt("idDocumento"));
                de.setNombreDocumento(rs.getString("nombreDocumento"));
                de.setFechaEntrega(rs.getDate("fechaEntrega"));
                de.setDocumento(rs.getBinaryStream("documento"));
                de.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                lista.add(de);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_DocumentacionEmpleado consultaDocumentacionEmpleadoNombre(String nombre) {
        String sql = "select * "
                + "from vDocumentacionEmpleados "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        RH_DocumentacionEmpleado de = new RH_DocumentacionEmpleado();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                de.setIdDocumento(rs.getInt("idDocumento"));
                de.setNombreDocumento(rs.getString("nombreDocumento"));
                de.setFechaEntrega(rs.getDate("fechaEntrega"));
                de.setDocumento(rs.getBinaryStream("documento"));
                de.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return de;

    }

    public RH_DocumentacionEmpleado consultaDocumentacionEmpleadoId(int idDocumento) {
        String sql = (" select * "
                + " from vDocumentacionEmpleados "
                + " where idDocumentacionEmpleado=" + idDocumento);
        RH_DocumentacionEmpleado de = new RH_DocumentacionEmpleado();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                de.setIdDocumento(rs.getInt("idDocumento"));
                de.setNombreDocumento(rs.getString("nombreDocumento"));
                de.setFechaEntrega(rs.getDate("fechaEntrega"));
                de.setDocumento(rs.getBinaryStream("documento"));
                de.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return de;
    }

    public boolean actualizarDocumentacionEmpleado(RH_DocumentacionEmpleado documentacionEmpleado) {
        String sql = "update vDocumentacionEmpleados set nombreDocumento=?, fechaEntrega=?, documento=? , idEmpleado=? "
                + " where idDocumento=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setString(1, documentacionEmpleado.getNombreDocumento());
            st.setDate(2, documentacionEmpleado.getFechaEntrega());
            st.setBinaryStream(3, documentacionEmpleado.getDocumento());
            st.setInt(4, documentacionEmpleado.getEmpleado().getIdEmpleado());
            st.setInt(5, documentacionEmpleado.getEmpleado().getIdEmpleado());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(RH_DocumentacionEmpleado p) {
        String sql = "update vDocumentacionEmpleados set estatus=? "
                + " where idDocumento=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(2, p.getIdDocumento());
            st.setString(1, "I");
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }


    public ConexionBD getConexion() {
        return conexion;
    }

    public void setConexion(ConexionBD conexion) {
        this.conexion = conexion;
    }

}
