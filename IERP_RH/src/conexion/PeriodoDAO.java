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

import modelo.RH_Periodo;

/**
 *
 * @author Marco Chavez
 */
public class PeriodoDAO {
      private ConexionBD conexion;

    public PeriodoDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarPeriodo(RH_Periodo periodo) {
        String sql = "insert into RH.Periodos values(?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, periodo.getNombre());
            st.setDate(2, periodo.getFechaInicio());
            st.setDate(3, periodo.getFechaFin());
            st.setString(4, "A");
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Periodo> consultaPeriodosVista() {
        String sql = "select * from vPeriodos "
                + "order by idPeriodo ";

        ArrayList<RH_Periodo> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Periodo p = new RH_Periodo();
                p.setIdPeriodo(rs.getInt("idPeriodo"));
                p.setNombre(rs.getString("nombre"));
                p.setFechaInicio(rs.getDate("fechaInicio"));
                p.setFechaFin(rs.getDate("fechaFin"));
                lista.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Periodo> consultaPeriodosVistaPaginada(Integer pagina) {
        String sql = "select * from vPeriodos "
                + "order by idPeriodo "
                + "offset " + (pagina - 1) * 5 + " rows "
                + "fetch next 5 rows only ";

        ArrayList<RH_Periodo> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Periodo p = new RH_Periodo();
                p.setIdPeriodo(rs.getInt("idPeriodo"));
                p.setNombre(rs.getString("nombre"));
                p.setFechaInicio(rs.getDate("fechaInicio"));
                p.setFechaFin(rs.getDate("fechaFin"));
                lista.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public Integer consultaPaginas() {
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as periodos FROM vPeriodos )/CAST(" + 5 + " AS float)))as paginasMaximas";
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as periodos FROM vPeriodos where Nombre like CONCAT( '%','" + nombre + "','%'))/CAST(" + 5 + " AS float)))as paginasMaximas";
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

    public ArrayList<RH_Periodo> consultaPeriodosNombreVistaPaginada(String nombre, Integer pagina) {
        String sql = "select * "
                + " from vPeriodos "
                + " where nombre like CONCAT( '%','" + nombre + "','%') "
                + " order by idPeriodo "
                + " offset " + (pagina - 1) * 5 + " rows "
                + " fetch next 5 rows only ";

        ArrayList<RH_Periodo> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Periodo p = new RH_Periodo();
                p.setIdPeriodo(rs.getInt("idPeriodo"));
                p.setNombre(rs.getString("nombre"));
                p.setFechaInicio(rs.getDate("fechaInicio"));
                p.setFechaFin(rs.getDate("fechaFin"));
                lista.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_Periodo consultaPeriodoId(int idPeriodo) {
        String sql = (" select * "
                + " from vPeriodos "
                + " where idPeriodo=" + idPeriodo);
        RH_Periodo a = new RH_Periodo();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                a.setIdPeriodo(rs.getInt("idPeriodo"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaInicio(rs.getDate("fechaInicio"));
                a.setFechaFin(rs.getDate("fechaFin"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return a;
    }

    public boolean actualizarPeriodo(RH_Periodo periodo) {
        String sql = "update RH.Periodos set "
                + " nombre=?, fechaInicio=?, fechaFin=? "
                + " where idPeriodo=? ";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setString(1, periodo.getNombre());
            st.setDate(2, periodo.getFechaInicio());
            st.setDate(3, periodo.getFechaFin());
            st.setInt(4, periodo.getIdPeriodo());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(RH_Periodo p) {
        String sql = "update RH.Periodos set estatus='I' "
                + " where idPeriodo=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(1, p.getIdPeriodo());
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
