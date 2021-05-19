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
import modelo.RH_Estado;

/**
 *
 * @author Marco Chavez
 */
public class EstadoDAO {

    private ConexionBD conexion;

    public EstadoDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarEstado(RH_Estado estado) {
        String sql = "insert into RH.Estados values(?,?,?)";
        boolean ban = false;
        try {

            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, estado.getNombre());
            st.setString(2, estado.getSiglas());
            st.setString(3, estado.getEstatus());
            st.execute();

            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Estado> consultaEstadosVista() {
        String sql = "select * from vEstados "
                + "order by idEstado ";

        ArrayList<RH_Estado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Estado e = new RH_Estado();
                e.setIdEstado(rs.getInt("idEstado"));
                e.setNombre(rs.getString("nombre"));
                e.setSiglas(rs.getString("siglas"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Estado> consultaEstadosVistaPaginada(Integer pagina) {
        String sql = "select * from vEstados "
                + "order by idEstado "
                + "offset " + (pagina - 1) * 10 + " rows "
                + "fetch next 10 rows only ";

        ArrayList<RH_Estado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Estado e = new RH_Estado();
                e.setIdEstado(rs.getInt("idEstado"));
                e.setNombre(rs.getString("nombre"));
                e.setSiglas(rs.getString("siglas"));
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Estados FROM vEstados)/CAST(" + 10 + " AS float)))as paginasMaximas";
        Integer r = null;
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                RH_Estado e = new RH_Estado();
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Estados FROM vEstados where Nombre like CONCAT( '%','" + nombre + "','%'))/CAST(" + 10 + " AS float)))as paginasMaximas";
        Integer r = null;
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                RH_Estado e = new RH_Estado();
                r = rs.getInt("paginasMaximas");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return r;
    }

    public ArrayList<RH_Estado> consultaEstadosNombreVistaPaginada(String nombre, Integer pagina) {
        String sql = "select * "
                + "from vEstados "
                + "where nombre like CONCAT( '%','" + nombre + "','%') "
                + "order by idEstado "
                + "offset " + (pagina - 1) * 10 + " rows "
                + "fetch next 10 rows only ";

        ArrayList<RH_Estado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Estado e = new RH_Estado();
                e.setIdEstado(rs.getInt("idEstado"));
                e.setNombre(rs.getString("nombre"));
                e.setSiglas(rs.getString("siglas"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Estado> consultaEstadosNombreVista(String nombre) {
        String sql = "select * "
                + "from RH.Estados "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<RH_Estado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Estado e = new RH_Estado();
                e.setIdEstado(rs.getInt("idEstado"));
                e.setNombre(rs.getString("nombre"));
                e.setSiglas(rs.getString("siglas"));
                e.setEstatus(rs.getString("estatus"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_Estado consultaEstadoNombre(String nombre) {
        String sql = "select * "
                + "from RH.Estados "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        RH_Estado estado = new RH_Estado();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                estado.setIdEstado(rs.getInt("idEstado"));
                estado.setNombre(rs.getString("nombre"));
                estado.setSiglas(rs.getString("siglas"));
                estado.setEstatus(rs.getString("estatus"));

            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return estado;

    }

    public RH_Estado consultaEstadoId(int idEstado) {
        String sql = (" select * "
                + " from RH.Estados "
                + " where idEstado=" + idEstado);
        RH_Estado estado = new RH_Estado();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                estado.setIdEstado(rs.getInt("idEstado"));
                estado.setNombre(rs.getString("nombre"));
                estado.setSiglas(rs.getString("siglas"));
                estado.setEstatus(rs.getString("estatus"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return estado;
    }

    public boolean actualizarEstado(RH_Estado estado) {
        String sql = "update RH.Estados set nombre=?, siglas=?, estatus=? "
                + " where idEstado=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(4, estado.getIdEstado());
            st.setString(1, estado.getNombre());
            st.setString(2, estado.getSiglas());
            st.setString(3, estado.getEstatus());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(RH_Estado p) {
        String sql = "update RH.Estados set estatus=? "
                + " where idEstado=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(2, p.getIdEstado());
            st.setString(1, "I");
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionEstado(Integer p) {
        String sql = "delete from RH.Estados "
                + "where idEstado=" + p;
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
