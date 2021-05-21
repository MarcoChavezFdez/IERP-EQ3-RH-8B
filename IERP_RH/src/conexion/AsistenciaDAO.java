/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.RH_Asistencia;
import modelo.RH_Empleado;

/**
 *
 * @author Marco Chavez
 */
public class AsistenciaDAO {

    private ConexionBD conexion;

    public AsistenciaDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarAsistencia(RH_Asistencia asistencia) {
        String sql = "insert into RH.Asistencias values(?,?,?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setDate(1, asistencia.getFecha());
            st.setTime(2, asistencia.getHoraEntrada());
            st.setTime(3, asistencia.getHoraSalida());
            st.setString(4, asistencia.getDia());
            st.setInt(5, asistencia.getEmpleado().getIdEmpleado());
            st.setString(6, "A");
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Asistencia> consultaAsistenciasVista() {
        String sql = "select * from vAsistencias "
                + "order by idAsistencia ";

        ArrayList<RH_Asistencia> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Asistencia a = new RH_Asistencia();
                a.setIdAsistencia(rs.getInt("idAsistencia"));
                a.setFecha(rs.getDate("fecha"));
                a.setHoraEntrada(rs.getTime("horaEntrada"));
                a.setHoraSalida(rs.getTime("horaSalida"));
                a.setDia(rs.getString("dia"));
                a.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Asistencia> consultaAsistenciasVistaPaginada(Integer pagina) {
        String sql = "select * from vAsistencias "
                + "order by idAsistencia "
                + "offset " + (pagina - 1) * 10 + " rows "
                + "fetch next 10 rows only ";

        ArrayList<RH_Asistencia> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Asistencia a = new RH_Asistencia();
                a.setIdAsistencia(rs.getInt("idAsistencia"));
                a.setFecha(rs.getDate("fecha"));
                a.setHoraEntrada(rs.getTime("horaEntrada"));
                a.setHoraSalida(rs.getTime("horaSalida"));
                a.setDia(rs.getString("dia"));
                a.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public Integer consultaPaginas() {
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Asistencias FROM vAsistencias)/CAST(" + 10 + " AS float)))as paginasMaximas";
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

    public Integer consultaPaginasFecha(java.sql.Date fechaInicio, java.sql.Date fechaFin) {
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Asistencias FROM vAsistencias where fecha between " + fechaInicio + " and " + fechaFin + ")/CAST(" + 10 + " AS float)))as paginasMaximas";
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

    public ArrayList<RH_Asistencia> consultaAsistenciasFechaVistaPaginada(java.sql.Date fechaInicio, java.sql.Date fechaFin, Integer pagina) {
        String sql = "select * "
                + " from vAsistencias "
                + " where fecha between " + fechaInicio + " and " + fechaFin
                + " order by idAsistencia "
                + " offset " + (pagina - 1) * 10 + " rows "
                + " fetch next 10 rows only ";

        ArrayList<RH_Asistencia> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Asistencia a = new RH_Asistencia();
                a.setIdAsistencia(rs.getInt("idAsistencia"));
                a.setFecha(rs.getDate("fecha"));
                a.setHoraEntrada(rs.getTime("horaEntrada"));
                a.setHoraSalida(rs.getTime("horaSalida"));
                a.setDia(rs.getString("dia"));
                a.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    //Comprobar implementacion 
    public ArrayList<RH_Asistencia> consultaAsistenciaFechaVista(java.sql.Date fechaInicio, java.sql.Date fechaFin) {
        String sql = "select * "
                + "from vAsistencias "
                + " where fecha between " + fechaInicio + " and " + fechaFin;
        ArrayList<RH_Asistencia> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Asistencia a = new RH_Asistencia();
                a.setIdAsistencia(rs.getInt("idAsistencia"));
                a.setFecha(rs.getDate("fecha"));
                a.setHoraEntrada(rs.getTime("horaEntrada"));
                a.setHoraSalida(rs.getTime("horaSalida"));
                a.setDia(rs.getString("dia"));
                a.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_Asistencia consultaAsistenciaId(int idAsistencia) {
        String sql = (" select * "
                + " from vAsistencias "
                + " where idAsistencia=" + idAsistencia);
        RH_Asistencia a = new RH_Asistencia();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                a.setIdAsistencia(rs.getInt("idAsistencia"));
                a.setFecha(rs.getDate("fecha"));
                a.setHoraEntrada(rs.getTime("horaEntrada"));
                a.setHoraSalida(rs.getTime("horaSalida"));
                a.setDia(rs.getString("dia"));
                a.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return a;
    }
    //Consulta asistencia por empleado
    public RH_Asistencia consultaAsistenciaFecha(Date fecha, RH_Empleado empleado) {
        String sql = " select * "
                + " from vAsistencias "
                + " where fecha=? AND idEmpleado =? ";
        RH_Asistencia a=null;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setDate(1, fecha);
            st.setInt(2, empleado.getIdEmpleado());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a = new RH_Asistencia();
                a.setIdAsistencia(rs.getInt("idAsistencia"));
                a.setFecha(rs.getDate("fecha"));
                a.setHoraEntrada(rs.getTime("horaEntrada"));
                a.setHoraSalida(rs.getTime("horaSalida"));
                a.setDia(rs.getString("dia"));
                a.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return a;
    }
    
    public boolean actualizarAsistencia(RH_Asistencia asistencia) {
        String sql = "update RH.Asistencias set fecha=?, horaEntrada=?, horaSalida=?,"
                + " dia=?, idEmpleado=? "
                + " where idAsistencia=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setDate(1, asistencia.getFecha());
            st.setTime(2, asistencia.getHoraEntrada());
            st.setTime(3, asistencia.getHoraSalida());
            st.setString(4, asistencia.getDia());
            st.setInt(5, asistencia.getEmpleado().getIdEmpleado());
            st.setInt(6, asistencia.getIdAsistencia());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(RH_Asistencia a) {
        String sql = "update RH.Asistencias set estatus=? "
                + " where idAsistencia=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setString(1, "I");
            st.setInt(2, a.getIdAsistencia());
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
