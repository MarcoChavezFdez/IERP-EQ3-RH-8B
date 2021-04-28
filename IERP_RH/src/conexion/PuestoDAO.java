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
import modelo.RH_Puesto;

/**
 *
 * @author Marco Chavez
 */
public class PuestoDAO {

    private ConexionBD conexion;

    public PuestoDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarPuesto(RH_Puesto puesto) {
        String sql = "insert into RH.Puestos values(?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, puesto.getNombre());
            st.setFloat(2, puesto.getSalarioMinimo());
            st.setFloat(3, puesto.getSalarioMaximo());
            st.setString(4, "A");
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Puesto> consultaPuestosVista() {
        String sql = "select * from vPuestos "
                + "order by idPuesto ";
        ArrayList<RH_Puesto> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Puesto e = new RH_Puesto();
                e.setIdPuesto(rs.getInt("idPuesto"));
                e.setNombre(rs.getString("nombre"));
                e.setSalarioMinimo(rs.getFloat("salarioMinimo"));
                e.setSalarioMaximo(rs.getFloat("salarioMaximo"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Puesto> consultaPuestosVistaPaginada(Integer pagina) {
        String sql = "select * from vPuestos "
                + "order by idPuesto "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_Puesto> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Puesto e = new RH_Puesto();
                e.setIdPuesto(rs.getInt("idPuesto"));
                e.setNombre(rs.getString("nombre"));
                e.setSalarioMinimo(rs.getFloat("salarioMinimo"));
                e.setSalarioMaximo(rs.getFloat("salarioMaximo"));
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Puestos FROM vPuestos)/CAST(" + 3 + " AS float)))as paginasMaximas";
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Puestos FROM vPuestos where Nombre like CONCAT( '%','" + nombre + "','%'))/CAST(" + 3 + " AS float)))as paginasMaximas";
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

    public ArrayList<RH_Puesto> consultaPuestosNombreVistaPaginada(String nombre, Integer pagina) {
        String sql = "select * "
                + "from vPuestos "
                + "where nombre like CONCAT( '%','" + nombre + "','%') "
                + "order by idPuesto "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_Puesto> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Puesto e = new RH_Puesto();
                e.setIdPuesto(rs.getInt("idPuesto"));
                e.setNombre(rs.getString("nombre"));
                e.setSalarioMinimo(rs.getFloat("salarioMinimo"));
                e.setSalarioMaximo(rs.getFloat("salarioMaximo"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Puesto> consultaPuestosNombreVista(String nombre) {
        String sql = "select * "
                + "from RH.Puestos "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<RH_Puesto> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Puesto e = new RH_Puesto();
                e.setIdPuesto(rs.getInt("idPuesto"));
                e.setNombre(rs.getString("nombre"));
                e.setSalarioMinimo(rs.getFloat("salarioMinimo"));
                e.setSalarioMaximo(rs.getFloat("salarioMaximo"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_Puesto consultaPuestoNombre(String nombre) {
        String sql = "select * "
                + "from RH.Puestos "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        RH_Puesto puesto = new RH_Puesto();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                puesto.setIdPuesto(rs.getInt("idPuesto"));
                puesto.setNombre(rs.getString("nombre"));
                puesto.setSalarioMinimo(rs.getFloat("salarioMinimo"));
                puesto.setSalarioMaximo(rs.getFloat("salarioMaximo"));
            }
            rs.close();
            st.close();
        } catch (SQLException er) {
            JOptionPane.showMessageDialog(null, "Error:" + er.getMessage());
        }
        return puesto;
    }

    public RH_Puesto consultaPuestoId(int idPuesto) {
        String sql = (" select * "
                + " from RH.Puestos "
                + " where idPuesto=" + idPuesto);
        RH_Puesto puesto = new RH_Puesto();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                puesto.setIdPuesto(rs.getInt("idPuesto"));
                puesto.setNombre(rs.getString("nombre"));
                puesto.setSalarioMinimo(rs.getFloat("salarioMinimo"));
                puesto.setSalarioMaximo(rs.getFloat("salarioMaximo"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return puesto;
    }

    public boolean actualizarPuesto(RH_Puesto puesto) {
        String sql = "update RH.Puestos set nombre=?, salarioMinimo=?, salarioMaximo=? "
                + " where idPuesto=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(4, puesto.getIdPuesto());
            st.setString(1, puesto.getNombre());
            st.setFloat(2, puesto.getSalarioMinimo());
            st.setFloat(3, puesto.getSalarioMaximo());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(RH_Puesto p) {
        String sql = "update RH.Puestos set estatus=? "
                + " where idPuesto=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(2, p.getIdPuesto());
            st.setString(1, "I");
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionPuesto(Integer p) {
        String sql = "delete from RH.Puestos "
                + "where idPuesto=" + p;
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
