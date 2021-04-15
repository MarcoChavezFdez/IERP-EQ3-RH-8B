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
import modelo.RH_Deduccion;

/**
 *
 * @author CarlosEsparza
 */
public class DeduccionesDAO {

    private ConexionBD conexion;

    public DeduccionesDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarDeduccion(RH_Deduccion deduccion) {
        String sql = "insert into RH.Deducciones values(?,?,?,?)";
        boolean ban = false;
        try {

            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, deduccion.getNombre());
            st.setString(2, deduccion.getDescripcion());
            st.setFloat(3, deduccion.getPorcentaje());
            st.setString(4, "A");
            st.execute();

            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Deduccion> consultaDeducciones() {
        String sql = "select * "
                + "from vDeducciones "
                + "ORDER BY idDeduccion ASC";
        ArrayList<RH_Deduccion> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Deduccion e = new RH_Deduccion();
                e.setIdDeduccion(rs.getInt("idDeduccion"));
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setPorcentaje(rs.getFloat("porcentaje"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Deduccion> consultaDeduccionesNombre(String nombre) {
        String sql = "select * "
                + "from vDeducciones "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<RH_Deduccion> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Deduccion e = new RH_Deduccion();
                e.setIdDeduccion(rs.getInt("idDeduccion"));
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setPorcentaje(rs.getFloat("porcentaje"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_Deduccion consultaDeduccionId(Integer idDeduccion) {
        String sql = ("select * "
                + "from vDeducciones "
                + "where idDeduccion=" + idDeduccion);
        RH_Deduccion deduccion = new RH_Deduccion();
        try {
            // PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                deduccion.setIdDeduccion(rs.getInt("idDeduccion"));
                deduccion.setNombre(rs.getString("nombre"));
                deduccion.setDescripcion(rs.getString("descripcion"));
                deduccion.setPorcentaje(rs.getFloat("porcentaje"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return deduccion;
    }

    public boolean actualizarDeduccion(RH_Deduccion deduccion) {
        String sql = "update RH.Deducciones set nombre=?, descripcion=?, porcentaje=? "
                + " where idDeduccion=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(4, deduccion.getIdDeduccion());
            st.setString(1, deduccion.getNombre());
            st.setString(2, deduccion.getDescripcion());
            st.setFloat(3, deduccion.getPorcentaje());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogicaDeduccion(Integer p) {
        String sql = "update RH.Deducciones set estatus=? "
                + " where idDeduccion=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setString(1, "I");
            st.setInt(2, p);
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
