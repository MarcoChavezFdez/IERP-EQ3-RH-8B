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
import modelo.RH_Turno;

/**
 *
 * @author selen
 */
public class TurnosDAO {

    private ConexionBD conexion;

    public TurnosDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarTurno(RH_Turno turno) {
        String sql = "insert into RH.Estados values(?,?,?,?,?)";
        boolean ban = false;
        try {
            try (PreparedStatement st = conexion.getConexion().prepareStatement(sql)) {
                st.setInt(1, turno.getIdTurno());
                st.setString(2, turno.getNombre());
                st.setInt(3, turno.getHoraInicio());
                st.setInt(4,turno.getHoraFin());
                st.setString(5, null);
                st.execute();
            }
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());

            
        }
        return ban;
    }
    

    public ArrayList<RH_Turno> consultaTurnos() {
        String sql = "from RH.Turnos"
                + "select * "
                + " ORDER BY idTurno ASC";
        ArrayList<RH_Turno> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Turno e = new RH_Turno();
                e.setIdTurno(rs.getInt("idTurno"));
                e.setNombre(rs.getString("nombre"));
                e.setHoraInicio(rs.getInt("horaInicio"));
                e.setHoraFin(rs.getInt("horaFin"));
                e.setDias(rs.getString(null));
                lista.add((e));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }
 public ArrayList<RH_Turno> consultaTurnoNombre(String nombre) {
        String sql = "select * "
                + "from RH.Turnos "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<RH_Turno> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Turno e = new RH_Turno();
                e.setIdTurno(rs.getInt("idTurno"));
                e.setNombre(rs.getString("nombre"));
                e.setHoraInicio(rs.getInt("horaInicio"));
                e.setHoraFin(rs.getInt("horaFin"));
                e.setDias(rs.getString(null));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Turno> consultaTurnoId(Integer idTurno) {
        String sql = "select * "
                + "from RH.Turnos "
                + "where idTurno=? ";
        ArrayList<RH_Turno> lista = new ArrayList<>();
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setInt(1, idTurno);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Turno e = new RH_Turno();
                e.setIdTurno(rs.getInt("idTurno"));
                e.setNombre(rs.getString("nombre"));
                e.setHoraInicio(rs.getInt("horaInicio"));
                e.setHoraFin(rs.getInt("horaFin"));
                e.setDias(rs.getString(null));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public boolean actualizarTurno(RH_Turno p) {
        String sql = "update RH.Turnos set idTurno =?, nombre=?, horaInicio=? ,horaFin=?,dias=?"
                + " where idTurno=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(4, p.getIdTurno());
            st.setString(1, p.getNombre());
            st.setInt(2, p.getHoraInicio());
            st.setInt(3, p.getHoraFin());
            st.setString(4, null);
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogicaTurno(RH_Turno p) {
        String sql = "update RH.Turnos set idTurno=? "
                + " where idTurno=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(1, p.getIdTurno());
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
