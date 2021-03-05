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

    public ArrayList<RH_Estado> consultaEstados() {
        String sql = "select * "
                + "from RH.Estados"
                + " ORDER BY idEstado ASC";
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

    public ArrayList<RH_Estado> consultaEstadoNombre(String nombre) {
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

    public ArrayList<RH_Estado> consultaEstadoId(Integer idEstado) {
        String sql = "select * "
                + "from RH.Estados "
                + "where idEstado=? ";
        ArrayList<RH_Estado> lista = new ArrayList<>();
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setInt(1, idEstado);
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

    public boolean eliminacionLogicaEstado(RH_Estado p) {
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

    public ConexionBD getConexion() {
        return conexion;
    }

    public void setConexion(ConexionBD conexion) {
        this.conexion = conexion;
    }

}
