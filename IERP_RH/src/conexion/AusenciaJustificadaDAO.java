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
import modelo.RH_AusenciaJustificada;
import modelo.RH_Empleado;

/**
 *
 * @author Marco Chavez
 */
public class AusenciaJustificadaDAO {

    private ConexionBD conexion;

    public AusenciaJustificadaDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarAusenciaJustificada(RH_AusenciaJustificada ausenciaJustificada) {
        String sql = "insert into RH.AusenciasJustificadas values(?,?,?,?,?,?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setDate(1, ausenciaJustificada.getFechaSolicitud());
            st.setDate(2, ausenciaJustificada.getFechaInicio());
            st.setDate(3, ausenciaJustificada.getFechaFin());
            st.setString(4, ausenciaJustificada.getTipo());
            st.setInt(5, ausenciaJustificada.getEmpleadoSolicitador().getIdEmpleado());
            st.setInt(6, ausenciaJustificada.getEmpleadoAutorizador().getIdEmpleado());
            st.setBinaryStream(7, ausenciaJustificada.getEvidencia());
            st.setString(8, ausenciaJustificada.getEstatus());
            st.setString(9, ausenciaJustificada.getMotivo());
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_AusenciaJustificada> consultaAusenciasJustificadasVista() {
        String sql = "select * from vAusenciasJustificadas "
                + "order by idAusencia ";

        ArrayList<RH_AusenciaJustificada> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_AusenciaJustificada a = new RH_AusenciaJustificada();
                a.setIdAusencia(rs.getInt("idAusencia"));
                a.setFechaSolicitud(rs.getDate("fechaSolicitud"));
                a.setFechaInicio(rs.getDate("fechaInicio"));
                a.setFechaFin(rs.getDate("fechaFin"));
                a.setEmpleadoSolicitador(new RH_Empleado(rs.getInt("idEmpleadoSolicita"), this.conexion));
                a.setEmpleadoAutorizador(new RH_Empleado(rs.getInt("idEmpleadoAutoriza"), this.conexion));
                a.setEvidencia(rs.getBinaryStream("evidencia"));
                a.setEstatus(rs.getString("estatus"));
                a.setMotivo(rs.getString("motivo"));
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_AusenciaJustificada> consultaAusenciasJustificadasVistaPaginada(Integer pagina) {
        String sql = "select * from vAusenciasJustificadas "
                + "order by idAusencia "
                + "offset " + (pagina - 1) * 10 + " rows "
                + "fetch next 10 rows only ";

        ArrayList<RH_AusenciaJustificada> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_AusenciaJustificada a = new RH_AusenciaJustificada();
                a.setIdAusencia(rs.getInt("idAusencia"));
                a.setFechaSolicitud(rs.getDate("fechaSolicitud"));
                a.setFechaInicio(rs.getDate("fechaInicio"));
                a.setFechaFin(rs.getDate("fechaFin"));
                a.setEmpleadoSolicitador(new RH_Empleado(rs.getInt("idEmpleadoSolicita"), this.conexion));
                a.setEmpleadoAutorizador(new RH_Empleado(rs.getInt("idEmpleadoAutoriza"), this.conexion));
                a.setEvidencia(rs.getBinaryStream("evidencia"));
                a.setMotivo(rs.getString("motivo"));
                a.setEstatus(rs.getString("estatus"));
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Ausencias FROM vAusenciasJustificadas)/CAST(" + 10 + " AS float)))as paginasMaximas";
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

