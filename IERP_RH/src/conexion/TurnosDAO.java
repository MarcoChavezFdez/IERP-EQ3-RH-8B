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
import modelo.RH_Ciudad;
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
        String sql = "insert into RH.Turnos values(?,?,?,?,?)";
        boolean ban = false;
        try {
            try (PreparedStatement st = conexion.getConexion().prepareStatement(sql)) {
                st.setString(1, turno.getNombre());
                st.setTime(2, turno.getHoraInicio());
                st.setTime(3, turno.getHoraFin());
                st.setString(4, turno.getDias());
                st.setString(5, "A");
                st.execute();
            }
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar en la tabla RH.Turnos: " + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Turno> consultaTurnosVista() {
        String sql = "select * from vTurnos "
                + " ORDER BY idTurno ASC";
        ArrayList<RH_Turno> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Turno e = new RH_Turno();
                e.setIdTurno(rs.getInt("idTurno"));
                e.setNombre(rs.getString("nombre"));
                e.setHoraInicio(rs.getTime("horaInicio"));
                e.setHoraFin(rs.getTime("horaFin"));
                e.setDias(rs.getString("dias"));
                lista.add((e));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta general:" + e.getMessage());
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
                e.setHoraInicio(rs.getTime("horaInicio"));
                e.setHoraFin(rs.getTime("horaFin"));
                e.setDias(rs.getString("dias"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta por nombre :" + e.getMessage());
        }
        return lista;
    }

    public RH_Turno consultarTurnoId(Integer idTurno) {
        String sql = "select * "
                + "from RH.Turnos "
                + "where idTurno=?";
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setInt(1, idTurno);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                RH_Turno turno = new RH_Turno();
                turno.setIdTurno(rs.getInt("idTurno"));
                turno.setNombre(rs.getString("nombre"));
                turno.setHoraInicio(rs.getTime("horaInicio"));
                turno.setHoraFin(rs.getTime("horaFin"));
                turno.setDias(rs.getString("dias"));
                rs.close();
                st.close();
                return turno;
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return null;
    }

    public boolean actualizarTurno(RH_Turno p) {
        String sql = "update RH.Turnos set nombre=?, horaInicio=? ,horaFin=?,dias=?"
                + " where idTurno=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(5, p.getIdTurno());
            st.setString(1, p.getNombre());
            st.setTime(2, p.getHoraInicio());
            st.setTime(3, p.getHoraFin());
            st.setString(4, p.getDias());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    //Pendiente de agregar el estatus?
    public boolean eliminacionLogicaTurno(RH_Turno p) {
        String sql = "update RH.Turnos set estatus=? "
                + " where idTurno=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setString(1, "I");
            st.setInt(2, p.getIdTurno());
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
