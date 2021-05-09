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

import modelo.RH_FormaPago;

/**
 *
 * @author Marco Chavez
 */
public class FormaPagoDAO {

    private ConexionBD conexion;

    public FormaPagoDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarFormaPago(RH_FormaPago formaPago) {
        String sql = "insert into RH.FormasPago values(?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, formaPago.getNombre());
            st.setString(2, "A");
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_FormaPago> consultaFormasPagoVista() {
        String sql = "select * from vFormasPago "
                + "order by idFormaPago ";

        ArrayList<RH_FormaPago> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_FormaPago e = new RH_FormaPago();
                e.setIdFormaPago(rs.getInt("idFormaPago"));
                e.setNombre(rs.getString("nombre"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_FormaPago> consultaFormasPagoVistaPaginada(Integer pagina) {
        String sql = "select * from vFormasPago "
                + "order by idFormaPago "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_FormaPago> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_FormaPago e = new RH_FormaPago();
                e.setIdFormaPago(rs.getInt("idFormaPago"));
                e.setNombre(rs.getString("nombre"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public Integer consultaPaginas() {
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as FormasPago FROM vFormasPago)/CAST(" + 3 + " AS float)))as paginasMaximas";
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as FormasPago FROM vFormasPago where Nombre like CONCAT( '%','" + nombre + "','%'))/CAST(" + 3 + " AS float)))as paginasMaximas";
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

    public ArrayList<RH_FormaPago> consultaFormasPagoNombreVistaPaginada(String nombre, Integer pagina) {
        String sql = "select * "
                + "from vFormasPago "
                + "where nombre like CONCAT( '%','" + nombre + "','%') "
                + "order by idFormaPago "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_FormaPago> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_FormaPago e = new RH_FormaPago();
                e.setIdFormaPago(rs.getInt("idFormaPago"));
                e.setNombre(rs.getString("nombre"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_FormaPago> consultaFormasPagoNombreVista(String nombre) {
        String sql = "select * "
                + "from RH.FormasPago "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<RH_FormaPago> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_FormaPago e = new RH_FormaPago();
                e.setIdFormaPago(rs.getInt("idFormaPago"));
                e.setNombre(rs.getString("nombre"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_FormaPago consultaFormaPagoNombre(String nombre) {
        String sql = "select * "
                + "from RH.FormasPago "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        RH_FormaPago formaPago = new RH_FormaPago();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                formaPago.setIdFormaPago(rs.getInt("idFormaPago"));
                formaPago.setNombre(rs.getString("nombre"));
                formaPago.setEstatus(rs.getString("estatus"));

            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return formaPago;

    }

    public RH_FormaPago consultaFormaPagoId(int idFormaPago) {
        String sql = (" select * "
                + " from RH.FormasPago "
                + " where idFormaPago=" + idFormaPago);
        RH_FormaPago formaPago = new RH_FormaPago();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                formaPago.setIdFormaPago(rs.getInt("idFormaPago"));
                formaPago.setNombre(rs.getString("nombre"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return formaPago;
    }

    public boolean actualizarFormaPago(RH_FormaPago formaPago) {
        String sql = "update RH.FormasPago set nombre=?, estatus=? "
                + " where idFormaPago=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setString(1, formaPago.getNombre());
            st.setString(2, formaPago.getEstatus());
            st.setInt(3, formaPago.getIdFormaPago());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(RH_FormaPago p) {
        String sql = "update RH.FormasPago set estatus=? "
                + " where idFormaPago=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(2, p.getIdFormaPago());
            st.setString(1, "I");
            st.execute();
            st.close();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionFormaPago(Integer p) {
        String sql = "delete from RH.FormasPago "
                + "where idFormaPago=" + p;
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error elimando:" + e.getMessage());
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