    public Integer consultaPaginasFecha(java.sql.Date fechaSolicitudInicio, java.sql.Date fechaSolicitudFin) {
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Ausencias FROM vAusenciasJustificadas where fechaSolicitud between " + fechaSolicitudInicio + " and " + fechaSolicitudFin + ")/CAST(" + 10 + " AS float)))as paginasMaximas";
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

    public ArrayList<RH_AusenciaJustificada> consultaAusenciasJustificadasFechaVistaPaginada(java.sql.Date fechaSolicitudInicio, java.sql.Date fechaSolicitudFin, Integer pagina) {
        String sql = "select * "
                + " from vAusenciasJustificadas "
                + " where fechaSolicitud between " + fechaSolicitudInicio + " and " + fechaSolicitudFin
                + " order by idAusencia "
                + " offset " + (pagina - 1) * 10 + " rows "
                + " fetch next 10 rows only ";

        ArrayList<RH_AusenciaJustificada> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_AusenciaJustificada a = new RH_AusenciaJustificada();
                a.setIdAusencia(rs.getInt("idAusencia"));
                a.setFechaSolicitud(rs.getDate("fechaSolicitud"));
                a.setFechaInicio(rs.getDate("fechaInicio"));
                a.setFechaFin(rs.getDate("fechaFin"));
                a.setEmpleadoSolicitador(new RH_Empleado(rs.getInt("idEmpleadoSolicita"), this.conexion));
                a.setEmpleadoAutorizador(new RH_Empleado(rs.getInt("idEmpleadoAutoriza"), this.conexion));
                a.setEvidencia(rs.getBinaryStream("evidencia"));
                a.setEstatus(rs.getString("estatus"));
                a.setMotivo(rs.getString("motivo"));
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

//    public ArrayList<RH_Asistencia> consultaAsistenciaFechaVista(java.sql.Date fechaInicio, java.sql.Date fechaFin) {
//        String sql = "select * "
//                + "from vAsistencias "
//                + " where fecha between " + fechaInicio + " and " + fechaFin;
//        ArrayList<RH_Asistencia> lista = new ArrayList<>();
//        try {
//            Statement st = conexion.getConexion().createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                RH_Asistencia a = new RH_Asistencia();
//                a.setIdAsistencia(rs.getInt("idAsistencia"));
//                a.setFecha(rs.getDate("fecha"));
//                a.setHoraEntrada(rs.getTime("horaEntrada"));
//                a.setHoraSalida(rs.getTime("horaSalida"));
//                a.setDia(rs.getString("dia"));
//                a.setEmpleado(new RH_Empleado(rs.getInt("idEmpleado"), this.conexion));
//                lista.add(a);
//            }
//            rs.close();
//            st.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
//        }
//        return lista;
//    }
    public RH_AusenciaJustificada consultaAusenciaJustificadaId(int idAusencia) {
        String sql = (" select * "
                + " from vAusenciasJustificadas "
                + " where idAusencia=" + idAusencia);
        RH_AusenciaJustificada a = new RH_AusenciaJustificada();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                a.setIdAusencia(rs.getInt("idAusencia"));
                a.setFechaSolicitud(rs.getDate("fechaSolicitud"));
                a.setFechaInicio(rs.getDate("fechaInicio"));
                a.setFechaFin(rs.getDate("fechaFin"));
                a.setEmpleadoSolicitador(new RH_Empleado(rs.getInt("idEmpleadoSolicita"), this.conexion));
                a.setEmpleadoAutorizador(new RH_Empleado(rs.getInt("idEmpleadoAutoriza"), this.conexion));
                a.setEvidencia(rs.getBinaryStream("evidencia"));
                a.setMotivo(rs.getString("motivo"));
                a.setEstatus(rs.getString("estatus"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return a;
    }

    public boolean actualizarAusenciaJustificada(RH_AusenciaJustificada ausenciaJustificada) {
        String sql = "update RH.AusenciasJustificadas set "
                + " fechaSolicitud=?, fechaInicio=?, fechaFin=? "
                + " tipo=?, idEmpleadoSolicita=?, idEmpleadoAutoriza=? "
                + " evidencia=?, motivo=?, estatus=? "
                + " where idAusencia=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setDate(1, ausenciaJustificada.getFechaSolicitud());
            st.setDate(2, ausenciaJustificada.getFechaInicio());
            st.setDate(3, ausenciaJustificada.getFechaFin());
            st.setString(4, ausenciaJustificada.getTipo());
            st.setInt(5, ausenciaJustificada.getEmpleadoSolicitador().getIdEmpleado());
            st.setInt(6, ausenciaJustificada.getEmpleadoAutorizador().getIdEmpleado());
            st.setBinaryStream(7, ausenciaJustificada.getEvidencia());
            st.setString(8, ausenciaJustificada.getMotivo());
            st.setString(9, ausenciaJustificada.getEstatus());
            st.setInt(10, ausenciaJustificada.getIdAusencia());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(RH_AusenciaJustificada a) {
        String sql = "update RH.AusenciasJustificadas set estatus='I' "
                + " where idAusencia=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(1, a.getIdAusencia());
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
