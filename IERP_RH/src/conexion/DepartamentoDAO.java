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
import modelo.RH_Departamento;

/**
 *
 * @author Marco Chavez
 */
public class DepartamentoDAO {

    private ConexionBD conexion;

    public DepartamentoDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarDepartamento(RH_Departamento estado) {
        String sql = "insert into RH.Departamentos values(?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, estado.getNombre());
            st.setString(2, "A");
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Departamento> consultaDepartamentosVista() {
        String sql = "select * from vDepartamentos "
                + "order by idDepartamento ";

        ArrayList<RH_Departamento> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Departamento e = new RH_Departamento();
                e.setIdDepartamento(rs.getInt("idDepartamento"));
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

    public ArrayList<RH_Departamento> consultaDepartamentosVistaPaginada(Integer pagina) {
        String sql = "select * from vDepartamentos "
                + "order by idDepartamento "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_Departamento> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Departamento e = new RH_Departamento();
                e.setIdDepartamento(rs.getInt("idDepartamento"));
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Departamentos FROM vDepartamentos)/CAST(" + 3 + " AS float)))as paginasMaximas";
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Departamentos FROM vDepartamentos where Nombre like CONCAT( '%','" + nombre + "','%'))/CAST(" + 3 + " AS float)))as paginasMaximas";
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

    public ArrayList<RH_Departamento> consultaDepartamentosNombreVistaPaginada(String nombre, Integer pagina) {
        String sql = "select * "
                + "from vDepartamentos "
                + "where nombre like CONCAT( '%','" + nombre + "','%') "
                + "order by idDepartamento "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_Departamento> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Departamento e = new RH_Departamento();
                e.setIdDepartamento(rs.getInt("idDepartamento"));
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

    public ArrayList<RH_Departamento> consultaDepartamentosNombreVista(String nombre) {
        String sql = "select * "
                + "from RH.Departamentos "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<RH_Departamento> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Departamento e = new RH_Departamento();
                e.setIdDepartamento(rs.getInt("idDepartamento"));
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

    public RH_Departamento consultaDepartamentoNombre(String nombre) {
        String sql = "select * "
                + "from RH.Departamentos "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        RH_Departamento estado = new RH_Departamento();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                estado.setIdDepartamento(rs.getInt("idDepartamento"));
                estado.setNombre(rs.getString("nombre"));
                estado.setEstatus(rs.getString("estatus"));

            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return estado;

    }

    public RH_Departamento consultaDepartamentoId(int idDepartamento) {
        String sql = (" select * "
                + " from RH.Departamentos "
                + " where idDepartamento=" + idDepartamento);
        RH_Departamento estado = new RH_Departamento();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                estado.setIdDepartamento(rs.getInt("idDepartamento"));
                estado.setNombre(rs.getString("nombre"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return estado;
    }

    public boolean actualizarDepartamento(RH_Departamento estado) {
        String sql = "update RH.Departamentos set nombre=?, estatus=? "
                + " where idDepartamento=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(3, estado.getIdDepartamento());
            st.setString(1, estado.getNombre());
            st.setString(2, estado.getEstatus());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(RH_Departamento p) {
        String sql = "update RH.Departamentos set estatus=? "
                + " where idDepartamento=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(2, p.getIdDepartamento());
            st.setString(1, "I");
            st.execute();
            st.close();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionDepartamento(Integer p) {
        String sql = "delete from RH.Departamentos "
                + "where idDepartamento=" + p;
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
